package org.im97mori.ble.sample.lolipop.cscp;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.characteristic.u2a23.SystemIdAndroid;
import org.im97mori.ble.characteristic.u2a24.ModelNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a25.SerialNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a26.FirmwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a27.HardwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a28.SoftwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameStringAndroid;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataListAndroid;
import org.im97mori.ble.characteristic.u2a50.PnpIdAndroid;
import org.im97mori.ble.characteristic.u2a55.SCControlPointAndroid;
import org.im97mori.ble.characteristic.u2a5b.CSCMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a5c.CSCFeatureAndroid;
import org.im97mori.ble.characteristic.u2a5d.SensorLocationAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.profile.cscp.central.CyclingSpeedAndCadenceProfileCallback;
import org.im97mori.ble.profile.cscp.peripheral.CyclingSpeedAndCadenceProfileMockCallback;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.sample.lolipop.cscs.CscsCallbackSample;
import org.im97mori.ble.sample.lolipop.dis.DisCallbackSample;
import org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class CscpCallbackSample extends CyclingSpeedAndCadenceProfileMockCallback implements CyclingSpeedAndCadenceProfileCallback, BLEServerCallback {

    public static class Builder extends CyclingSpeedAndCadenceProfileMockCallback.Builder<CscpCallbackSample> {

        private final SampleCallback mSampleCallback;

        public Builder(@NonNull Context context, SampleCallback sampleCallback, boolean hasDis) {
            super(context, new CscsCallbackSample.Builder(sampleCallback), hasDis ? new DisCallbackSample.Builder(sampleCallback) : null);
            mSampleCallback = sampleCallback;
        }

        @Override
        public CscpCallbackSample build() {
            return new CscpCallbackSample(mContext, mCyclingSpeedAndCadenceServiceMockCallback.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build()
                    , mSampleCallback);
        }
    }

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US);

    private final SampleCallback mSampleCallback;

    public CscpCallbackSample(Context context, SampleCallback sampleCallback) {
        this(context, null, null, sampleCallback);
    }

    public CscpCallbackSample(Context context, CyclingSpeedAndCadenceServiceMockCallback cyclingSpeedAndCadenceServiceMockCallback, DeviceInformationServiceMockCallback deviceInformationServiceMockCallback, SampleCallback sampleCallback) {
        super(context, cyclingSpeedAndCadenceServiceMockCallback, deviceInformationServiceMockCallback);
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
            mSampleCallback.onCallbacked(Pair.create(now, stackTraceElementArray[index].getMethodName()));
        } else {
            mSampleCallback.onCallbacked(Pair.create(now, stackTraceElementArray[index].getMethodName() + '\n' + TextUtils.join("\n", logs)));
        }
    }

    @Override
    public void onScanFinished(@NonNull Set<BluetoothDevice> bluetoothDeviceSet, long timeout, @Nullable Bundle argument) {
        if (!bluetoothDeviceSet.isEmpty() && mSampleCallback instanceof CscpCentralSampleActivity) {
            ((CscpCentralSampleActivity) mSampleCallback).mBluetoothDevice = bluetoothDeviceSet.iterator().next();
        }
        callback(Arrays.toString(bluetoothDeviceSet.toArray()));
    }

    @Override
    public void onScanFailed(int errorCode, @Nullable Bundle argument) {
        callback(errorCode);
    }

    @Override
    public void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        callback(bluetoothDevice);
    }

    @Override
    public void onBondFailed(@NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, status);
    }

    @Override
    public void onBondTimeout(@NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, timeout);
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
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, timeout, argument);
    }

    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, Arrays.toString(values), argument);
    }

    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        callback(characteristicUUID, descriptorUUID, status, argument);
    }

    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
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
    public void onServerStarted() {
        callback();
    }

    @Override
    public void onServerStopped() {
        callback();
    }

    @Override
    public void onDeviceConnected(BluetoothDevice device) {
        callback(device);
    }

    @Override
    public void onDeviceDisconnected(BluetoothDevice device) {
        callback(device);
    }

    @Override
    public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        callback(bluetoothGattService.getUuid());
        return false;
    }

    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        callback(argument);
    }

    @Override
    public void onServiceRemoveSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        callback(argument);
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
        callback(device, bluetoothGattCharacteristic.getUuid(), requestId, offset);
        return false;
    }

    @Override
    public boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        callback(device, bluetoothGattCharacteristic.getUuid(), requestId, offset);
        return false;
    }

    @Override
    public boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean force) {
        callback(device, bluetoothGattDescriptor.getUuid(), requestId, offset);
        return false;
    }

    @Override
    public boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        callback(device, bluetoothGattDescriptor.getUuid(), requestId, offset);
        return false;
    }

    @Override
    public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
        callback(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(value), argument);
    }

    @Override
    public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    @Override
    public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    @Override
    public boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, boolean execute, boolean force) {
        callback(device, execute);
        return false;
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
        return false;
    }

    @Override
    public void setup(@NonNull BLEServerConnection bleServerConnection) {
        callback();
    }

    @Override
    public void tearDown(@NonNull BLEServerConnection bleServerConnection) {
        callback();
    }

    @Override
    public void onCSCFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CSCFeatureAndroid cscFeatureAndroid, @Nullable Bundle argument) {
        callback(Arrays.toString(cscFeatureAndroid.getCscFeature()), argument);
    }

    @Override
    public void onCSCFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onCSCFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onCSCMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(clientCharacteristicConfigurationAndroid.getBytes()));
    }

    @Override
    public void onCSCMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onCSCMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onCSCMeasurementNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId);
    }

    @Override
    public void onCSCMeasurementNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onCSCMeasurementNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onCSCMeasurementNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId);
    }

    @Override
    public void onCSCMeasurementNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onCSCMeasurementNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onCSCMeasurementNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CSCMeasurementAndroid cscMeasurementAndroid) {
        callback(bluetoothDevice
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , cscMeasurementAndroid.getFlags()
                , cscMeasurementAndroid.getCumulativeWheelRevolutions()
                , cscMeasurementAndroid.getLastWheelEventTime()
                , cscMeasurementAndroid.getCumulativeCrankRevolutions()
                , cscMeasurementAndroid.getLastCrankEventTime());
    }

    @Override
    public void onSensorLocationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SensorLocationAndroid sensorLocationAndroid, @Nullable Bundle argument) {
        callback(sensorLocationAndroid.getSensorLocation());
    }

    @Override
    public void onSensorLocationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onSensorLocationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onSCControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SCControlPointAndroid scControlPointAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, scControlPointAndroid.getOpCode(), scControlPointAndroid.getRequestOpCode(), scControlPointAndroid.getResponseValue(), Arrays.toString(scControlPointAndroid.getResponseParameter()));
    }

    @Override
    public void onSCControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onSCControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onSCControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(clientCharacteristicConfigurationAndroid.getBytes()));
    }

    @Override
    public void onSCControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onSCControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onSCControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId);
    }

    @Override
    public void onSCControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onSCControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onSCControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId);
    }

    @Override
    public void onSCControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onSCControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onSCControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SCControlPointAndroid scControlPointAndroid) {
        callback(bluetoothDevice, serviceInstanceId, characteristicUUID, characteristicInstanceId, scControlPointAndroid.getOpCode(), scControlPointAndroid.getRequestOpCode(), scControlPointAndroid.getResponseValue(), Arrays.toString(scControlPointAndroid.getResponseParameter()));
    }

    @Override
    public void onManufacturerNameStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ManufacturerNameStringAndroid manufacturerNameString, @Nullable Bundle argument) {
        callback(manufacturerNameString.getManufacturerName());
    }

    @Override
    public void onManufacturerNameStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onManufacturerNameStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onModelNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ModelNumberStringAndroid modelNumberStringAndroid, @Nullable Bundle argument) {
        callback(modelNumberStringAndroid.getModelNumber());
    }

    @Override
    public void onModelNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onModelNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onSerialNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SerialNumberStringAndroid serialNumberStringAndroid, @Nullable Bundle argument) {
        callback(serialNumberStringAndroid.getSerialNumber());
    }

    @Override
    public void onSerialNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onSerialNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onHardwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HardwareRevisionStringAndroid hardwareRevisionStringAndroid, @Nullable Bundle argument) {
        callback(hardwareRevisionStringAndroid.getHardwareRevision());
    }

    @Override
    public void onHardwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onHardwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onFirmwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FirmwareRevisionStringAndroid firmwareRevisionStringAndroid, @Nullable Bundle argument) {
        callback(firmwareRevisionStringAndroid.getFirmwareRevision());
    }

    @Override
    public void onFirmwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onFirmwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onSoftwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SoftwareRevisionStringAndroid softwareRevisionStringAndroid, @Nullable Bundle argument) {
        callback(softwareRevisionStringAndroid.getSoftwareRevision());
    }

    @Override
    public void onSoftwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onSoftwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onSystemIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SystemIdAndroid systemIdAndroid, @Nullable Bundle argument) {
        callback(systemIdAndroid.getManufacturerIdentifier(), systemIdAndroid.getOrganizationallyUniqueIdentifier());
    }

    @Override
    public void onSystemIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onSystemIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onIEEE_11073_20601_RegulatoryCertificationDataListReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull IEEE_11073_20601_RegulatoryCertificationDataListAndroid ieee_11073_20601_regulatoryCertificationDataListAndroid, @Nullable Bundle argument) {
        callback(serviceUUID, characteristicUUID, ieee_11073_20601_regulatoryCertificationDataListAndroid);
    }

    @Override
    public void onIEEE_11073_20601_RegulatoryCertificationDataListReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onIEEE_11073_20601_RegulatoryCertificationDataListReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onPnPIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PnpIdAndroid pnpIdAndroid, @Nullable Bundle argument) {
        callback(pnpIdAndroid.getVendorIdSource(), pnpIdAndroid.isVendorIsSourceBluetoothSig(), pnpIdAndroid.isVendorIsSourceBluetoothUsb(), pnpIdAndroid.getVendorId(), pnpIdAndroid.getProductId(), pnpIdAndroid.getProductVersion());
    }

    @Override
    public void onPnPIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onPnPIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

}
