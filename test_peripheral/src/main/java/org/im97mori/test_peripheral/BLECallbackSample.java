package org.im97mori.test_peripheral;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import android.util.Pair;

import org.im97mori.ble.BLECallback;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class BLECallbackSample implements BLECallback {

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US);

    private SampleCallback mSampleCallback;

    BLECallbackSample(SampleCallback sampleCallback) {
        mSampleCallback = sampleCallback;
    }

    private void callback(Object... logs) {
        int index = 0;
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if (BLECallbackSample.class.getName().equals(stackTraceElement.getClassName())
                    && "callback".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }

        String now;
        synchronized (format) {
            now = format.format(new Date());
            format.notifyAll();
        }
        if (logs.length == 0) {
            mSampleCallback.onCallbacked(Pair.create(now, stackTraceElementArray[index].getMethodName()));
        } else {
            mSampleCallback.onCallbacked(Pair.create(now, stackTraceElementArray[index].getMethodName() + '\n' + TextUtils.join("\n", logs)));
        }
    }

    @Override
    public void onBLEConnected(BluetoothDevice bluetoothDevice) {
        callback();
    }

    @Override
    public void onBLEConnectTimeout(BluetoothDevice bluetoothDevice) {
        callback();
    }

    @Override
    public void onBLEDisonnected(BluetoothDevice bluetoothDevice) {
        callback();
    }

    @Override
    public void onCharacteristicReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {
        callback(characteristicUUID, Arrays.toString(values));
    }

    @Override
    public void onCharacteristicReadFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, int status) {
        callback(status);
    }

    @Override
    public void onCharacteristicReadTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, long timeout) {
        callback(characteristicUUID, timeout);
    }

    @Override
    public void onCharacteristicWriteSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {
        callback(characteristicUUID, Arrays.toString(values));
    }

    @Override
    public void onCharacteristicWriteFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, int status) {
        callback(characteristicUUID, status);
    }

    @Override
    public void onCharacteristicWriteTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, long timeout) {
        callback(characteristicUUID, timeout);
    }

    @Override
    public void onDescriptorReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, byte[] values) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values));
    }

    @Override
    public void onDescriptorReadFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, int status) {
        callback(characteristicUUID, descriptorUUID, status);
    }

    @Override
    public void onDescriptorReadTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, long timeout) {
        callback(characteristicUUID, descriptorUUID, timeout);
    }

    @Override
    public void onDescriptorWriteSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, byte[] values) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values));
    }

    @Override
    public void onDescriptorWriteFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, int status) {
        callback(characteristicUUID, descriptorUUID, status);
    }

    @Override
    public void onDescriptorWriteTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, long timeout) {
        callback(characteristicUUID, descriptorUUID, timeout);
    }

    @Override
    public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {
        callback(characteristicUUID, characteristicUUID, Arrays.toString(values));
    }
}
