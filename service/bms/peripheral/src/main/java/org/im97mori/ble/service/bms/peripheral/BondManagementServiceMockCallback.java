package org.im97mori.ble.service.bms.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_80;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_81;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ServiceUUID.BOND_MANAGEMENT_SERVICE;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
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
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPoint;
import org.im97mori.ble.characteristic.u2aa5.BondManagementFeatures;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Bond Management Service (Service UUID: 0x181e) for Peripheral
 */
public class BondManagementServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link BondManagementServiceMockCallback}
     *
     * @param <T> subclass of {@link BondManagementServiceMockCallback}
     */
    public static class Builder<T extends BondManagementServiceMockCallback> extends AbstractServiceMockCallback.Builder<BondManagementServiceMockCallback> {

        /**
         * Bond Management Control Point data
         */
        protected BondManagementControlPointCharacteristicData mBondManagementControlPointCharacteristicData;

        /**
         * Bond Management Feature data
         */
        protected CharacteristicData mBondManagementFeaturesData;

        /**
         * add Bond Management Control Point characteristic
         *
         * @param delay                                                     response delay(millis)
         * @param deleteBondOfRequestingDeviceBrEdrLeResponseCode           response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (BR/EDR and LE) response)
         * @param deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode      Delete bond of requesting device (BR/EDR and LE)'s Authorization Code
         * @param deleteBondOfRequestingDeviceBrEdrResponseCode             response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (BR/EDR transport only) response)
         * @param deleteBondOfRequestingDeviceBrEdrAuthorizationCode        Delete bond of requesting device (BR/EDR transport only)'s Authorization Code
         * @param deleteBondOfRequestingDeviceLeResponseCode                response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (LE transport only) response)
         * @param deleteBondOfRequestingDeviceLeAuthorizationCode           Delete bond of requesting device (LE transport only)'s Authorization Code
         * @param deleteAllBondsOnServerBrEdrLeResponseCode                 response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (BR/EDR and LE) response)
         * @param deleteAllBondsOnServerBrEdrLeAuthorizationCode            Delete all bonds on server (BR/EDR and LE)'s Authorization Code
         * @param deleteAllBondsOnServerBrEdrResponseCode                   response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (BR/EDR transport only) response)
         * @param deleteAllBondsOnServerBrEdrAuthorizationCode              Delete all bonds on server (BR/EDR transport only)'s Authorization Code
         * @param deleteAllBondsOnServerLeResponseCode                      response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (BR/EDR transport only) response)
         * @param deleteAllBondsOnServerLeAuthorizationCode                 Delete all bonds on server  (BR/EDR transport only)'s Authorization Code
         * @param deleteAllButTheActiveBondOnServerBrEdrLeResponseCode      response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (BR/EDR and LE) response)
         * @param deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode Delete all but the active bond on server (BR/EDR and LE)'s Authorization Code
         * @param deleteAllButTheActiveBondOnServerBrEdrResponseCode        response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (BR/EDR transport only) response)
         * @param deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode   Delete all but the active bond on server (BR/EDR transport only)'s Authorization Code
         * @param deleteAllButTheActiveBondOnServerLeResponseCode           response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (LE transport only) response)
         * @param deleteAllButTheActiveBondOnServerLeAuthorizationCode      Delete all but the active bond on server (LE transport only)'s Authorization Code
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addBondManagementControlPoint(long delay
                , int deleteBondOfRequestingDeviceBrEdrLeResponseCode
                , @Nullable String deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , int deleteBondOfRequestingDeviceBrEdrResponseCode
                , @Nullable String deleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , int deleteBondOfRequestingDeviceLeResponseCode
                , @Nullable String deleteBondOfRequestingDeviceLeAuthorizationCode
                , int deleteAllBondsOnServerBrEdrLeResponseCode
                , @Nullable String deleteAllBondsOnServerBrEdrLeAuthorizationCode
                , int deleteAllBondsOnServerBrEdrResponseCode
                , @Nullable String deleteAllBondsOnServerBrEdrAuthorizationCode
                , int deleteAllBondsOnServerLeResponseCode
                , @Nullable String deleteAllBondsOnServerLeAuthorizationCode
                , int deleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , @Nullable String deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , int deleteAllButTheActiveBondOnServerBrEdrResponseCode
                , @Nullable String deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , int deleteAllButTheActiveBondOnServerLeResponseCode
                , @Nullable String deleteAllButTheActiveBondOnServerLeAuthorizationCode) {
            mBondManagementControlPointCharacteristicData = new BondManagementControlPointCharacteristicData(delay
                    , deleteBondOfRequestingDeviceBrEdrLeResponseCode
                    , deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                    , deleteBondOfRequestingDeviceBrEdrResponseCode
                    , deleteBondOfRequestingDeviceBrEdrAuthorizationCode
                    , deleteBondOfRequestingDeviceLeResponseCode
                    , deleteBondOfRequestingDeviceLeAuthorizationCode
                    , deleteAllBondsOnServerBrEdrLeResponseCode
                    , deleteAllBondsOnServerBrEdrLeAuthorizationCode
                    , deleteAllBondsOnServerBrEdrResponseCode
                    , deleteAllBondsOnServerBrEdrAuthorizationCode
                    , deleteAllBondsOnServerLeResponseCode
                    , deleteAllBondsOnServerLeAuthorizationCode
                    , deleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                    , deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                    , deleteAllButTheActiveBondOnServerBrEdrResponseCode
                    , deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                    , deleteAllButTheActiveBondOnServerLeResponseCode
                    , deleteAllButTheActiveBondOnServerLeAuthorizationCode);
            return this;
        }

        /**
         * remove Bond Management Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBondManagementControlPoint() {
            mBondManagementControlPointCharacteristicData = null;
            return this;
        }

        /**
         * @see #addBondManagementFeatures(byte[])
         */
        @NonNull
        public Builder<T> addBondManagementFeatures(@NonNull BondManagementFeatures bondManagementFeatures) {
            return addBondManagementFeatures(bondManagementFeatures.getBytes());
        }

        /**
         * @see #addBondManagementFeatures(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBondManagementFeatures(@NonNull byte[] value) {
            return addBondManagementFeatures(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Bond Management Features characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addBondManagementFeatures(int responseCode, long delay, @NonNull byte[] value) {
            mBondManagementFeaturesData = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
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
         * remove Bond Management Features characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBondManagementFeatures() {
            mBondManagementFeaturesData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mBondManagementFeaturesData == null) {
                throw new RuntimeException("no Bond Management Feature data");
            } else {
                characteristicList.add(mBondManagementFeaturesData);
            }

            if (mBondManagementControlPointCharacteristicData == null) {
                throw new RuntimeException("no Bond Management Control Point data");
            } else {
                Pattern pattern = Pattern.compile("[1-9]+");
                if (mBondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete bond of requesting device (BR/EDR and LE)'s Authorization Code is not digit");
                } else if (mBondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete bond of requesting device (BR/EDR transport only)'s Authorization Code is not digit");
                } else if (mBondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceLeAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceLeAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete bond of requesting device (LE transport only)'s Authorization Code is not digit");
                } else if (mBondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrLeAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrLeAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete all bonds on server (BR/EDR and LE)'s Authorization Code is not digit");
                } else if (mBondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete all bonds on server (BR/EDR transport only)'s Authorization Code is not digit");
                } else if (mBondManagementControlPointCharacteristicData.deleteAllBondsOnServerLeAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteAllBondsOnServerLeAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete all bonds on server (LE transport only)'s Authorization Code is not digit");
                } else if (mBondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete all but the active bond on server (BR/EDR and LE)'s Authorization Code is not digit");
                } else if (mBondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete all but the active bond on server (BR/EDR transport only)'s Authorization Code");
                } else if (mBondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerLeAuthorizationCode != null
                        && !pattern.matcher(mBondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerLeAuthorizationCode).matches()) {
                    throw new RuntimeException("Delete all but the active bond on server (LE transport only)'s Authorization Code");
                }
                characteristicList.add(mBondManagementControlPointCharacteristicData);
            }

            ServiceData serviceData = new ServiceData(BOND_MANAGEMENT_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BondManagementServiceMockCallback build() {
            return new BondManagementServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public BondManagementServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
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

                    if (BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                        int responseCode = APPLICATION_ERROR_81;

                        if (characteristicData instanceof BondManagementControlPointCharacteristicData) {
                            BondManagementControlPointCharacteristicData bondManagementControlPointCharacteristicData = (BondManagementControlPointCharacteristicData) characteristicData;
                            BondManagementControlPoint bondManagementControlPoint = new BondManagementControlPoint(value);
                            CharacteristicData bondManagementFeatureData = findCharacteristicData(BOND_MANAGEMENT_SERVICE, BOND_MANAGEMENT_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                            if (bondManagementFeatureData != null) {
                                BondManagementFeatures bondManagementFeatures = new BondManagementFeatures(bondManagementFeatureData.getBytes());
                                String operand = bondManagementControlPoint.getOperand();
                                if (bondManagementControlPoint.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrLeAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrLeResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrLeResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteBondOfRequestingDeviceBrEdr()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesDeleteBondOfCurrentConnectionBrEdrAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceBrEdrResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteBondOfRequestingDeviceLe()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesDeleteBondOfCurrentConnectionLeNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesDeleteBondOfCurrentConnectionLeAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceLeAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceLeAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceLeResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteBondOfRequestingDeviceLeResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteAllBondsOnServerBrEdrLe()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesRemoveAllBondsOnServerBrEdrLeAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrLeAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrLeAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrLeResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrLeResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteAllBondsOnServerBrEdr()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesRemoveAllBondsOnServerBrEdrNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesRemoveAllBondsOnServerBrEdrAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteAllBondsOnServerBrEdrResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteAllBondsOnServerLe()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesRemoveAllBondsOnServerLeNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesRemoveAllBondsOnServerLeAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteAllBondsOnServerLeAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteAllBondsOnServerLeAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteAllBondsOnServerLeResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteAllBondsOnServerLeResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrLeAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesRemoveAllButTheActiveBondOnServerBrEdrAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerBrEdrResponseCode;
                                        }
                                    }
                                } else if (bondManagementControlPoint.isOpCodeDeleteAllButTheActiveBondOnServerLe()) {
                                    if (bondManagementFeatures.isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeNotSupported()) {
                                        responseCode = APPLICATION_ERROR_80;
                                    } else {
                                        if (bondManagementFeatures.isBondManagementFeaturesRemoveAllButTheActiveBondOnServerLeAuthorizationCodeRequired()) {
                                            if (bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerLeAuthorizationCode != null
                                                    && bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerLeAuthorizationCode.equals(operand)) {
                                                responseCode = bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerLeResponseCode;
                                            }
                                        } else {
                                            responseCode = bondManagementControlPointCharacteristicData.deleteAllButTheActiveBondOnServerLeResponseCode;
                                        }
                                    }
                                }
                            }
                        }
                        result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);
                    } else {
                        if (responseNeeded) {
                            result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, preparedWrite ? value : null);
                        } else {
                            result = true;
                        }

                        if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                            mIsReliable |= preparedWrite;

                            if (mIsReliable) {
                                characteristicData.temporaryData.put(offset, value);
                            } else {
                                characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);
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
