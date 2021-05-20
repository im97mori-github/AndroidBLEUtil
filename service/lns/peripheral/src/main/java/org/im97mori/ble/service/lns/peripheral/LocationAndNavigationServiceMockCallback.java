package org.im97mori.ble.service.lns.peripheral;

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
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a67.LocationAndSpeed;
import org.im97mori.ble.characteristic.u2a68.Navigation;
import org.im97mori.ble.characteristic.u2a69.PositionQuality;
import org.im97mori.ble.characteristic.u2a6a.LNFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCATION_AND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POSITION_QUALITY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;
import static org.im97mori.ble.BLEConstants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;

/**
 * Location and Navigation (Service UUID: 0x1819) for Peripheral
 */
public class LocationAndNavigationServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link LocationAndNavigationServiceMockCallback}
     *
     * @param <T> subclass of {@link LocationAndNavigationServiceMockCallback}
     */
    public static class Builder<T extends LocationAndNavigationServiceMockCallback> extends AbstractServiceMockCallback.Builder<LocationAndNavigationServiceMockCallback> {

        /**
         * LN Feature data
         */
        protected CharacteristicData mLNFeature;

        /**
         * Location and Speed data
         */
        protected CharacteristicData mLocationAndSpeed;

        /**
         * Position Quality data
         */
        protected CharacteristicData mPositionQuality;

        /**
         * LN Control Point data
         */
        protected LNControlPointCharacteristicData mLNControlPoint;

        /**
         * Navigation data
         */
        protected CharacteristicData mNavigation;

        /**
         * @see #addLNFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLNFeature(@NonNull LNFeature lnFeature) {
            return addLNFeature(BluetoothGatt.GATT_SUCCESS, 0, lnFeature.getBytes());
        }

        /**
         * add LN Feature characteristic
         *
         * @param responseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        characteristic response delay(millis)
         * @param value        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addLNFeature(int responseCode, long delay, @NonNull byte[] value) {
            mLNFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove LN Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeLNFeature() {
            mLNFeature = null;
            return this;
        }

        /**
         * @see #addLocationAndSpeed(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocationAndSpeed(@NonNull LocationAndSpeed locationAndSpeed, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addLocationAndSpeed(BluetoothGatt.GATT_SUCCESS, 0, locationAndSpeed.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Location and Speed characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Location and Speed notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addLocationAndSpeed(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
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
         * remove Location and Speed characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeLocationAndSpeed() {
            mLocationAndSpeed = null;
            return this;
        }

        /**
         * @see #addPositionQuality(int, long, byte[])
         */
        @NonNull
        public Builder<T> addPositionQuality(@NonNull PositionQuality positionQuality) {
            return addPositionQuality(BluetoothGatt.GATT_SUCCESS, 0, positionQuality.getBytes());
        }

        /**
         * add Position Quality characteristic
         *
         * @param responseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        characteristic response delay(millis)
         * @param value        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addPositionQuality(int responseCode, long delay, @NonNull byte[] value) {
            mPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Position Quality characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePositionQuality() {
            mPositionQuality = null;
            return this;
        }

        /**
         * add LN Control Point characteristic
         *
         * @param characteristicResponseCode                             characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay                                    characteristic response delay(millis)
         * @param setCumulativeValueResponseValue                        characteristic response code (Set Cumulative Value response)
         * @param maskLocationAndSpeedCharacteristicContentResponseValue characteristic response code (Mask Location and Speed Characteristic Content response)
         * @param navigationControlResponseValue                         characteristic response code (Navigation Control response)
         * @param requestNumberOfRoutesResponseValue                     characteristic response code (Request Number of Routes response)
         * @param requestNumberOfRoutesResponseParameter                 part of characteristic data array (Number of Routes)
         * @param requestNameOfRouteResponseValue                        characteristic response code (Request Name of Route response)
         * @param requestNameOfRouteResponseParameter                    part of characteristic data array (Name of Route)
         * @param selectRouteResponseValue                               characteristic response code (Select Route response)
         * @param setFixRateResponseValue                                characteristic response code (Set Fix Rate response)
         * @param setElevationResponseValue                              characteristic response code (Set Elevation response)
         * @param descriptorResponseCode                                 descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                                        characteristic response delay(millis)
         * @param descriptorValue                                        descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addLNControlPoint(int characteristicResponseCode
                , long characteristicDelay
                , int setCumulativeValueResponseValue
                , int maskLocationAndSpeedCharacteristicContentResponseValue
                , int navigationControlResponseValue
                , int requestNumberOfRoutesResponseValue
                , @NonNull byte[] requestNumberOfRoutesResponseParameter
                , int requestNameOfRouteResponseValue
                , @NonNull byte[] requestNameOfRouteResponseParameter
                , int selectRouteResponseValue
                , int setFixRateResponseValue
                , int setElevationResponseValue
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mLNControlPoint = new LNControlPointCharacteristicData(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE
                    , BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , setCumulativeValueResponseValue
                    , maskLocationAndSpeedCharacteristicContentResponseValue
                    , navigationControlResponseValue
                    , requestNumberOfRoutesResponseValue
                    , requestNumberOfRoutesResponseParameter
                    , requestNameOfRouteResponseValue
                    , requestNameOfRouteResponseParameter
                    , selectRouteResponseValue
                    , setFixRateResponseValue
                    , setElevationResponseValue);
            return this;
        }

        /**
         * remove LN Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeLNControlPoint() {
            mLNControlPoint = null;
            return this;
        }

        /**
         * @see #addNavigation(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addNavigation(@NonNull Navigation navigation, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addNavigation(BluetoothGatt.GATT_SUCCESS, 0, navigation.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Navigation characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Navigation notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            characteristic response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addNavigation(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
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
         * remove Location and Speed characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeNavigation() {
            mNavigation = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mLNFeature == null) {
                throw new RuntimeException("no LN Feature data");
            } else {
                characteristicList.add(mLNFeature);
            }

            if (mLocationAndSpeed == null) {
                throw new RuntimeException("no Location and Speed data");
            } else {
                characteristicList.add(mLocationAndSpeed);
            }

            LNFeature lnFeature = new LNFeature(mLNFeature.data);

            if (mPositionQuality == null) {
                if (lnFeature.isLNFeatureNumberOfBeaconsInSolutionSupported()
                        || lnFeature.isLNFeatureNumberOfBeaconsInViewSupported()
                        || lnFeature.isLNFeatureTimeToFirstFixSupported()
                        || lnFeature.isLNFeatureEstimatedHorizontalPositionErrorSupported()
                        || lnFeature.isLNFeatureEstimatedVerticalPositionErrorSupported()
                        || lnFeature.isLNFeatureHorizontalDilutionOfPrecisionSupported()
                        || lnFeature.isLNFeatureVerticalDilutionOfPrecisionSupported()
                        || lnFeature.isLNFeaturePositionStatusSupported()) {
                    throw new RuntimeException("no Position Quality data");
                }
            } else {
                characteristicList.add(mPositionQuality);
            }

            if (mNavigation == null) {
                if (lnFeature.isLNFeatureRemainingDistanceSupported()
                        || lnFeature.isLNFeatureRemainingVerticalDistanceSupported()
                        || lnFeature.isLNFeatureEstimatedTimeOfArrivalSupported()
                        || lnFeature.isLNFeaturePositionStatusSupported()) {
                    throw new RuntimeException("no Navigation data");
                }
            } else {
                characteristicList.add(mNavigation);
            }

            if (mLNControlPoint == null) {
                if (lnFeature.isLNFeatureTotalDistanceSupported()
                        || lnFeature.isLNFeatureLocationAndSpeedCharacteristicContentMaskingSupported()
                        || mNavigation != null
                        || lnFeature.isLNFeatureFixRateSettingSupported()
                        || lnFeature.isLNFeatureElevationSettingSupported()) {
                    throw new RuntimeException("no LN Control Point data");
                }
            } else {
                characteristicList.add(mLNControlPoint);
            }


            ServiceData serviceData = new ServiceData(LOCATION_AND_NAVIGATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LocationAndNavigationServiceMockCallback build() {
            return new LocationAndNavigationServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public LocationAndNavigationServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
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

                            if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                                BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                                if (bluetoothGattDescriptor != null) {
                                    int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);

                                    startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, characteristicData.delay, 1, null);
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
