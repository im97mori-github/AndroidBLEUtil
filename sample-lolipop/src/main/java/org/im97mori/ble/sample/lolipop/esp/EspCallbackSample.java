package org.im97mori.ble.sample.lolipop.esp;

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
import org.im97mori.ble.characteristic.u2a00.DeviceNameAndroid;
import org.im97mori.ble.characteristic.u2a01.AppearanceAndroid;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlagAndroid;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddressAndroid;
import org.im97mori.ble.characteristic.u2a04.PeripheralPreferredConnectionParametersAndroid;
import org.im97mori.ble.characteristic.u2a05.ServiceChangedAndroid;
import org.im97mori.ble.characteristic.u2a19.BatteryLevelAndroid;
import org.im97mori.ble.characteristic.u2a23.SystemIdAndroid;
import org.im97mori.ble.characteristic.u2a24.ModelNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a25.SerialNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a26.FirmwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a27.HardwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a28.SoftwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameStringAndroid;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataListAndroid;
import org.im97mori.ble.characteristic.u2a2c.MagneticDeclinationAndroid;
import org.im97mori.ble.characteristic.u2a50.PnpIdAndroid;
import org.im97mori.ble.characteristic.u2a6c.ElevationAndroid;
import org.im97mori.ble.characteristic.u2a6d.PressureAndroid;
import org.im97mori.ble.characteristic.u2a6e.TemperatureAndroid;
import org.im97mori.ble.characteristic.u2a6f.HumidityAndroid;
import org.im97mori.ble.characteristic.u2a70.TrueWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a71.TrueWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a72.ApparentWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a73.ApparentWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a74.GustFactorAndroid;
import org.im97mori.ble.characteristic.u2a75.PollenConcentrationAndroid;
import org.im97mori.ble.characteristic.u2a76.UVIndexAndroid;
import org.im97mori.ble.characteristic.u2a77.IrradianceAndroid;
import org.im97mori.ble.characteristic.u2a78.RainfallAndroid;
import org.im97mori.ble.characteristic.u2a79.WindChillAndroid;
import org.im97mori.ble.characteristic.u2a7a.HeatIndexAndroid;
import org.im97mori.ble.characteristic.u2a7b.DewPointAndroid;
import org.im97mori.ble.characteristic.u2a7d.DescriptorValueChangedAndroid;
import org.im97mori.ble.characteristic.u2aa0.MagneticFluxDensity2DAndroid;
import org.im97mori.ble.characteristic.u2aa1.MagneticFluxDensity3DAndroid;
import org.im97mori.ble.characteristic.u2aa3.BarometricPressureTrendAndroid;
import org.im97mori.ble.characteristic.u2aa6.CentralAddressResolutionAndroid;
import org.im97mori.ble.characteristic.u2ac9.ResolvablePrivateAddressOnlyAndroid;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeaturesAndroid;
import org.im97mori.ble.characteristic.u2b2a.DatabaseHashAndroid;
import org.im97mori.ble.characteristic.u2bf5.LeGattSecurityLevelsAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormatAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfigurationAndroid;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurementAndroid;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSettingAndroid;
import org.im97mori.ble.profile.esp.central.EnvironmentalSensingProfileCallback;
import org.im97mori.ble.profile.esp.peripheral.EnvironmentalSensingProfileMockCallback;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.sample.lolipop.bas.BasCallbackSample;
import org.im97mori.ble.sample.lolipop.dis.DisCallbackSample;
import org.im97mori.ble.sample.lolipop.ess.EssCallbackSample;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class EspCallbackSample extends EnvironmentalSensingProfileMockCallback implements EnvironmentalSensingProfileCallback, BLEServerCallback {

    public static class Builder extends EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> {

        private final SampleCallback mSampleCallback;

        public Builder(@NonNull Context context, SampleCallback sampleCallback, boolean isDisSupported, boolean isBasSupported) {
            super(context
                    , new EssCallbackSample.Builder(sampleCallback)
                    , isDisSupported ? new DisCallbackSample.Builder(sampleCallback) : null
                    , isBasSupported ? new BasCallbackSample.Builder(sampleCallback) : null);
            mSampleCallback = sampleCallback;
        }

        @Override
        public EspCallbackSample build() {
            return new EspCallbackSample(mContext
                    , mEnvironmentalSensingServiceMockCallbackBuilder.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build()
                    , mBatteryServiceMockCallbackBuilder == null ? null : mBatteryServiceMockCallbackBuilder.build()
                    , mSampleCallback);
        }
    }

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US);

    private final SampleCallback mSampleCallback;

    public EspCallbackSample(Context context, SampleCallback sampleCallback) {
        this(context, null, null, null, sampleCallback);
    }

    public EspCallbackSample(Context context
            , EnvironmentalSensingServiceMockCallback alertNotificationServiceMockCallback
            , DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
            , BatteryServiceMockCallback batteryServiceMockCallback
            , SampleCallback sampleCallback) {
        super(context, alertNotificationServiceMockCallback, deviceInformationServiceMockCallback, batteryServiceMockCallback);
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
    public void onScanFinished(@NonNull Set<BluetoothDevice> bluetoothDeviceSet, long timeout, @Nullable Bundle argument) {
        if (!bluetoothDeviceSet.isEmpty() && mSampleCallback instanceof EspCentralSampleActivity) {
            ((EspCentralSampleActivity) mSampleCallback).mBluetoothDevice = bluetoothDeviceSet.iterator().next();
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
    public void onServerStarted() {
        callback();
    }

    @Override
    public void onServerStopped() {
        callback();
    }

    @Override
    public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        callback(device);
    }

    @Override
    public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
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
    public void onMtuChanged(BluetoothDevice device, int mtu) {
        callback(device, mtu);
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
    public void onDescriptorValueChangedClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(clientCharacteristicConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDescriptorValueChangedClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDescriptorValueChangedClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDescriptorValueChangedIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , argument);
    }

    @Override
    public void onDescriptorValueChangedIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDescriptorValueChangedIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDescriptorValueChangedIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , argument);
    }

    @Override
    public void onDescriptorValueChangedIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDescriptorValueChangedIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDescriptorValueChangedIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DescriptorValueChangedAndroid descriptorValueChangedAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(descriptorValueChangedAndroid.getBytes()));
    }

    @Override
    public void onApparentWindDirectionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(apparentWindDirectionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindDirectionValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindDirectionValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindDirectionNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(apparentWindDirectionAndroid.getBytes()));
    }

    @Override
    public void onApparentWindSpeedReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindSpeedAndroid apparentWindDirectionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(apparentWindDirectionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onApparentWindSpeedValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onApparentWindSpeedValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onApparentWindSpeedNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindSpeedAndroid apparentWindSpeedAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(apparentWindSpeedAndroid.getBytes()));
    }

    @Override
    public void onDewPointReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DewPointAndroid dewPointAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(dewPointAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onDewPointNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onDewPointNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onDewPointValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onDewPointValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onDewPointNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DewPointAndroid dewPointAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(dewPointAndroid.getBytes()));
    }

    @Override
    public void onElevationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ElevationAndroid elevationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(elevationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onElevationNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onElevationNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onElevationValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onElevationValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onElevationNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ElevationAndroid elevationAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(elevationAndroid.getBytes()));
    }

    @Override
    public void onGustFactorReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull GustFactorAndroid gustFactorAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(gustFactorAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onGustFactorNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onGustFactorNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onGustFactorValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onGustFactorValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onGustFactorNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull GustFactorAndroid gustFactorAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(gustFactorAndroid.getBytes()));
    }

    @Override
    public void onHeatIndexReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HeatIndexAndroid heatIndexAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(heatIndexAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onHeatIndexNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onHeatIndexNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHeatIndexValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHeatIndexValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHeatIndexNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HeatIndexAndroid heatIndexAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(heatIndexAndroid.getBytes()));
    }

    @Override
    public void onHumidityReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HumidityAndroid humidityAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(humidityAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onHumidityNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onHumidityNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onHumidityValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onHumidityValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onHumidityNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HumidityAndroid humidityAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(humidityAndroid.getBytes()));
    }

    @Override
    public void onIrradianceReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull IrradianceAndroid irradianceAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(irradianceAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onIrradianceNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onIrradianceNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onIrradianceValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onIrradianceValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onIrradianceNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull IrradianceAndroid irradianceAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(irradianceAndroid.getBytes()));
    }

    @Override
    public void onPollenConcentrationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PollenConcentrationAndroid pollenConcentrationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(pollenConcentrationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPollenConcentrationValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPollenConcentrationNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PollenConcentrationAndroid pollenConcentrationAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(pollenConcentrationAndroid.getBytes()));
    }

    @Override
    public void onRainfallReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull RainfallAndroid rainfallAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(rainfallAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onRainfallNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onRainfallNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {

    }

    @Override
    public void onRainfallCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onRainfallValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onRainfallValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onRainfallNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull RainfallAndroid rainfallAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(rainfallAndroid.getBytes()));
    }

    @Override
    public void onPressureReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PressureAndroid pressureAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(pressureAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onPressureNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onPressureNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onPressureValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onPressureValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onPressureNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PressureAndroid pressureAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , pressureAndroid.getBytes());
    }

    @Override
    public void onTemperatureReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TemperatureAndroid temperatureAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(temperatureAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onTemperatureNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onTemperatureNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTemperatureValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTemperatureNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TemperatureAndroid temperatureAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(temperatureAndroid.getBytes()));
    }

    @Override
    public void onTrueWindDirectionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindDirectionAndroid trueWindDirectionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(trueWindDirectionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindDirectionValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindDirectionValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindDirectionNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindDirectionAndroid trueWindDirectionAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(trueWindDirectionAndroid.getBytes()));
    }

    @Override
    public void onTrueWindSpeedReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindSpeedAndroid trueWindSpeedAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(trueWindSpeedAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onTrueWindSpeedValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onTrueWindSpeedValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onTrueWindSpeedNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindSpeedAndroid trueWindSpeedAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(trueWindSpeedAndroid.getBytes()));
    }

    @Override
    public void onUVIndexReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull UVIndexAndroid uvIndexAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(uvIndexAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onUVIndexNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onUVIndexNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onUVIndexValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onUVIndexValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onUVIndexNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull UVIndexAndroid uvIndexAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(uvIndexAndroid.getBytes()));
    }

    @Override
    public void onWindChillReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull WindChillAndroid windChillAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(windChillAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onWindChillNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onWindChillNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onWindChillValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onWindChillValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onWindChillNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull WindChillAndroid windChillAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(windChillAndroid.getBytes()));
    }

    @Override
    public void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull BarometricPressureTrendAndroid barometricPressureTrendAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(barometricPressureTrendAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onBarometricPressureTrendValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onBarometricPressureTrendValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onBarometricPressureTrendNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull BarometricPressureTrendAndroid barometricPressureTrendAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(barometricPressureTrendAndroid.getBytes()));
    }

    @Override
    public void onMagneticDeclinationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticDeclinationAndroid magneticDeclinationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(magneticDeclinationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticDeclinationValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticDeclinationValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticDeclinationNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticDeclinationAndroid magneticDeclinationAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(magneticDeclinationAndroid.getBytes()));
    }

    @Override
    public void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity2DAndroid magneticFluxDensity2DAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(magneticFluxDensity2DAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity2DNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity2DAndroid magneticFluxDensity2DAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(magneticFluxDensity2DAndroid.getBytes()));
    }

    @Override
    public void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity3DAndroid magneticFluxDensity3DAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(magneticFluxDensity3DAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingMeasurementAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingTriggerSettingAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(environmentalSensingConfigurationAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(characteristicUserDescriptionAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , Arrays.toString(validRangeAndroid.getBytes())
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , status
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , descriptorInstanceId
                , timeout
                , argument);
    }

    @Override
    public void onMagneticFluxDensity3DNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity3DAndroid magneticFluxDensity3DAndroid) {
        callback(bluetoothDevice
                , serviceUUID
                , serviceInstanceId
                , characteristicUUID
                , characteristicInstanceId
                , Arrays.toString(magneticFluxDensity3DAndroid.getBytes()));
    }

    @Override
    public void onManufacturerNameStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ManufacturerNameStringAndroid manufacturerNameStringAndroid, @Nullable Bundle argument) {
        callback(manufacturerNameStringAndroid.getManufacturerName());
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
        callback();
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
        callback(pnpIdAndroid.getVendorId(), pnpIdAndroid.getProductId());
    }

    @Override
    public void onPnPIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onPnPIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onBatteryLevelReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, batteryLevelAndroid.getLevel());
    }

    @Override
    public void onBatteryLevelReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, status);
    }

    @Override
    public void onBatteryLevelReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, timeout);
    }

    @Override
    public void onBatteryLevelClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, Arrays.toString(clientCharacteristicConfigurationAndroid.getProperties()));
    }

    @Override
    public void onBatteryLevelClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, status);
    }

    @Override
    public void onBatteryLevelClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, timeout);
    }

    @Override
    public void onBatteryLevelCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, characteristicPresentationFormatAndroid.getFormat(), characteristicPresentationFormatAndroid.getExponent(), characteristicPresentationFormatAndroid.getUnit(), characteristicPresentationFormatAndroid.getNamespace(), characteristicPresentationFormatAndroid.getDescription());
    }

    @Override
    public void onBatteryLevelCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, status);
    }

    @Override
    public void onBatteryLevelCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, timeout);
    }

    @Override
    public void onBatteryLevelNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index);
    }

    @Override
    public void onBatteryLevelNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index);
    }

    @Override
    public void onBatteryLevelNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index);
    }

    @Override
    public void onBatteryLevelNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index);
    }

    @Override
    public void onBatteryLevelNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index);
    }

    @Override
    public void onBatteryLevelNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index);
    }

    @Override
    public void onBatteryLevelNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BatteryLevelAndroid batteryLevelAndroid) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, index, batteryLevelAndroid.getLevel());
    }

    @Override
    public void onServiceChangedClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, Arrays.toString(clientCharacteristicConfigurationAndroid.getBytes()));
    }

    @Override
    public void onServiceChangedClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status);
    }

    @Override
    public void onServiceChangedClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout);
    }

    @Override
    public void onServiceChangedIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId);
    }

    @Override
    public void onServiceChangedIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status);
    }

    @Override
    public void onServiceChangedIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout);
    }

    @Override
    public void onServiceChangedIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId);
    }

    @Override
    public void onServiceChangedIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status);
    }

    @Override
    public void onServiceChangedIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout);
    }

    @Override
    public void onServiceChangedIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ServiceChangedAndroid serviceChangedAndroid) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(serviceChangedAndroid.getBytes()));
    }

    @Override
    public void onClientSupportedFeaturesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientSupportedFeaturesAndroid clientSupportedFeaturesAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(clientSupportedFeaturesAndroid.getBytes()));
    }

    @Override
    public void onClientSupportedFeaturesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onClientSupportedFeaturesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onClientSupportedFeaturesWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientSupportedFeaturesAndroid clientSupportedFeaturesAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(clientSupportedFeaturesAndroid.getBytes()));
    }

    @Override
    public void onClientSupportedFeaturesWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onClientSupportedFeaturesWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onDatabaseHashReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DatabaseHashAndroid databaseHashAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(databaseHashAndroid.getBytes()));
    }

    @Override
    public void onDatabaseHashReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onDatabaseHashReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onDeviceNameReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DeviceNameAndroid deviceNameAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(deviceNameAndroid.getBytes()));
    }

    @Override
    public void onDeviceNameReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onDeviceNameReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onDeviceNameWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DeviceNameAndroid deviceNameAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(deviceNameAndroid.getBytes()));
    }

    @Override
    public void onDeviceNameWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onDeviceNameWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onAppearanceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AppearanceAndroid appearanceAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(appearanceAndroid.getBytes()));
    }

    @Override
    public void onAppearanceReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onAppearanceReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onAppearanceWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AppearanceAndroid appearanceAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(appearanceAndroid.getBytes()));
    }

    @Override
    public void onAppearanceWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onAppearanceWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onPeripheralPreferredConnectionParametersReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PeripheralPreferredConnectionParametersAndroid peripheralPreferredConnectionParametersAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(peripheralPreferredConnectionParametersAndroid.getBytes()));
    }

    @Override
    public void onPeripheralPreferredConnectionParametersReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onPeripheralPreferredConnectionParametersReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onCentralAddressResolutionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CentralAddressResolutionAndroid centralAddressResolutionAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(centralAddressResolutionAndroid.getBytes()));
    }

    @Override
    public void onCentralAddressResolutionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onCentralAddressResolutionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onResolvablePrivateAddressOnlyReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ResolvablePrivateAddressOnlyAndroid resolvablePrivateAddressOnlyAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(resolvablePrivateAddressOnlyAndroid.getBytes()));
    }

    @Override
    public void onResolvablePrivateAddressOnlyReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onResolvablePrivateAddressOnlyReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onReconnectionAddressWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReconnectionAddressAndroid reconnectionAddressAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(reconnectionAddressAndroid.getBytes()));
    }

    @Override
    public void onReconnectionAddressWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onReconnectionAddressWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onPeripheralPrivacyFlagReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PeripheralPrivacyFlagAndroid peripheralPrivacyFlagAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(peripheralPrivacyFlagAndroid.getBytes()));
    }

    @Override
    public void onPeripheralPrivacyFlagReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onPeripheralPrivacyFlagReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onPeripheralPrivacyFlagWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PeripheralPrivacyFlagAndroid peripheralPrivacyFlagAndroid, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(peripheralPrivacyFlagAndroid.getBytes()));
    }

    @Override
    public void onPeripheralPrivacyFlagWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onPeripheralPrivacyFlagWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }

    @Override
    public void onLeGattSecurityLevelsReadSuccess(@NonNull Integer integer, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LeGattSecurityLevelsAndroid leGattSecurityLevelsAndroid, @Nullable Bundle bundle) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(leGattSecurityLevelsAndroid.getBytes()));
    }

    @Override
    public void onLeGattSecurityLevelsReadFailed(@NonNull Integer integer, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle bundle) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);
    }

    @Override
    public void onLeGattSecurityLevelsReadTimeout(@NonNull Integer integer, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle bundle) {
        callback(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout);
    }
}
