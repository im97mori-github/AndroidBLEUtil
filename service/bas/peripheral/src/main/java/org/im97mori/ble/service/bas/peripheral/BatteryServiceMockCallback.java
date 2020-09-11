package org.im97mori.ble.service.bas.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BATTERY_SERVICE;

/**
 * Device Information Service (Service UUID: 0x180A) for Peripheral
 */
public class BatteryServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link BatteryServiceMockCallback}
     *
     * @param <T> subclass of {@link BatteryServiceMockCallback}
     */
    public static class Builder<T extends BatteryServiceMockCallback> extends AbstractServiceMockCallback.Builder<BatteryServiceMockCallback> {

        /**
         * Battery Level characteristic map
         */
        protected final Map<Integer, CharacteristicData> mCharacteristicDataMap = new HashMap<>();

        /**
         * Client Characteristic Configuration map
         */
        protected final Map<Integer, DescriptorData> mClientCharacteristicConfigurationMap = new HashMap<>();

        /**
         * Characteristic Presentation Format map
         */
        protected final Map<Integer, DescriptorData> mCharacteristicPresentationFormatMap = new HashMap<>();

        /**
         * @see #addBatteryLevel(int, int, int, long, byte[], int)
         */
        @NonNull
        public Builder<T> addBatteryLevel(int index, @NonNull BatteryLevel batteryLevel) {
            return addBatteryLevel(index, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 0, batteryLevel.getBytes(), -1);
        }

        /**
         * add Battery Level characteristic
         *
         * @param index             Battery Service index
         * @param property          combination of
         *                          {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                          {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responceCode      response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay             responce delay(millis)
         * @param value             data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount notification count
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addBatteryLevel(int index, int property, int responceCode, long delay, @NonNull byte[] value, int notificationCount) {
            mCharacteristicDataMap.put(index, new CharacteristicData(BATTERY_LEVEL_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<DescriptorData>(), responceCode, delay, value, notificationCount));
            return this;
        }

        /**
         * remove Battery Level characteristic
         *
         * @param index Battery Service index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBatteryLevel(int index) {
            mCharacteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setCharacteristicPresentationFormat(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setCharacteristicPresentationFormat(int index, CharacteristicPresentationFormat characteristicPresentationFormat) {
            return setCharacteristicPresentationFormat(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicPresentationFormat.getBytes());
        }

        /**
         * add Battery Level characteristic's Characteristic Presentation Format descriptor
         *
         * @param index        Battery Service index
         * @param responceCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        responce delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setCharacteristicPresentationFormat(int index, int responceCode, long delay, @NonNull byte[] value) {
            mCharacteristicPresentationFormatMap.put(index, new DescriptorData(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responceCode, delay, value));
            return this;
        }

        /**
         * remove Battery Level characteristic's Characteristic Presentation Format descriptor
         *
         * @param index Battery Service index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCharacteristicPresentationFormat(int index) {
            mCharacteristicPresentationFormatMap.remove(index);
            return this;
        }

        /**
         * @see #setClientCharacteristicConfiguration(int, int, long, byte[])
         */
        public Builder<T> setClientCharacteristicConfiguration(int index, ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return setClientCharacteristicConfiguration(index, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Battery Level characteristic's Client Characteristic Configuration descriptor
         *
         * @param index        Battery Service index
         * @param responceCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        responce delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setClientCharacteristicConfiguration(int index, int responceCode, long delay, @NonNull byte[] value) {
            mClientCharacteristicConfigurationMap.put(index, new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, responceCode, delay, value));
            return this;
        }

        /**
         * remove Battery Level characteristic's Client Characteristic Configuration descriptor
         *
         * @param index Battery Service index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeClientCharacteristicConfiguration(int index) {
            mClientCharacteristicConfigurationMap.remove(index);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData createMockData() {
            List<ServiceData> serviceDataList = new ArrayList<>();
            int count = mCharacteristicDataMap.size();
            CharacteristicData characteristicData;
            DescriptorData descriptorData;
            int index;
            for (Map.Entry<Integer, CharacteristicData> entry : mCharacteristicDataMap.entrySet()) {
                index = entry.getKey();
                characteristicData = entry.getValue();
                if (count > 1) {
                    descriptorData = mCharacteristicPresentationFormatMap.get(index);
                    if (descriptorData == null) {
                        descriptorData = new DescriptorData(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UTF_8_STRING, 0, 0, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{0, 0}).getBytes());
                    }
                    characteristicData.descriptorDataList.add(descriptorData);
                }
                if ((BluetoothGattCharacteristic.PROPERTY_NOTIFY & characteristicData.property) != 0) {
                    descriptorData = mClientCharacteristicConfigurationMap.get(index);
                    if (descriptorData == null) {
                        descriptorData = new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    }
                    characteristicData.descriptorDataList.add(descriptorData);
                }
                serviceDataList.add(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(characteristicData)));

            }
            return new MockData(serviceDataList);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryServiceMockCallback build() {
            return new BatteryServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public BatteryServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStarted() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartFailed(@Nullable Integer errorCode) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {

    }

}
