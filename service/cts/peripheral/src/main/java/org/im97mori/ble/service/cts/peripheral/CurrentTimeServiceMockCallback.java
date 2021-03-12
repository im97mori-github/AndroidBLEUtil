package org.im97mori.ble.service.cts.peripheral;

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
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CURRENT_TIME_SERVICE;

/**
 * Current Time Service (Service UUID: 0x1805) for Peripheral
 */
public class CurrentTimeServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link CurrentTimeServiceMockCallback}
     *
     * @param <T> subclass of {@link CurrentTimeServiceMockCallback}
     */
    public static class Builder<T extends CurrentTimeServiceMockCallback> extends AbstractServiceMockCallback.Builder<CurrentTimeServiceMockCallback> {

        /**
         * Current Time Measurement data
         */
        protected CharacteristicData mCurrentTimeData;

        /**
         * Local Time Information data
         */
        protected CharacteristicData mLocalTimeInformationData;

        /**
         * Reference Time Information data
         */
        protected ReferenceTimeInformationCharacteristicData mReferenceTimeInformationData;

        /**
         * @see #addCurrentTime(boolean, int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCurrentTime(@NonNull CurrentTime currentTime, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCurrentTime(true, BluetoothGatt.GATT_SUCCESS, 0, currentTime.getBytes(), 1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Current Time characteristic
         *
         * @param isWritable                 {@code true}:Current Time is writable, {@code false}:read only
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Intermediate Cuff Pressure notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCurrentTime(boolean isWritable, int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            int property = BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY;
            int permission = BluetoothGattCharacteristic.PERMISSION_READ;
            if (isWritable) {
                property |= BluetoothGattCharacteristic.PROPERTY_WRITE;
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mCurrentTimeData = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                    , property
                    , permission
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
         * remove Current Time Pressure characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCurrentTime() {
            mCurrentTimeData = null;
            return this;
        }

        /**
         * @see #addLocalTimeInformation(byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(@NonNull LocalTimeInformation localTimeInformation) {
            return addLocalTimeInformation(localTimeInformation.getBytes());
        }

        /**
         * @see #addLocalTimeInformation(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(@NonNull byte[] value) {
            return addLocalTimeInformation(true, BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Local Time Information characteristic
         *
         * @param isWritable   {@code true}:Local Time Information is writable, {@code false}:read only
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
            int property = BluetoothGattCharacteristic.PROPERTY_READ;
            int permission = BluetoothGattCharacteristic.PERMISSION_READ;
            if (isWritable) {
                property |= BluetoothGattCharacteristic.PROPERTY_WRITE;
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mLocalTimeInformationData = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                    , property
                    , permission
                    , Collections.<DescriptorData>emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Local Time Information characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeLocalTimeInformation() {
            mLocalTimeInformationData = null;
            return this;
        }

        /**
         * @see #addReferenceTimeInformation(byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(@NonNull ReferenceTimeInformation referenceTimeInformation) {
            return addReferenceTimeInformation(referenceTimeInformation.getBytes());
        }

        /**
         * @see #addReferenceTimeInformation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(@NonNull byte[] value) {
            return addReferenceTimeInformation(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Reference Time Information characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(int responseCode, long delay, @NonNull byte[] value) {
            mReferenceTimeInformationData = new ReferenceTimeInformationCharacteristicData(responseCode, delay, value);
            return this;
        }

        /**
         * remove Local Time Information characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeReferenceTimeInformation() {
            mReferenceTimeInformationData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mCurrentTimeData == null) {
                throw new RuntimeException("no Current Time data");
            } else {
                characteristicList.add(mCurrentTimeData);
            }
            if (mLocalTimeInformationData != null) {
                characteristicList.add(mLocalTimeInformationData);
            }
            if (mReferenceTimeInformationData != null) {
                characteristicList.add(mReferenceTimeInformationData);
            }
            ServiceData serviceData = new ServiceData(CURRENT_TIME_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTimeServiceMockCallback build() {
            return new CurrentTimeServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public CurrentTimeServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStarted() {
        updateReferenceTimeInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        boolean result = super.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
        if (result) {
            updateReferenceTimeInformation();
        }
        return result;
    }

    /**
     * update Reference Time Information
     */
    private void updateReferenceTimeInformation() {
        for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> characteristicMap : mRemappedServiceCharacteristicMap.entrySet()) {
            if (CURRENT_TIME_SERVICE.equals(characteristicMap.getKey().first)) {
                for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> mRemappedServiceCharacteristicMapEntry : characteristicMap.getValue().entrySet()) {
                    if (REFERENCE_TIME_INFORMATION_CHARACTERISTIC.equals(mRemappedServiceCharacteristicMapEntry.getKey().first)) {
                        CharacteristicData characteristicData = mRemappedServiceCharacteristicMapEntry.getValue();
                        if (characteristicData instanceof ReferenceTimeInformationCharacteristicData) {
                            ((ReferenceTimeInformationCharacteristicData) characteristicData).lastUpdate = SystemClock.elapsedRealtime();
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force) {
        boolean result = false;

        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
        if (CURRENT_TIME_SERVICE.equals(serviceUUID) && REFERENCE_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                long now = SystemClock.elapsedRealtime();
                int serviceInstanceId = bluetoothGattService.getInstanceId();
                Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
                if (characteristicMap == null) {
                    if (force) {
                        result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                    }
                } else {
                    int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                    CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                    if (characteristicData != null) {
                        delay(now, characteristicData.delay);

                        byte[] data = characteristicData.getBytes();
                        result = bluetoothGattServer.sendResponse(device
                                , requestId
                                , characteristicData.responseCode
                                , offset
                                , Arrays.copyOfRange(data, offset, data.length));
                    }
                }
            }
        } else {
            result = super.onCharacteristicReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattCharacteristic, force);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        boolean result = false;

        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
        if (CURRENT_TIME_SERVICE.equals(serviceUUID) && REFERENCE_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                long now = SystemClock.elapsedRealtime();
                int serviceInstanceId = bluetoothGattService.getInstanceId();
                Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
                if (characteristicMap == null) {
                    if (force) {
                        result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                    }
                } else {
                    int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                    CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                    if (characteristicData != null) {
                        delay(now, characteristicData.delay);

                        result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, null);

                        if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                            characteristicData.currentData = value;

                            for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, DescriptorData>> remappedCharacteristicDescriptorMapEntry : mRemappedCharacteristicDescriptorMap.entrySet()) {
                                if (CURRENT_TIME_CHARACTERISTIC.equals(remappedCharacteristicDescriptorMapEntry.getKey().first)) {
                                    for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : remappedCharacteristicDescriptorMapEntry.getValue().entrySet()) {
                                        if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)) {
                                            if (Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorDataEntry.getValue().getBytes())) {
                                                for (BluetoothDevice targetDevice : mConnectedDeviceSet) {
                                                    if (!device.equals(targetDevice)) {
                                                        startNotification(null
                                                                , bleServerConnection
                                                                , targetDevice
                                                                , CURRENT_TIME_SERVICE
                                                                , serviceInstanceId
                                                                , CURRENT_TIME_CHARACTERISTIC
                                                                , remappedCharacteristicDescriptorMapEntry.getKey().second
                                                                , descriptorDataEntry.getKey().second
                                                                , 0
                                                                , null
                                                                , null);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }

                    if (force && !result) {
                        result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                    }
                }
            }
        } else {
            result = super.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, force);
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
