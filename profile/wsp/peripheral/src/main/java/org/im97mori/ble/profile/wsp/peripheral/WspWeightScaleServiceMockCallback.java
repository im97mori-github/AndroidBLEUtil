package org.im97mori.ble.profile.wsp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.callback.NotificationData;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurement;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;
import org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback;
import org.im97mori.ble.task.NotificationTask;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * Weight Scale Profile specific {@link WeightScaleServiceMockCallback}
 */
public class WspWeightScaleServiceMockCallback extends WeightScaleServiceMockCallback {

    /**
     * Builder for {@link UserDataServiceMockCallback}
     *
     * @param <T> subclass of {@link WspWeightScaleServiceMockCallback}
     */
    public static class Builder<T extends WspWeightScaleServiceMockCallback> extends WeightScaleServiceMockCallback.Builder<WspWeightScaleServiceMockCallback> {

        /**
         * {@link UserDataServiceMockCallback} instance
         */
        protected UserDataServiceMockCallback mUserDataServiceMockCallback;

        /**
         * @param userDataServiceMockCallback {@link UserDataServiceMockCallback} instance
         * @return {@link Builder} instance
         */
        public Builder<T> setUserDataServiceMockCallback(@Nullable UserDataServiceMockCallback userDataServiceMockCallback) {
            mUserDataServiceMockCallback = userDataServiceMockCallback;
            return this;
        }

        /**
         * remove {@link UserDataServiceMockCallback} instance
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeUserDataServiceMockCallback() {
            mUserDataServiceMockCallback = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public WspWeightScaleServiceMockCallback build() {
            if (mUserDataServiceMockCallback == null) {
                throw new RuntimeException("no UserDataServiceMockCallback instance");
            }
            return new WspWeightScaleServiceMockCallback(createData(), false, mUserDataServiceMockCallback);
        }

    }

    private final UserDataServiceMockCallback mUserDataServiceMockCallback;

    /**
     * @param serviceData                 {@link ServiceData} instance
     * @param isFallback                  fallback flag
     * @param userDataServiceMockCallback set if multiple user supported
     * @see WeightScaleServiceMockCallback#WeightScaleServiceMockCallback(ServiceData, boolean)
     */
    public WspWeightScaleServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback, @Nullable UserDataServiceMockCallback userDataServiceMockCallback) {
        super(serviceData, isFallback);
        mUserDataServiceMockCallback = userDataServiceMockCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected synchronized void startNotification(@Nullable Integer taskId, @NonNull BLEServerConnection bleServerConnection, @Nullable BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int descriptorInstanceId, long delay, @Nullable Integer notificationCount, @Nullable Bundle argument) {
        if (mUserDataServiceMockCallback == null) {
            super.startNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, delay, notificationCount, argument);
        } else {
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap != null) {
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    int targetNotificationCount = notificationCount == null ? characteristicData.notificationCount : notificationCount;
                    if (targetNotificationCount != 0) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? characteristicData.notificationCount : notificationCount);
                        bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
                        if (argument != null) {
                            bundle.putBundle(KEY_ORIGINAL_ARGUMENT, argument);
                        }

                        Boolean isConfirm = null;
                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                        if (descriptorDataMap != null) {
                            DescriptorData descriptorData = descriptorDataMap.get(Pair.create(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId));
                            if (descriptorData != null) {
                                if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                    isConfirm = false;
                                } else if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                    isConfirm = true;
                                }
                            }
                        }

                        if (isConfirm != null) {
                            Integer userId = null;
                            if (WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                                WeightMeasurement weightMeasurement = new WeightMeasurement(characteristicData.getBytes());
                                if (weightMeasurement.isFlagsUserIdPresent()) {
                                    userId = weightMeasurement.getUserId();
                                }
                            }

                            NotificationData notificationData;
                            if (device == null) {
                                for (BluetoothDevice bluetoothDevice : mConnectedDeviceMap.keySet()) {
                                    if (mUserDataServiceMockCallback.hasNoConsent(bluetoothDevice, userId)) {
                                        continue;
                                    }
                                    notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                    if (!mActivatedNotificationMap.containsKey(notificationData)) {
                                        Integer newTaskId = bleServerConnection.createNotificationTask(bluetoothDevice
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , characteristicData
                                                , isConfirm
                                                , NotificationTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                        if (newTaskId != null) {
                                            mActivatedNotificationMap.put(notificationData, newTaskId);
                                        }
                                    }
                                }
                            } else {
                                if (mUserDataServiceMockCallback.hasNoConsent(device, userId)) {
                                    return;
                                }
                                notificationData = new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                if (mConnectedDeviceMap.containsKey(device)) {
                                    Integer currentTaskId = mActivatedNotificationMap.get(notificationData);
                                    if (currentTaskId == null || currentTaskId.equals(taskId)) {
                                        Integer newTaskId = bleServerConnection.createNotificationTask(device
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , characteristicData
                                                , isConfirm
                                                , NotificationTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                        if (newTaskId != null) {
                                            mActivatedNotificationMap.put(notificationData, newTaskId);
                                        }
                                    }
                                } else {
                                    mActivatedNotificationMap.remove(notificationData);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
