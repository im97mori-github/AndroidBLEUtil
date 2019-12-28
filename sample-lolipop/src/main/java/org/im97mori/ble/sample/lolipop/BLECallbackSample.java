package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.characteristic.MockControl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@SuppressWarnings("unused")
public class BLECallbackSample extends BLEServerConnection.DefaultServerSetting {

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
    public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < serviceList.size(); i++) {
            BluetoothGattService service = serviceList.get(i);
            List<BluetoothGattCharacteristic> characteristicList = service.getCharacteristics();
            if (characteristicList.isEmpty()) {
                writeServiceList(service.getUuid(), 0, null, 0, null, sb);
            } else {
                for (int j = 0; j < characteristicList.size(); j++) {
                    BluetoothGattCharacteristic characteristic = characteristicList.get(j);
                    List<BluetoothGattDescriptor> descriptorList = characteristic.getDescriptors();
                    if (descriptorList.isEmpty()) {
                        writeServiceList(service.getUuid(), j, characteristic.getUuid(), 0, null, sb);
                    } else {
                        for (int k = 0; k < descriptorList.size(); k++) {
                            BluetoothGattDescriptor descriptor = descriptorList.get(k);
                            writeServiceList(service.getUuid(), j, characteristic.getUuid(), k, descriptor.getUuid(), sb);
                        }
                    }
                }
            }
        }
        callback(sb, argument);
    }

    private void writeServiceList(@NonNull UUID serviceUUID, int characteristicLineNumber, @Nullable UUID characteristicUUID, int descriptorLineNumber, @Nullable UUID descriptorUUID, @NonNull StringBuilder sb) {
        if (characteristicLineNumber == 0) {
            sb.append(serviceUUID.toString().substring(4, 8));
        } else {
            sb.append(serviceUUID.toString().substring(4, 8));
        }
        sb.append('\t');

        if (characteristicUUID != null) {
            if (descriptorLineNumber == 0) {
                sb.append(characteristicUUID.toString().substring(4, 8));
            } else {
                sb.append(characteristicUUID.toString().substring(4, 8));
            }
            sb.append('\t');

            if (descriptorUUID != null) {
                sb.append(descriptorUUID.toString().substring(4, 8));
            }
        }
        sb.append('\n');
    }

    @Override
    public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(timeout, argument);
    }

    @Override
    public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
        callback(mtu, argument);
    }

    @Override
    public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(timeout, argument);
    }

    @Override
    public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT.equals(characteristicUUID)) {
            callback(characteristicUUID, new String(values), argument);
        } else {
            callback(characteristicUUID, Arrays.toString(values), argument);
        }
    }

    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, timeout, argument);
    }

    @Override
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, status, argument);
    }

    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, timeout, argument);
    }

    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, timeout, argument);
    }

    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, timeout, argument);
    }

    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
        if (NOTIFICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID) || INDICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID)) {
            callback(serviceUUID, characteristicUUID, new String(values));
        } else {
            callback(serviceUUID, characteristicUUID, Arrays.toString(values));
        }
    }

    @Override
    public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
        callback(txPhy, rxPhy, argument);
    }

    @Override
    public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(timeout, argument);
    }

    @Override
    public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
        callback(txPhy, rxPhy, phyOptions, argument);
    }

    @Override
    public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(timeout, argument);
    }

    @Override
    public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
        callback(rssi, argument);
    }

    @Override
    public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(timeout, argument);
    }

    @Override
    public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(timeout, argument);
    }

    @Override
    public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(status, argument);
    }

    @Override
    public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(timeout, argument);
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
    public synchronized void onDeviceConnected(@NonNull BluetoothDevice device) {
        callback(device);
        super.onDeviceConnected(device);
    }

    @Override
    public synchronized void onDeviceDisconnected(@NonNull BluetoothDevice device) {
        callback(device);
        super.onDeviceDisconnected(device);
    }

    @Override
    public List<BluetoothGattService> getBluetoothGattServiceList() {
        callback();
        return super.getBluetoothGattServiceList();
    }

    @Override
    public void onCharacteristicReadRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic characteristic) {
        callback(device, characteristic.getUuid());
        super.onCharacteristicReadRequest(bluetoothGattServer, device, requestId, offset, characteristic);
    }

    @Override
    public void onCharacteristicWriteRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value) {
        callback(device, characteristic.getUuid(), preparedWrite, responseNeeded);
        super.onCharacteristicWriteRequest(bluetoothGattServer, device, requestId, characteristic, preparedWrite, responseNeeded, offset, value);
    }

    @Override
    public void onDescriptorReadRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor descriptor) {
        callback(device, descriptor.getUuid());
        super.onDescriptorReadRequest(bluetoothGattServer, device, requestId, offset, descriptor);
    }

    @Override
    public void onDescriptorWriteRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value) {
        callback(device, descriptor.getUuid(), preparedWrite, responseNeeded);
        super.onDescriptorWriteRequest(bluetoothGattServer, device, requestId, descriptor, preparedWrite, responseNeeded, offset, value);
    }

    @Override
    public void onNotificationSent(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int status) {
        callback(device, status);
        super.onNotificationSent(bluetoothGattServer, device, status);
    }

    @Override
    public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] value, Bundle argument) {
        if (NOTIFICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID) || INDICATABLE_CHARACTERISTIC_UUID.equals(characteristicUUID)) {
            callback(serviceUUID, characteristicUUID, new String(value));
        } else {
            callback(serviceUUID, characteristicUUID, Arrays.toString(value));
        }
        super.onNotificationSuccess(taskId, bluetoothGattServer, device, serviceUUID, characteristicUUID, value, argument);
    }

    @Override
    public void onNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
        callback(device, serviceUUID, characteristicUUID, status);
        super.onNotificationFailed(taskId, bluetoothGattServer, device, serviceUUID, characteristicUUID, status, argument);
    }

    @Override
    public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, @Nullable Bundle argument) {
        callback(device, serviceUUID, characteristicUUID, timeout);
        super.onNotificationTimeout(taskId, bluetoothGattServer, device, serviceUUID, characteristicUUID, timeout, argument);
    }

    @Override
    public void onClientCharacteristicConfigurationUpdated(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] value) {
        callback(device, characteristicUUID, Arrays.toString(value));
        super.onClientCharacteristicConfigurationUpdated(bluetoothGattServer, device, serviceUUID, characteristicUUID, value);
    }

    @Override
    public void onMockUpdated(@NonNull BluetoothDevice device, @NonNull MockControl mockControl) {
        callback(device, mockControl.getServiceUUID(), mockControl.getCharacteristicUUID(), mockControl.getDescriptorUUID());
        super.onMockUpdated(device, mockControl);
    }

    @Override
    public void onExecuteWrite(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, boolean execute) {
        callback(device, execute);
        super.onExecuteWrite(bluetoothGattServer, device, requestId, execute);
    }

}
