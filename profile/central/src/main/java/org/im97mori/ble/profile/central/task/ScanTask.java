package org.im97mori.ble.profile.central.task;

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;
import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.task.AbstractBLETask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Scan device task
 * <p>
 * for central role
 */
@SuppressLint("MissingPermission")
public class ScanTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for scan device:10sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 10;

    /**
     * @see #createDeviceFoundMessage(List)
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    public static Message createDeviceFoundMessage(@NonNull ScanResult... results) {
        List<BluetoothDevice> deviceList = new ArrayList<>();
        for (ScanResult scanResult : results) {
            deviceList.add(scanResult.getDevice());
        }
        return createDeviceFoundMessage(deviceList);
    }

    /**
     * @see #createDeviceFoundMessage(List)
     */
    @NonNull
    public static Message createDeviceFoundMessage(@NonNull BluetoothDevice device) {
        return createDeviceFoundMessage(new ArrayList<>(Collections.singletonList(device)));
    }

    /**
     * create device found message
     *
     * @param deviceList found device list
     * @return device found {@link Message} instance
     */
    @NonNull
    public static Message createDeviceFoundMessage(@NonNull List<BluetoothDevice> deviceList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_BLUETOOTH_DEVICE, new ArrayList<>(deviceList));
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_SCAN_FINISHED);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create scan failed message
     *
     * @param status {@link android.bluetooth.le.ScanCallback#onScanFailed} 1st parameter
     * @return scan failed {@link Message} instance
     */
    @NonNull
    public static Message createDeviceScanErrorMessage(int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_SCAN_ERROR);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * {@link Context} instance for {@link Context#getSystemService(String)}
     */
    private final Context mContext;

    /**
     * {@link FilteredScanCallback} instance
     */
    private final FilteredScanCallback mFilteredScanCallback;

    /**
     * {@link FilteredLeScanCallback} instance
     */
    private final FilteredLeScanCallback mFilteredLeScanCallback;

    /**
     * {@link ProfileCallback} instance
     */
    private final ProfileCallback mProfileCallback;

    /**
     * task target {@link TaskHandler} instance
     */
    private final TaskHandler mTaskHandler;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * found {@link BluetoothDevice} set
     */
    private final Set<BluetoothDevice> mFoundDeviceSet = new HashSet<>();

    /**
     * {@link BluetoothAdapter} instance
     */
    private BluetoothAdapter mBluetoothAdapter;

    /**
     * {@link BluetoothLeScanner} instance
     */
    private BluetoothLeScanner mBluetoothLeScanner;

    /**
     * @param context              {@link Context} instance for {@link Context#getSystemService(String)}
     * @param taskHandler          task target {@link TaskHandler} instance
     * @param filteredScanCallback {@link FilteredScanCallback} instance
     * @param profileCallback      {@link ProfileCallback} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScanTask(@NonNull Context context
            , @NonNull TaskHandler taskHandler
            , @NonNull FilteredScanCallback filteredScanCallback
            , @NonNull ProfileCallback profileCallback
            , long timeout
            , @Nullable Bundle argument) {
        mContext = context;
        mFilteredScanCallback = filteredScanCallback;
        mFilteredLeScanCallback = null;
        mProfileCallback = profileCallback;
        mTaskHandler = taskHandler;
        mTimeout = timeout;
        mArgument = argument;
    }

    /**
     * @param context                {@link Context} instance for {@link Context#getSystemService(String)}
     * @param taskHandler            task target {@link TaskHandler} instance
     * @param filteredLeScanCallback {@link FilteredLeScanCallback} instance
     * @param profileCallback        {@link ProfileCallback} instance
     * @param timeout                timeout(millis)
     * @param argument               callback argument
     */
    public ScanTask(@NonNull Context context
            , @NonNull TaskHandler taskHandler
            , @NonNull FilteredLeScanCallback filteredLeScanCallback
            , @NonNull ProfileCallback profileCallback
            , long timeout
            , @Nullable Bundle argument) {
        mContext = context;
        mFilteredScanCallback = null;
        mFilteredLeScanCallback = filteredLeScanCallback;
        mProfileCallback = profileCallback;
        mTaskHandler = taskHandler;
        mTimeout = timeout;
        mArgument = argument;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_SCAN_START);
        Message message = new Message();
        message.setData(bundle);
        message.obj = this;
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(@NonNull Message message) {
        Bundle bundle = message.getData();
        int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

        // timeout
        if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mBluetoothLeScanner.stopScan(mFilteredScanCallback);
            } else {
                mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
            }
            mProfileCallback.onScanFinished(mFoundDeviceSet, mTimeout, mArgument);
            mCurrentProgress = PROGRESS_TIMEOUT;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:scan start
            if (this == message.obj && PROGRESS_SCAN_START == nextProgress) {
                BluetoothManager bluetoothManager = (BluetoothManager) mContext.getSystemService(Context.BLUETOOTH_SERVICE);
                if (bluetoothManager == null) {
                    nextProgress = PROGRESS_FINISHED;
                    mProfileCallback.onScanFailed(UNKNOWN, mArgument);
                } else {
                    mBluetoothAdapter = bluetoothManager.getAdapter();
                    if (mBluetoothAdapter == null) {
                        nextProgress = PROGRESS_FINISHED;
                        mProfileCallback.onScanFailed(UNKNOWN, mArgument);
                    } else {
                        if (mBluetoothAdapter.isEnabled()) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
                                if (mBluetoothLeScanner == null) {
                                    nextProgress = PROGRESS_FINISHED;
                                    mProfileCallback.onScanFailed(UNKNOWN, mArgument);
                                } else {
                                    mBluetoothLeScanner.startScan(mFilteredScanCallback);

                                    // set timeout message
                                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                                }
                            } else {
                                mBluetoothAdapter.startLeScan(mFilteredLeScanCallback);
                            }
                        } else {
                            nextProgress = PROGRESS_FINISHED;
                            mProfileCallback.onScanFailed(UNKNOWN, mArgument);
                        }
                    }
                }

                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_SCAN_START == mCurrentProgress) {
            // current:scan start, next:device found
            if (PROGRESS_SCAN_FINISHED == nextProgress) {
                List<BluetoothDevice> bluetoothDeviceList = bundle.getParcelableArrayList(KEY_BLUETOOTH_DEVICE);
                if (bluetoothDeviceList != null) {
                    mFoundDeviceSet.addAll(bluetoothDeviceList);
                }
            } else if (PROGRESS_SCAN_ERROR == nextProgress) {
                // current:scan start, next:scan error
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mBluetoothLeScanner.stopScan(mFilteredScanCallback);
                } else {
                    mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
                }
                mProfileCallback.onScanFailed(bundle.getInt(KEY_STATUS), mArgument);
                mTaskHandler.removeCallbacksAndMessages(this);
                mCurrentProgress = PROGRESS_FINISHED;
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (mBluetoothLeScanner != null) {
                mBluetoothLeScanner.stopScan(mFilteredScanCallback);
            }
        } else {
            if (mBluetoothAdapter != null) {
                mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
            }
        }
        mProfileCallback.onScanFailed(CANCEL, mArgument);
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
    }

}
