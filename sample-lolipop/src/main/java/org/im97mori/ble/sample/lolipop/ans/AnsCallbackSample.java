package org.im97mori.ble.sample.lolipop.ans;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPointAndroid;
import org.im97mori.ble.characteristic.u2a45.UnreadAlertStatusAndroid;
import org.im97mori.ble.characteristic.u2a46.NewAlertAndroid;
import org.im97mori.ble.characteristic.u2a47.SupportedNewAlertCategoryAndroid;
import org.im97mori.ble.characteristic.u2a48.SupportedUnreadAlertCategoryAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.service.ans.central.AlertNotificationServiceCallback;
import org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class AnsCallbackSample extends AlertNotificationServiceMockCallback implements AlertNotificationServiceCallback, BLECallback {

    public static class Builder extends AlertNotificationServiceMockCallback.Builder<AnsCallbackSample> {

        private final SampleCallback mSampleCallback;

        public Builder(SampleCallback sampleCallback) {
            mSampleCallback = sampleCallback;
        }

        @NonNull
        @Override
        public AnsCallbackSample build() {
            return new AnsCallbackSample(createData(), mSampleCallback);
        }
    }

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US);

    private final SampleCallback mSampleCallback;

    AnsCallbackSample(@NonNull ServiceData serviceData, SampleCallback sampleCallback) {
        super(serviceData, false);
        mSampleCallback = sampleCallback;
    }

    private void callback(Object... logs) {
        int index = 0;
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if (this.getClass().getName().equals(stackTraceElement.getClassName())
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
            mSampleCallback.onCallback(Pair.create(now, stackTraceElementArray[index].getMethodName()));
        } else {
            mSampleCallback.onCallback(Pair.create(now, stackTraceElementArray[index].getMethodName() + '\n' + TextUtils.join("\n", logs)));
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
            sb.append("    ");
        }
        sb.append('\t');

        if (characteristicUUID != null) {
            if (descriptorLineNumber == 0) {
                sb.append(characteristicUUID.toString().substring(4, 8));
            } else {
                sb.append("    ");
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
        callback(characteristicUUID, Arrays.toString(values), argument);
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
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, status, argument);
    }

    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, timeout, argument);
    }

    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, timeout, argument);
    }

    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, timeout, argument);
    }

    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        callback(serviceUUID, characteristicUUID, Arrays.toString(values));
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
    public void onSetNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument) {
        callback(notificationStatus, argument);
    }

    @Override
    public void onSetNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, int status, @Nullable Bundle argument) {
        callback(notificationStatus, status, argument);
    }

    @Override
    public void onServiceChanged(@NonNull BluetoothDevice bluetoothDevice) {
        callback(bluetoothDevice);
    }

    @Override
    public void onServerStarted() {
        callback();
    }

    @Override
    public void onServerStopped() {
        callback();
        super.onServerStopped();
    }

    @Override
    public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        callback(device);
        super.onDeviceConnected(bleServerConnection, device);
    }

    @Override
    public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        callback(device);
        super.onDeviceDisconnected(bleServerConnection, device);
    }

    /** @noinspection deprecation*/
    @Override
    @Deprecated
    public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        callback(bluetoothGattService.getUuid());
        return super.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
    }

    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        callback(argument);
    }

    /** @noinspection deprecation*/
    @Override
    @Deprecated
    public void onServiceRemoveSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        callback(argument);
        super.onServiceRemoveSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
    }

    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force) {
        callback(device, bluetoothGattCharacteristic.getUuid());
        return super.onCharacteristicReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattCharacteristic, force);
    }

    @Override
    public boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        callback(device, bluetoothGattCharacteristic.getUuid());
        return super.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, force);
    }

    @Override
    public boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean force) {
        callback(device, bluetoothGattDescriptor.getUuid());
        return super.onDescriptorReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattDescriptor, false);
    }

    @Override
    public boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        callback(device, bluetoothGattDescriptor.getUuid());
        return super.onDescriptorWriteRequest(bleServerConnection, device, requestId, bluetoothGattDescriptor, preparedWrite, responseNeeded, offset, value, force);
    }

    @Override
    public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
        super.onNotificationSuccess(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, value, argument);
        callback(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(value), argument);
    }

    @Override
    public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
        super.onNotificationFailed(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        callback(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    @Override
    public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        super.onNotificationTimeout(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        callback(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    @Override
    public boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, boolean execute, boolean force) {
        callback(device, execute);
        return super.onExecuteWrite(bleServerConnection, device, requestId, execute, force);
    }

    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
        callback(advertiseSettings);
    }

    @Override
    public void onAdvertisingStartFailed(Integer errorCode) {
        callback(errorCode);
    }

    @Override
    public void onAdvertisingFinished() {
        callback();
    }

    @Override
    public boolean isFallback() {
        callback();
        return super.isFallback();
    }

    @Override
    public void setup(@NonNull BLEServerConnection bleServerConnection) {
        callback();
        super.setup(bleServerConnection);
    }

    @Override
    public void tearDown(@NonNull BLEServerConnection bleServerConnection) {
        callback();
        super.tearDown(bleServerConnection);
    }

    @Override
    public void onSupportedNewAlertCategoryReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedNewAlertCategoryAndroid supportedNewAlertCategoryAndroid, @Nullable Bundle argument) {
        callback(supportedNewAlertCategoryAndroid.getCategoryIdBitMask0(), supportedNewAlertCategoryAndroid.getCategoryIdBitMask1());
    }

    @Override
    public void onSupportedNewAlertCategoryReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onSupportedNewAlertCategoryReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onNewAlertClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(Arrays.toString(clientCharacteristicConfigurationAndroid.getProperties()));
    }

    @Override
    public void onNewAlertClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onNewAlertClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onNewAlertNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onNewAlertNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onNewAlertNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onNewAlertNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onNewAlertNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onNewAlertNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onNewAlertNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull NewAlertAndroid newAlertAndroid) {
        callback(newAlertAndroid.getCategoryId(), newAlertAndroid.getNumberOfNewAlert(), newAlertAndroid.getTextStringInformation());
    }

    @Override
    public void onSupportedUnreadAlertCategoryReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedUnreadAlertCategoryAndroid supportedUnreadAlertCategoryAndroid, @Nullable Bundle argument) {
        callback(supportedUnreadAlertCategoryAndroid.getCategoryIdBitMask0(), supportedUnreadAlertCategoryAndroid.getCategoryIdBitMask1());
    }

    @Override
    public void onSupportedUnreadAlertCategoryReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onSupportedUnreadAlertCategoryReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onUnreadAlertStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(Arrays.toString(clientCharacteristicConfigurationAndroid.getProperties()));
    }

    @Override
    public void onUnreadAlertStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onUnreadAlertStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onUnreadAlertStatusNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onUnreadAlertStatusNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onUnreadAlertStatusNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onUnreadAlertStatusNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onUnreadAlertStatusNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onUnreadAlertStatusNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onUnreadAlertStatusNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UnreadAlertStatusAndroid unreadAlertStatusAndroid) {
        callback(unreadAlertStatusAndroid.getCategoryId(), unreadAlertStatusAndroid.getUnreadCount());
    }

    @Override
    public void onAlertNotificationControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertNotificationControlPointAndroid alertNotificationControlPointAndroid, @Nullable Bundle argument) {
        callback(alertNotificationControlPointAndroid.getCommandId(), alertNotificationControlPointAndroid.getCategoryId());
    }

    @Override
    public void onAlertNotificationControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onAlertNotificationControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

}
