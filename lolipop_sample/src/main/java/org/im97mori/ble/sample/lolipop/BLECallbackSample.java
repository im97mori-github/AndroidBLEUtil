package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEServerConnection;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class BLECallbackSample extends BLEServerConnection.DefaultServerSetting implements BLECallback {

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US);

    private final SampleCallback mSampleCallback;

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
    public void onBLEConnected(long taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
        callback(argument);
    }

    @Override
    public void onBLEConnectFailed(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onBLEConnectTimeout(long taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
        callback(argument);
    }

    @Override
    public void onBLEDisonnected(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
        callback(argument);
    }

    @Override
    public void onCharacteristicReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
        callback(characteristicUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onCharacteristicReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onCharacteristicReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
        callback(characteristicUUID, timeout, argument);
    }

    @Override
    public void onCharacteristicWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
        callback(characteristicUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onCharacteristicWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
        callback(characteristicUUID, status, argument);
    }

    @Override
    public void onCharacteristicWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
        callback(characteristicUUID, timeout, argument);
    }

    @Override
    public void onDescriptorReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
        callback(characteristicUUID, descriptorUUID, timeout, argument);
    }

    @Override
    public void onDescriptorWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
        callback(characteristicUUID, descriptorUUID, timeout, argument);
    }

    @Override
    public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values) {
        if (NOTIFICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID) || INDICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID)) {
            callback(serviceUUID, characteristicUUID, new String(values));
        } else {
            callback(serviceUUID, characteristicUUID, Arrays.toString(values));
        }
    }

    @Override
    public void onServerStarted() {
        callback();
        super.onServerStarted();
    }

    @Override
    public void onServerStopped() {
        callback();
        super.onServerStopped();
    }

    @Override
    public List<BluetoothGattService> getBluetoothGattServiceList() {
        callback();
        return super.getBluetoothGattServiceList();
    }

    @Override
    public boolean onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
        callback(device, characteristic.getUuid());
        return super.onCharacteristicReadRequest(bluetoothGattServer, device, requestId, offset, characteristic);
    }

    @Override
    public boolean onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        callback(device, characteristic.getUuid());
        return super.onCharacteristicWriteRequest(bluetoothGattServer, device, requestId, characteristic, preparedWrite, responseNeeded, offset, value);
    }

    @Override
    public boolean onDescriptorReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
        callback(device, descriptor.getUuid());
        return super.onDescriptorReadRequest(bluetoothGattServer, device, requestId, offset, descriptor);
    }

    @Override
    public boolean onDescriptorWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        callback(device, descriptor.getUuid());
        return super.onDescriptorWriteRequest(bluetoothGattServer, device, requestId, descriptor, preparedWrite, responseNeeded, offset, value);
    }

    @Override
    public void onNotificationSuccess(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] value, Bundle argument) {
        if (NOTIFICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID) || INDICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID)) {
            callback(serviceUUID, characteristicUUID, new String(value));
        } else {
            callback(serviceUUID, characteristicUUID, Arrays.toString(value));
        }
        super.onNotificationSuccess(taskId, bluetoothGattServer, device, serviceUUID, characteristicUUID, value, argument);
    }

    @Override
    public void onNotificationFailed(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
        callback(device, characteristicUUID, status);
        super.onNotificationFailed(taskId, bluetoothGattServer, device, serviceUUID, characteristicUUID, status, argument);
    }

    @Override
    public void onClientCharacteristicConfigurationUpdated(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] value) {
        callback(device, characteristicUUID, Arrays.toString(value));
        super.onClientCharacteristicConfigurationUpdated(bluetoothGattServer, device, serviceUUID, characteristicUUID, value);
    }

}
