package org.im97mori.ble.profile.central.task;

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
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:BLUETOOTH_MANAGER_NOT_FOUND
     */
    public static final int STATUS_BLUETOOTH_MANAGER_NOT_FOUND = -2;

    /**
     * STATUS:BLUETOOTH_ADAPTER_NOT_FOUND
     */
    public static final int STATUS_BLUETOOTH_ADAPTER_NOT_FOUND = -3;

    /**
     * STATUS:BLUETOOTH_LE_SCANNER_NOT_FOUND
     */
    public static final int STATUS_BLUETOOTH_LE_SCANNER_NOT_FOUND = -4;

    /**
     * STATUS:BLUETOOTH_ADAPTER_DISABLED
     */
    public static final int STATUS_BLUETOOTH_ADAPTER_DISABLED = -5;

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * KEY:BLUETOOTH_DEVICE
     */
    public static final String KEY_BLUETOOTH_DEVICE = "KEY_BLUETOOTH_DEVICE";

    /**
     * PROGRESS:SCAN_START
     */
    public static final String PROGRESS_SCAN_START = "PROGRESS_SCAN_START";

    /**
     * PROGRESS:SCAN_FINISHED
     */
    public static final String PROGRESS_SCAN_FINISHED = "PROGRESS_SCAN_FINISHED";

    /**
     * PROGRESS:SCAN_ERROR
     */
    public static final String PROGRESS_SCAN_ERROR = "PROGRESS_SCAN_ERROR";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_SCAN_FINISHED);
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_SCAN_ERROR);
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_SCAN_START);
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
        String nextProgress = bundle.getString(KEY_NEXT_PROGRESS);

        // timeout
        if (this == message.obj && PROGRESS_TIMEOUT.equals(nextProgress)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mBluetoothLeScanner.stopScan(mFilteredScanCallback);
            } else {
                mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
            }
            mProfileCallback.onScanFinished(mFoundDeviceSet, mTimeout, mArgument);
            mCurrentProgress = PROGRESS_TIMEOUT;
        } else if (PROGRESS_INIT.equals(mCurrentProgress)) {
            // current:init, next:scan start
            if (this == message.obj && PROGRESS_SCAN_START.equals(nextProgress)) {
                BluetoothManager bluetoothManager = (BluetoothManager) mContext.getSystemService(Context.BLUETOOTH_SERVICE);
                if (bluetoothManager == null) {
                    nextProgress = PROGRESS_FINISHED;
                    mProfileCallback.onScanFailed(STATUS_BLUETOOTH_MANAGER_NOT_FOUND
                            , mArgument);
                } else {
                    mBluetoothAdapter = bluetoothManager.getAdapter();
                    if (mBluetoothAdapter == null) {
                        nextProgress = PROGRESS_FINISHED;
                        mProfileCallback.onScanFailed(STATUS_BLUETOOTH_ADAPTER_NOT_FOUND
                                , mArgument);
                    } else {
                        if (mBluetoothAdapter.isEnabled()) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
                                if (mBluetoothLeScanner == null) {
                                    nextProgress = PROGRESS_FINISHED;
                                    mProfileCallback.onScanFailed(STATUS_BLUETOOTH_LE_SCANNER_NOT_FOUND
                                            , mArgument);
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
                            mProfileCallback.onScanFailed(STATUS_BLUETOOTH_ADAPTER_DISABLED
                                    , mArgument);
                        }
                    }
                }

                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_SCAN_START.equals(mCurrentProgress)) {
            // current:scan start, next:device found
            if (PROGRESS_SCAN_FINISHED.equals(nextProgress)) {
                List<BluetoothDevice> bluetoothDeviceList = bundle.getParcelableArrayList(KEY_BLUETOOTH_DEVICE);
                if (bluetoothDeviceList != null) {
                    mFoundDeviceSet.addAll(bluetoothDeviceList);
                }
            } else if (PROGRESS_SCAN_ERROR.equals(nextProgress)) {
                // current:scan start, next:scan error
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mBluetoothLeScanner.stopScan(mFilteredScanCallback);
                } else {
                    mBluetoothAdapter.stopLeScan(mFilteredLeScanCallback);
                }
                mProfileCallback.onScanFailed(bundle.getInt(KEY_STATUS)
                        , mArgument);
                mTaskHandler.removeCallbacksAndMessages(this);
                mCurrentProgress = PROGRESS_FINISHED;
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress) || PROGRESS_TIMEOUT.equals(mCurrentProgress);
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
        mProfileCallback.onScanFailed(STATUS_CANCEL
                , mArgument);
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
    }

}
