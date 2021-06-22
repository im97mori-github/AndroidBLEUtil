package org.im97mori.ble.profile.central.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.task.AbstractBLETask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;
import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

/**
 * Scan device task
 * <p>
 * for central role
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
@SuppressLint("MissingPermission")
public class ScanTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for scan device:10sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 10;

    /**
     * @see #createDeviceFoundMessage(List)
     */
    @NonNull
    public static Message createDeviceFoundMessage(@NonNull ScanResult... results) {
        return createDeviceFoundMessage(new ArrayList<>(Arrays.asList(results)));
    }

    /**
     * create device found message
     *
     * @param resultList found device list
     * @return device found {@link Message} instance
     */
    @NonNull
    public static Message createDeviceFoundMessage(@NonNull List<ScanResult> resultList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_BLUETOOTH_DEVICE, new ArrayList<>(resultList));
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
     * {@link FilteredScanCallback} instance
     */
    private final FilteredScanCallback mFilteredScanCallback;

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
     * {@link BluetoothLeScanner} instance
     */
    private BluetoothLeScanner mBluetoothLeScanner;

    /**
     * @param taskHandler          task target {@link TaskHandler} instance
     * @param filteredScanCallback {@link FilteredScanCallback} instance
     * @param profileCallback      {@link ProfileCallback} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     */
    public ScanTask(@NonNull TaskHandler taskHandler
            , @NonNull FilteredScanCallback filteredScanCallback
            , @NonNull ProfileCallback profileCallback
            , long timeout
            , @Nullable Bundle argument) {
        mFilteredScanCallback = filteredScanCallback;
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
            mBluetoothLeScanner.stopScan(mFilteredScanCallback);
            mProfileCallback.onScanFinished(mFoundDeviceSet, mTimeout, mArgument);
            mCurrentProgress = PROGRESS_TIMEOUT;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:scan start
            if (this == message.obj && PROGRESS_SCAN_START == nextProgress) {
                BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (bluetoothAdapter.isEnabled()) {
                    mBluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
                    if (mBluetoothLeScanner == null) {
                        nextProgress = PROGRESS_FINISHED;
                        mProfileCallback.onScanFailed(UNKNOWN, mArgument);
                    } else {
                        mBluetoothLeScanner.startScan(mFilteredScanCallback);

                        // set timeout message
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    }
                }

                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_SCAN_START == mCurrentProgress) {
            // current:scan start, next:device found
            if (PROGRESS_SCAN_FINISHED == nextProgress) {
                List<ScanResult> bluetoothDeviceList = bundle.getParcelableArrayList(KEY_BLUETOOTH_DEVICE);
                if (bluetoothDeviceList != null) {
                    for (ScanResult scanResult : bluetoothDeviceList) {
                        mFoundDeviceSet.add(scanResult.getDevice());
                    }
                }
            } else if (PROGRESS_SCAN_ERROR == nextProgress) {
                // current:scan start, next:scan error
                mBluetoothLeScanner.stopScan(mFilteredScanCallback);
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
        if (mBluetoothLeScanner != null) {
            mBluetoothLeScanner.stopScan(mFilteredScanCallback);
        }
        mProfileCallback.onScanFailed(CANCEL, mArgument);
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
    }

}
