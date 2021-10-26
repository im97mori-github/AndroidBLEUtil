package org.im97mori.ble.sample.jellybean.rcp;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.u2a00.DeviceNameAndroid;
import org.im97mori.ble.characteristic.u2a01.AppearanceAndroid;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlagAndroid;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddressAndroid;
import org.im97mori.ble.characteristic.u2a04.PeripheralPreferredConnectionParametersAndroid;
import org.im97mori.ble.characteristic.u2a05.ServiceChangedAndroid;
import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPointAndroid;
import org.im97mori.ble.characteristic.u2aa5.BondManagementFeaturesAndroid;
import org.im97mori.ble.characteristic.u2aa6.CentralAddressResolutionAndroid;
import org.im97mori.ble.characteristic.u2ac9.ResolvablePrivateAddressOnlyAndroid;
import org.im97mori.ble.characteristic.u2b1d.RCFeatureAndroid;
import org.im97mori.ble.characteristic.u2b1e.RCSettingsAndroid;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPointAndroid;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeaturesAndroid;
import org.im97mori.ble.characteristic.u2b2a.DatabaseHashAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.profile.rcp.central.ReconnectionConfigurationProfileCallback;
import org.im97mori.ble.sample.jellybean.SampleCallback;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class RcpCallbackSample implements ReconnectionConfigurationProfileCallback {

    public static class Builder {

        private final SampleCallback mSampleCallback;

        public Builder(SampleCallback sampleCallback) {
            mSampleCallback = sampleCallback;
        }

        public RcpCallbackSample build() {
            return new RcpCallbackSample(
                    mSampleCallback);
        }
    }

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss", Locale.US);

    private final SampleCallback mSampleCallback;

    public RcpCallbackSample(SampleCallback sampleCallback) {
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
        if (!bluetoothDeviceSet.isEmpty() && mSampleCallback instanceof RcpCentralSampleActivity) {
            ((RcpCentralSampleActivity) mSampleCallback).mBluetoothDevice = bluetoothDeviceSet.iterator().next();
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
    public void onRCFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RCFeatureAndroid rcFeatureAndroid, @Nullable Bundle argument) {
        if (rcFeatureAndroid.isE2eCrcNotSupported()) {
            callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(rcFeatureAndroid.getBytes()));
        } else {
            int calculatedCrc = BLEUtils.createCrc(rcFeatureAndroid.getRcFeatures(), 0, rcFeatureAndroid.getRcFeatures().length);
            int crc = rcFeatureAndroid.getE2eCrc();
            callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, calculatedCrc, crc, Arrays.toString(rcFeatureAndroid.getBytes()));
        }
    }

    @Override
    public void onRCFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onRCFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onRCSettingsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RCSettingsAndroid rcSettingsAndroid, @Nullable Bundle argument) {
        byte[] data = rcSettingsAndroid.getBytes();
        int crc = BLEUtils.createUInt16(data, 3);
        int calculatecCrc = BLEUtils.createCrc(data, 0, 3);

        callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, crc, calculatecCrc, Arrays.toString(rcSettingsAndroid.getBytes()));
    }

    @Override
    public void onRCSettingsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onRCSettingsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onRCSettingsClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(Arrays.toString(clientCharacteristicConfigurationAndroid.getProperties()));
    }

    @Override
    public void onRCSettingsClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onRCSettingsClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onRCSettingsNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onRCSettingsNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onRCSettingsNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onRCSettingsNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onRCSettingsNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onRCSettingsNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onRCSettingsNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RCSettingsAndroid rcSettingsAndroid) {
        byte[] data = rcSettingsAndroid.getBytes();
        int crc = BLEUtils.createUInt16(data, 3);
        int calculatecCrc = BLEUtils.createCrc(data, 0, 3);

        callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, crc, calculatecCrc, Arrays.toString(rcSettingsAndroid.getBytes()));
    }

    @Override
    public void onReconnectionConfigurationControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReconnectionConfigurationControlPointAndroid reconnectionConfigurationControlPointAndroid, @Nullable Bundle argument) {
        callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(reconnectionConfigurationControlPointAndroid.getBytes()));
    }

    @Override
    public void onReconnectionConfigurationControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onReconnectionConfigurationControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
        callback(Arrays.toString(clientCharacteristicConfigurationAndroid.getProperties()));
    }

    @Override
    public void onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onReconnectionConfigurationControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onReconnectionConfigurationControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onReconnectionConfigurationControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onReconnectionConfigurationControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
        callback();
    }

    @Override
    public void onReconnectionConfigurationControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onReconnectionConfigurationControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onReconnectionConfigurationControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReconnectionConfigurationControlPointAndroid reconnectionConfigurationControlPointAndroid) {
        callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(reconnectionConfigurationControlPointAndroid.getBytes()));
    }

    @Override
    public void onBondManagementControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull BondManagementControlPointAndroid bondManagementControlPointAndroid, @Nullable Bundle argument) {
        callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, bondManagementControlPointAndroid.getOpCode(), bondManagementControlPointAndroid.getOperand());
    }

    @Override
    public void onBondManagementControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onBondManagementControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
    }

    @Override
    public void onBondManagementFeaturesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull BondManagementFeaturesAndroid bondManagementFeaturesAndroid, @Nullable Bundle argument) {
        callback(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, Arrays.toString(bondManagementFeaturesAndroid.getBytes()));
    }

    @Override
    public void onBondManagementFeaturesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        callback(status);
    }

    @Override
    public void onBondManagementFeaturesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        callback(timeout);
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

}
