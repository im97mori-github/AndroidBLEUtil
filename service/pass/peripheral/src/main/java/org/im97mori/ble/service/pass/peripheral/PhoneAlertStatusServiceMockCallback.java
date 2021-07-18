package org.im97mori.ble.service.pass.peripheral;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a3f.AlertStatus;
import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.characteristic.u2a41.RingerSetting;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RINGER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RINGER_SETTING_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ErrorCodeAndroid.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ServiceUUID.PHONE_ALERT_STATUS_SERVICE;

/**
 * Phone Alert Status Service (Service UUID: 0x180E) for Peripheral
 */
public class PhoneAlertStatusServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link PhoneAlertStatusServiceMockCallback}
     *
     * @param <T> subclass of {@link PhoneAlertStatusServiceMockCallback}
     */
    public static class Builder<T extends PhoneAlertStatusServiceMockCallback> extends AbstractServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> {

        /**
         * Alert Status data
         */
        protected CharacteristicData mAlertStatusData;

        /**
         * Ringer Setting data
         */
        protected CharacteristicData mRingerSettingData;

        /**
         * Ringer Control point data
         */
        protected CharacteristicData mRingerControlPointData;

        /**
         * @see #addAlertStatus(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAlertStatus(@NonNull AlertStatus alertStatus, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addAlertStatus(BluetoothGatt.GATT_SUCCESS, 0, alertStatus.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Alert Status characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAlertStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mAlertStatusData = new CharacteristicData(ALERT_STATUS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Alert Status characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAlertStatus() {
            mAlertStatusData = null;
            return this;
        }

        /**
         * @see #addRingerSetting(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRingerSetting(@NonNull RingerSetting ringerSetting, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addRingerSetting(BluetoothGatt.GATT_SUCCESS, 0, ringerSetting.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Ringer Setting characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRingerSetting(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mRingerSettingData = new CharacteristicData(RINGER_SETTING_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Ringer Setting characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRingerSetting() {
            mRingerSettingData = null;
            return this;
        }

        /**
         * @see #addRingerControlPoint(byte[])
         */
        @NonNull
        public Builder<T> addRingerControlPoint(@NonNull RingerControlPoint ringerControlPoint) {
            return addRingerControlPoint(ringerControlPoint.getBytes());
        }

        /**
         * @see #addRingerControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRingerControlPoint(@NonNull byte[] value) {
            return addRingerControlPoint(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Ringer Control point characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRingerControlPoint(int responseCode, long delay, @NonNull byte[] value) {
            mRingerControlPointData = new CharacteristicData(RINGER_CONTROL_POINT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
                    , BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Ringer Control point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRingerControlPoint() {
            mRingerControlPointData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mAlertStatusData == null) {
                throw new RuntimeException("no Alert Status data");
            } else {
                characteristicList.add(mAlertStatusData);
            }

            if (mRingerSettingData == null) {
                throw new RuntimeException("no Ringer Setting data");
            } else {
                characteristicList.add(mRingerSettingData);
            }

            if (mRingerControlPointData == null) {
                throw new RuntimeException("no Ringer Control point data");
            } else {
                characteristicList.add(mRingerControlPointData);
            }

            ServiceData serviceData = new ServiceData(PHONE_ALERT_STATUS_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public PhoneAlertStatusServiceMockCallback build() {
            return new PhoneAlertStatusServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public PhoneAlertStatusServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            long now = SystemClock.elapsedRealtime();
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap == null) {
                if (force && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            } else {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    delay(now, characteristicData.delay);

                    if (responseNeeded) {
                        result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, null);
                    } else {
                        result = true;
                    }

                    if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                        mIsReliable |= preparedWrite;

                        if (mIsReliable) {
                            characteristicData.temporaryData = Arrays.copyOfRange(value, offset, value.length);
                        } else {
                            characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);

                            if (RINGER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                                RingerControlPoint requestScControlPoint = new RingerControlPoint(value);

                                CharacteristicData ringerSettingCharacteristic = findCharacteristicData(characteristicMap, RINGER_SETTING_CHARACTERISTIC, CharacteristicData.class);
                                if (ringerSettingCharacteristic != null) {
                                    RingerSetting currentRingerSetting = new RingerSetting(ringerSettingCharacteristic.getBytes());
                                    if (currentRingerSetting.isRingerSettingNormal()) {
                                        if (requestScControlPoint.isRingerControlPointSilentMode()) {
                                            ringerSettingCharacteristic.currentData = new RingerSetting(RingerSetting.RINGER_SETTING_SILENT).getBytes();
                                        }
                                    } else {
                                        if (requestScControlPoint.isRingerControlPointCancelSilentMode()) {
                                            ringerSettingCharacteristic.currentData = new RingerSetting(RingerSetting.RINGER_SETTING_NORMAL).getBytes();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (force && !result && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartFailed(@Nullable Integer errorCode) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {
        // do nothing
    }

}
