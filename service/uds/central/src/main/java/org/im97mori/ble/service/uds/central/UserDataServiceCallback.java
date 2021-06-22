package org.im97mori.ble.service.uds.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a7f.AerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a80.AgeAndroid;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a85.DateOfBirthAndroid;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessmentAndroid;
import org.im97mori.ble.characteristic.u2a87.EmailAddressAndroid;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a8a.FirstNameAndroid;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a8c.GenderAndroid;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMaxAndroid;
import org.im97mori.ble.characteristic.u2a8e.HeightAndroid;
import org.im97mori.ble.characteristic.u2a8f.HipCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a90.LastNameAndroid;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholdsAndroid;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimitAndroid;
import org.im97mori.ble.characteristic.u2a96.VO2MaxAndroid;
import org.im97mori.ble.characteristic.u2a97.WaistCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a98.WeightAndroid;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrementAndroid;
import org.im97mori.ble.characteristic.u2a9a.UserIndexAndroid;
import org.im97mori.ble.characteristic.u2a9f.UserControlPointAndroid;
import org.im97mori.ble.characteristic.u2aa2.LanguageAndroid;
import org.im97mori.ble.characteristic.u2b37.RegisteredUserAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;

import java.util.UUID;

/**
 * User Data (Service UUID: 0x181C) callback
 */
public interface UserDataServiceCallback {

    /**
     * Read First Name success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param firstNameAndroid         {@link FirstNameAndroid}
     * @param argument                 callback argument
     */
    void onFirstNameReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FirstNameAndroid firstNameAndroid
            , @Nullable Bundle argument);

    /**
     * Read First Name error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFirstNameReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read First Name timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFirstNameReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write First Name success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param firstNameAndroid         {@link FirstNameAndroid}
     * @param argument                 callback argument
     */
    void onFirstNameWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FirstNameAndroid firstNameAndroid
            , @Nullable Bundle argument);

    /**
     * Write First Name error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFirstNameWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write First Name timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFirstNameWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Last Name success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param lastNameAndroid          {@link LastNameAndroid}
     * @param argument                 callback argument
     */
    void onLastNameReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull LastNameAndroid lastNameAndroid
            , @Nullable Bundle argument);

    /**
     * Read Last Name error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onLastNameReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Last Name timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onLastNameReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Last Name success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param lastNameAndroid          {@link LastNameAndroid}
     * @param argument                 callback argument
     */
    void onLastNameWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull LastNameAndroid lastNameAndroid
            , @Nullable Bundle argument);

    /**
     * Write Last Name error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onLastNameWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Last Name timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onLastNameWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Email Address success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param emailAddressAndroid      {@link EmailAddressAndroid}
     * @param argument                 callback argument
     */
    void onEmailAddressReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull EmailAddressAndroid emailAddressAndroid
            , @Nullable Bundle argument);

    /**
     * Read Email Address error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onEmailAddressReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Email Address timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onEmailAddressReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Email Address success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param emailAddressAndroid      {@link EmailAddressAndroid}
     * @param argument                 callback argument
     */
    void onEmailAddressWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull EmailAddressAndroid emailAddressAndroid
            , @Nullable Bundle argument);

    /**
     * Write Email Address error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onEmailAddressWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Email Address timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onEmailAddressWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Age success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param ageAndroid               {@link AgeAndroid}
     * @param argument                 callback argument
     */
    void onAgeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AgeAndroid ageAndroid
            , @Nullable Bundle argument);

    /**
     * Read Age error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAgeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Age timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAgeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Age success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param ageAndroid               {@link AgeAndroid}
     * @param argument                 callback argument
     */
    void onAgeWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AgeAndroid ageAndroid
            , @Nullable Bundle argument);

    /**
     * Write Age error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAgeWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Age timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAgeWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Date of Birth success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param dateOfBirthAndroid       {@link DateOfBirthAndroid}
     * @param argument                 callback argument
     */
    void onDateOfBirthReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DateOfBirthAndroid dateOfBirthAndroid
            , @Nullable Bundle argument);

    /**
     * Read Date of Birth error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDateOfBirthReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Date of Birth timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDateOfBirthReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Date of Birth success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param dateOfBirthAndroid       {@link DateOfBirthAndroid}
     * @param argument                 callback argument
     */
    void onDateOfBirthWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DateOfBirthAndroid dateOfBirthAndroid
            , @Nullable Bundle argument);

    /**
     * Write Date of Birth error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDateOfBirthWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Date of Birth timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDateOfBirthWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Gender success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param genderAndroid            {@link GenderAndroid}
     * @param argument                 callback argument
     */
    void onGenderReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull GenderAndroid genderAndroid
            , @Nullable Bundle argument);

    /**
     * Read Gender error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onGenderReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Gender timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGenderReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Gender success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param genderAndroid            {@link GenderAndroid}
     * @param argument                 callback argument
     */
    void onGenderWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull GenderAndroid genderAndroid
            , @Nullable Bundle argument);

    /**
     * Write Gender error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onGenderWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Gender timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGenderWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Weight success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param weightAndroid            {@link WeightAndroid}
     * @param argument                 callback argument
     */
    void onWeightReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull WeightAndroid weightAndroid
            , @Nullable Bundle argument);

    /**
     * Read Weight error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onWeightReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Weight timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWeightReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Weight success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param weightAndroid            {@link WeightAndroid}
     * @param argument                 callback argument
     */
    void onWeightWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull WeightAndroid weightAndroid
            , @Nullable Bundle argument);

    /**
     * Write Weight error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onWeightWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Weight timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWeightWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Height success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param heightAndroid            {@link HeightAndroid}
     * @param argument                 callback argument
     */
    void onHeightReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull HeightAndroid heightAndroid
            , @Nullable Bundle argument);

    /**
     * Read Height error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onHeightReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Height timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeightReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Height success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param heightAndroid            {@link HeightAndroid}
     * @param argument                 callback argument
     */
    void onHeightWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull HeightAndroid heightAndroid
            , @Nullable Bundle argument);

    /**
     * Write Height error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onHeightWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Height timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeightWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read VO2 Max success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param vo2MaxAndroid            {@link VO2MaxAndroid}
     * @param argument                 callback argument
     */
    void onVO2MaxReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull VO2MaxAndroid vo2MaxAndroid
            , @Nullable Bundle argument);

    /**
     * Read VO2 Max error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onVO2MaxReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read VO2 Max timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onVO2MaxReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write VO2 Max success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param vo2MaxAndroid            {@link VO2MaxAndroid}
     * @param argument                 callback argument
     */
    void onVO2MaxWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull VO2MaxAndroid vo2MaxAndroid
            , @Nullable Bundle argument);

    /**
     * Write VO2 Max error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onVO2MaxWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write VO2 Max timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onVO2MaxWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Heart Rate Max success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param heartRateMaxAndroid      {@link HeartRateMaxAndroid}
     * @param argument                 callback argument
     */
    void onHeartRateMaxReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull HeartRateMaxAndroid heartRateMaxAndroid
            , @Nullable Bundle argument);

    /**
     * Read Heart Rate Max error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onHeartRateMaxReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Heart Rate Max timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeartRateMaxReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Heart Rate Max success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param heartRateMaxAndroid      {@link HeartRateMaxAndroid}
     * @param argument                 callback argument
     */
    void onHeartRateMaxWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull HeartRateMaxAndroid heartRateMaxAndroid
            , @Nullable Bundle argument);

    /**
     * Write Heart Rate Max error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onHeartRateMaxWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Heart Rate Max timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeartRateMaxWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Resting Heart Rate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param restingHeartRateAndroid  {@link RestingHeartRateAndroid}
     * @param argument                 callback argument
     */
    void onRestingHeartRateReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull RestingHeartRateAndroid restingHeartRateAndroid
            , @Nullable Bundle argument);

    /**
     * Read Resting Heart Rate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onRestingHeartRateReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Resting Heart Rate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRestingHeartRateReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Resting Heart Rate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param restingHeartRateAndroid  {@link RestingHeartRateAndroid}
     * @param argument                 callback argument
     */
    void onRestingHeartRateWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull RestingHeartRateAndroid restingHeartRateAndroid
            , @Nullable Bundle argument);

    /**
     * Write Resting Heart Rate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onRestingHeartRateWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Resting Heart Rate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRestingHeartRateWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Maximum Recommended Heart Rate success callback
     *
     * @param taskId                             task id
     * @param bluetoothDevice                    BLE device
     * @param serviceUUID                        service {@link UUID}
     * @param serviceInstanceId                  task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                 characteristic {@link UUID}
     * @param characteristicInstanceId           task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param maximumRecommendedHeartRateAndroid {@link MaximumRecommendedHeartRateAndroid}
     * @param argument                           callback argument
     */
    void onMaximumRecommendedHeartRateReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull MaximumRecommendedHeartRateAndroid maximumRecommendedHeartRateAndroid
            , @Nullable Bundle argument);

    /**
     * Read Maximum Recommended Heart Rate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onMaximumRecommendedHeartRateReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Maximum Recommended Heart Rate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMaximumRecommendedHeartRateReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Maximum Recommended Heart Rate success callback
     *
     * @param taskId                             task id
     * @param bluetoothDevice                    BLE device
     * @param serviceUUID                        service {@link UUID}
     * @param serviceInstanceId                  task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                 characteristic {@link UUID}
     * @param characteristicInstanceId           task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param maximumRecommendedHeartRateAndroid {@link MaximumRecommendedHeartRateAndroid}
     * @param argument                           callback argument
     */
    void onMaximumRecommendedHeartRateWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull MaximumRecommendedHeartRateAndroid maximumRecommendedHeartRateAndroid
            , @Nullable Bundle argument);

    /**
     * Write Maximum Recommended Heart Rate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onMaximumRecommendedHeartRateWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Maximum Recommended Heart Rate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMaximumRecommendedHeartRateWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Threshold success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aerobicThresholdAndroid  {@link AerobicThresholdAndroid}
     * @param argument                 callback argument
     */
    void onAerobicThresholdReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AerobicThresholdAndroid aerobicThresholdAndroid
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Threshold error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAerobicThresholdReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Threshold timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAerobicThresholdReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Threshold success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aerobicThresholdAndroid  {@link AerobicThresholdAndroid}
     * @param argument                 callback argument
     */
    void onAerobicThresholdWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AerobicThresholdAndroid aerobicThresholdAndroid
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Threshold error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAerobicThresholdWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Threshold timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAerobicThresholdWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Threshold success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param anaerobicThresholdAndroid {@link AnaerobicThresholdAndroid}
     * @param argument                  callback argument
     */
    void onAnaerobicThresholdReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AnaerobicThresholdAndroid anaerobicThresholdAndroid
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Threshold error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAnaerobicThresholdReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Threshold timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnaerobicThresholdReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Threshold success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param anaerobicThresholdAndroid {@link AnaerobicThresholdAndroid}
     * @param argument                  callback argument
     */
    void onAnaerobicThresholdWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AnaerobicThresholdAndroid anaerobicThresholdAndroid
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Threshold error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAnaerobicThresholdWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Threshold timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnaerobicThresholdWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Sport Type for Aerobic and Anaerobic Thresholds success callback
     *
     * @param taskId                                           task id
     * @param bluetoothDevice                                  BLE device
     * @param serviceUUID                                      service {@link UUID}
     * @param serviceInstanceId                                task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                               characteristic {@link UUID}
     * @param characteristicInstanceId                         task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param sportTypeForAerobicAndAnaerobicThresholdsAndroid {@link SportTypeForAerobicAndAnaerobicThresholdsAndroid}
     * @param argument                                         callback argument
     */
    void onSportTypeForAerobicAndAnaerobicThresholdsReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SportTypeForAerobicAndAnaerobicThresholdsAndroid sportTypeForAerobicAndAnaerobicThresholdsAndroid
            , @Nullable Bundle argument);

    /**
     * Read Sport Type for Aerobic and Anaerobic Thresholds error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onSportTypeForAerobicAndAnaerobicThresholdsReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Sport Type for Aerobic and Anaerobic Thresholds timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onSportTypeForAerobicAndAnaerobicThresholdsReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Sport Type for Aerobic and Anaerobic Thresholds success callback
     *
     * @param taskId                                           task id
     * @param bluetoothDevice                                  BLE device
     * @param serviceUUID                                      service {@link UUID}
     * @param serviceInstanceId                                task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                               characteristic {@link UUID}
     * @param characteristicInstanceId                         task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param sportTypeForAerobicAndAnaerobicThresholdsAndroid {@link SportTypeForAerobicAndAnaerobicThresholdsAndroid}
     * @param argument                                         callback argument
     */
    void onSportTypeForAerobicAndAnaerobicThresholdsWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SportTypeForAerobicAndAnaerobicThresholdsAndroid sportTypeForAerobicAndAnaerobicThresholdsAndroid
            , @Nullable Bundle argument);

    /**
     * Write Sport Type for Aerobic and Anaerobic Thresholds error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onSportTypeForAerobicAndAnaerobicThresholdsWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Sport Type for Aerobic and Anaerobic Thresholds timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onSportTypeForAerobicAndAnaerobicThresholdsWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Date of Threshold Assessment success callback
     *
     * @param taskId                           task id
     * @param bluetoothDevice                  BLE device
     * @param serviceUUID                      service {@link UUID}
     * @param serviceInstanceId                task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID               characteristic {@link UUID}
     * @param characteristicInstanceId         task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param dateOfThresholdAssessmentAndroid {@link DateOfThresholdAssessmentAndroid}
     * @param argument                         callback argument
     */
    void onDateOfThresholdAssessmentReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DateOfThresholdAssessmentAndroid dateOfThresholdAssessmentAndroid
            , @Nullable Bundle argument);

    /**
     * Read Date of Threshold Assessment error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDateOfThresholdAssessmentReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Date of Threshold Assessment timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDateOfThresholdAssessmentReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Date of Threshold Assessment success callback
     *
     * @param taskId                           task id
     * @param bluetoothDevice                  BLE device
     * @param serviceUUID                      service {@link UUID}
     * @param serviceInstanceId                task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID               characteristic {@link UUID}
     * @param characteristicInstanceId         task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param dateOfThresholdAssessmentAndroid {@link DateOfThresholdAssessmentAndroid}
     * @param argument                         callback argument
     */
    void onDateOfThresholdAssessmentWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DateOfThresholdAssessmentAndroid dateOfThresholdAssessmentAndroid
            , @Nullable Bundle argument);

    /**
     * Write Date of Threshold Assessment error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDateOfThresholdAssessmentWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Date of Threshold Assessment timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDateOfThresholdAssessmentWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Waist Circumference success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param waistCircumferenceAndroid {@link WaistCircumferenceAndroid}
     * @param argument                  callback argument
     */
    void onWaistCircumferenceReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull WaistCircumferenceAndroid waistCircumferenceAndroid
            , @Nullable Bundle argument);

    /**
     * Read Waist Circumference error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onWaistCircumferenceReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Waist Circumference timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWaistCircumferenceReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Waist Circumference success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param waistCircumferenceAndroid {@link WaistCircumferenceAndroid}
     * @param argument                  callback argument
     */
    void onWaistCircumferenceWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull WaistCircumferenceAndroid waistCircumferenceAndroid
            , @Nullable Bundle argument);

    /**
     * Write Waist Circumference error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onWaistCircumferenceWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Waist Circumference timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWaistCircumferenceWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Hip Circumference success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param hipCircumferenceAndroid  {@link HipCircumferenceAndroid}
     * @param argument                 callback argument
     */
    void onHipCircumferenceReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull HipCircumferenceAndroid hipCircumferenceAndroid
            , @Nullable Bundle argument);

    /**
     * Read Hip Circumference error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onHipCircumferenceReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Hip Circumference timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHipCircumferenceReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Hip Circumference success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param hipCircumferenceAndroid  {@link HipCircumferenceAndroid}
     * @param argument                 callback argument
     */
    void onHipCircumferenceWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull HipCircumferenceAndroid hipCircumferenceAndroid
            , @Nullable Bundle argument);

    /**
     * Write Hip Circumference error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onHipCircumferenceWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Hip Circumference timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHipCircumferenceWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Fat Burn Heart Rate Lower Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fatBurnHeartRateLowerLimitAndroid {@link FatBurnHeartRateLowerLimitAndroid}
     * @param argument                          callback argument
     */
    void onFatBurnHeartRateLowerLimitReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FatBurnHeartRateLowerLimitAndroid fatBurnHeartRateLowerLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Read Fat Burn Heart Rate Lower Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateLowerLimitReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Fat Burn Heart Rate Lower Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateLowerLimitReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Fat Burn Heart Rate Lower Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fatBurnHeartRateLowerLimitAndroid {@link FatBurnHeartRateLowerLimitAndroid}
     * @param argument                          callback argument
     */
    void onFatBurnHeartRateLowerLimitWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FatBurnHeartRateLowerLimitAndroid fatBurnHeartRateLowerLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Write Fat Burn Heart Rate Lower Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateLowerLimitWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Fat Burn Heart Rate Lower Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateLowerLimitWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Fat Burn Heart Rate Upper Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fatBurnHeartRateUpperLimitAndroid {@link FatBurnHeartRateUpperLimitAndroid}
     * @param argument                          callback argument
     */
    void onFatBurnHeartRateUpperLimitReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FatBurnHeartRateUpperLimitAndroid fatBurnHeartRateUpperLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Read Fat Burn Heart Rate Upper Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateUpperLimitReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Fat Burn Heart Rate Upper Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateUpperLimitReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Fat Burn Heart Rate Upper Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fatBurnHeartRateUpperLimitAndroid {@link FatBurnHeartRateUpperLimitAndroid}
     * @param argument                          callback argument
     */
    void onFatBurnHeartRateUpperLimitWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FatBurnHeartRateUpperLimitAndroid fatBurnHeartRateUpperLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Write Fat Burn Heart Rate Upper Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateUpperLimitWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Fat Burn Heart Rate Upper Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFatBurnHeartRateUpperLimitWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Heart Rate Lower Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aerobicHeartRateLowerLimitAndroid {@link AerobicHeartRateLowerLimitAndroid}
     * @param argument                          callback argument
     */
    void onAerobicHeartRateLowerLimitReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AerobicHeartRateLowerLimitAndroid aerobicHeartRateLowerLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Heart Rate Lower Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAerobicHeartRateLowerLimitReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Heart Rate Lower Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAerobicHeartRateLowerLimitReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Heart Rate Lower Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aerobicHeartRateLowerLimitAndroid {@link AerobicHeartRateLowerLimitAndroid}
     * @param argument                          callback argument
     */
    void onAerobicHeartRateLowerLimitWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AerobicHeartRateLowerLimitAndroid aerobicHeartRateLowerLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Heart Rate Lower Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAerobicHeartRateLowerLimitWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Heart Rate Lower Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAerobicHeartRateLowerLimitWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Heart Rate Upper Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aerobicHeartRateUpperLimitAndroid {@link AerobicHeartRateUpperLimitAndroid}
     * @param argument                          callback argument
     */
    void onAerobicHeartRateUpperLimitReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AerobicHeartRateUpperLimitAndroid aerobicHeartRateUpperLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Heart Rate Upper Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAerobicHeartRateUpperLimitReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Aerobic Heart Rate Upper Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAerobicHeartRateUpperLimitReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Heart Rate Upper Limit success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aerobicHeartRateUpperLimitAndroid {@link AerobicHeartRateUpperLimitAndroid}
     * @param argument                          callback argument
     */
    void onAerobicHeartRateUpperLimitWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AerobicHeartRateUpperLimitAndroid aerobicHeartRateUpperLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Heart Rate Upper Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAerobicHeartRateUpperLimitWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Aerobic Heart Rate Upper Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAerobicHeartRateUpperLimitWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Heart Rate Lower Limit success callback
     *
     * @param taskId                              task id
     * @param bluetoothDevice                     BLE device
     * @param serviceUUID                         service {@link UUID}
     * @param serviceInstanceId                   task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                  characteristic {@link UUID}
     * @param characteristicInstanceId            task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param anaerobicHeartRateLowerLimitAndroid {@link AnaerobicHeartRateLowerLimitAndroid}
     * @param argument                            callback argument
     */
    void onAnaerobicHeartRateLowerLimitReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AnaerobicHeartRateLowerLimitAndroid anaerobicHeartRateLowerLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Heart Rate Lower Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateLowerLimitReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Heart Rate Lower Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateLowerLimitReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Heart Rate Lower Limit success callback
     *
     * @param taskId                              task id
     * @param bluetoothDevice                     BLE device
     * @param serviceUUID                         service {@link UUID}
     * @param serviceInstanceId                   task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                  characteristic {@link UUID}
     * @param characteristicInstanceId            task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param anaerobicHeartRateLowerLimitAndroid {@link AnaerobicHeartRateLowerLimitAndroid}
     * @param argument                            callback argument
     */
    void onAnaerobicHeartRateLowerLimitWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AnaerobicHeartRateLowerLimitAndroid anaerobicHeartRateLowerLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Heart Rate Lower Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateLowerLimitWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Heart Rate Lower Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateLowerLimitWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Heart Rate Upper Limit success callback
     *
     * @param taskId                              task id
     * @param bluetoothDevice                     BLE device
     * @param serviceUUID                         service {@link UUID}
     * @param serviceInstanceId                   task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                  characteristic {@link UUID}
     * @param characteristicInstanceId            task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param anaerobicHeartRateUpperLimitAndroid {@link AnaerobicHeartRateUpperLimitAndroid}
     * @param argument                            callback argument
     */
    void onAnaerobicHeartRateUpperLimitReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AnaerobicHeartRateUpperLimitAndroid anaerobicHeartRateUpperLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Heart Rate Upper Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateUpperLimitReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Anaerobic Heart Rate Upper Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateUpperLimitReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Heart Rate Upper Limit success callback
     *
     * @param taskId                              task id
     * @param bluetoothDevice                     BLE device
     * @param serviceUUID                         service {@link UUID}
     * @param serviceInstanceId                   task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                  characteristic {@link UUID}
     * @param characteristicInstanceId            task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param anaerobicHeartRateUpperLimitAndroid {@link AnaerobicHeartRateUpperLimitAndroid}
     * @param argument                            callback argument
     */
    void onAnaerobicHeartRateUpperLimitWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AnaerobicHeartRateUpperLimitAndroid anaerobicHeartRateUpperLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Heart Rate Upper Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateUpperLimitWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Anaerobic Heart Rate Upper Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnaerobicHeartRateUpperLimitWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Five Zone Heart Rate Limits success callback
     *
     * @param taskId                         task id
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fiveZoneHeartRateLimitsAndroid {@link FiveZoneHeartRateLimitsAndroid}
     * @param argument                       callback argument
     */
    void onFiveZoneHeartRateLimitsReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FiveZoneHeartRateLimitsAndroid fiveZoneHeartRateLimitsAndroid
            , @Nullable Bundle argument);

    /**
     * Read Five Zone Heart Rate Limits error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFiveZoneHeartRateLimitsReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Five Zone Heart Rate Limits timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFiveZoneHeartRateLimitsReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Five Zone Heart Rate Limits success callback
     *
     * @param taskId                         task id
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fiveZoneHeartRateLimitsAndroid {@link FiveZoneHeartRateLimitsAndroid}
     * @param argument                       callback argument
     */
    void onFiveZoneHeartRateLimitsWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FiveZoneHeartRateLimitsAndroid fiveZoneHeartRateLimitsAndroid
            , @Nullable Bundle argument);

    /**
     * Write Five Zone Heart Rate Limits error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onFiveZoneHeartRateLimitsWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Five Zone Heart Rate Limits timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onFiveZoneHeartRateLimitsWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Three Zone Heart Rate Limits success callback
     *
     * @param taskId                          task id
     * @param bluetoothDevice                 BLE device
     * @param serviceUUID                     service {@link UUID}
     * @param serviceInstanceId               task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID              characteristic {@link UUID}
     * @param characteristicInstanceId        task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param threeZoneHeartRateLimitsAndroid {@link ThreeZoneHeartRateLimitsAndroid}
     * @param argument                        callback argument
     */
    void onThreeZoneHeartRateLimitsReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull ThreeZoneHeartRateLimitsAndroid threeZoneHeartRateLimitsAndroid
            , @Nullable Bundle argument);

    /**
     * Read Three Zone Heart Rate Limits error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onThreeZoneHeartRateLimitsReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Three Zone Heart Rate Limits timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onThreeZoneHeartRateLimitsReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Three Zone Heart Rate Limits success callback
     *
     * @param taskId                          task id
     * @param bluetoothDevice                 BLE device
     * @param serviceUUID                     service {@link UUID}
     * @param serviceInstanceId               task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID              characteristic {@link UUID}
     * @param characteristicInstanceId        task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param threeZoneHeartRateLimitsAndroid {@link ThreeZoneHeartRateLimitsAndroid}
     * @param argument                        callback argument
     */
    void onThreeZoneHeartRateLimitsWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull ThreeZoneHeartRateLimitsAndroid threeZoneHeartRateLimitsAndroid
            , @Nullable Bundle argument);

    /**
     * Write Three Zone Heart Rate Limits error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onThreeZoneHeartRateLimitsWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Three Zone Heart Rate Limits timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onThreeZoneHeartRateLimitsWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Two Zone Heart Rate Limit success callback
     *
     * @param taskId                       task id
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param twoZoneHeartRateLimitAndroid {@link TwoZoneHeartRateLimitAndroid}
     * @param argument                     callback argument
     */
    void onTwoZoneHeartRateLimitReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull TwoZoneHeartRateLimitAndroid twoZoneHeartRateLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Read Two Zone Heart Rate Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onTwoZoneHeartRateLimitReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Two Zone Heart Rate Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTwoZoneHeartRateLimitReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Two Zone Heart Rate Limit success callback
     *
     * @param taskId                       task id
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param twoZoneHeartRateLimitAndroid {@link TwoZoneHeartRateLimitAndroid}
     * @param argument                     callback argument
     */
    void onTwoZoneHeartRateLimitWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull TwoZoneHeartRateLimitAndroid twoZoneHeartRateLimitAndroid
            , @Nullable Bundle argument);

    /**
     * Write Two Zone Heart Rate Limit error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onTwoZoneHeartRateLimitWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Two Zone Heart Rate Limit timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTwoZoneHeartRateLimitWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Language success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param languageAndroid          {@link LanguageAndroid}
     * @param argument                 callback argument
     */
    void onLanguageReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull LanguageAndroid languageAndroid
            , @Nullable Bundle argument);

    /**
     * Read Language error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onLanguageReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Language timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onLanguageReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Language success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param languageAndroid          {@link LanguageAndroid}
     * @param argument                 callback argument
     */
    void onLanguageWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull LanguageAndroid languageAndroid
            , @Nullable Bundle argument);

    /**
     * Write Language error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onLanguageWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Language timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onLanguageWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Database Change Increment success callback
     *
     * @param taskId                         task id
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param databaseChangeIncrementAndroid {@link DatabaseChangeIncrementAndroid}
     * @param argument                       callback argument
     */
    void onDatabaseChangeIncrementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DatabaseChangeIncrementAndroid databaseChangeIncrementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Database Change Increment error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Database Change Increment timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Database Change Increment success callback
     *
     * @param taskId                         task id
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param databaseChangeIncrementAndroid {@link DatabaseChangeIncrementAndroid}
     * @param argument                       callback argument
     */
    void onDatabaseChangeIncrementWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DatabaseChangeIncrementAndroid databaseChangeIncrementAndroid
            , @Nullable Bundle argument);

    /**
     * Write Database Change Increment error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Database Change Increment timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Database Change Increment's Client Characteristic Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId                     task target descriptor incetanceId
     * @param clientCharacteristicConfigurationAndroid {@link ClientCharacteristicConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onDatabaseChangeIncrementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Database Change Increment's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Database Change Increment's Client Characteristic Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Database Change Increment notificate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Database Change Increment notificate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Database Change Increment notificate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementNotifyStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Database Change Increment notificate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Database Change Increment notificate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Database Change Increment notificate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDatabaseChangeIncrementNotifyStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Database Change Increment notified callback
     *
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param databaseChangeIncrementAndroid {@link DatabaseChangeIncrementAndroid}
     */
    void onDatabaseChangeIncrementNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DatabaseChangeIncrementAndroid databaseChangeIncrementAndroid);

    /**
     * Read User Index success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param userIndexAndroid         {@link UserIndexAndroid}
     * @param argument                 callback argument
     */
    void onUserIndexReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull UserIndexAndroid userIndexAndroid
            , @Nullable Bundle argument);

    /**
     * Read User Index error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onUserIndexReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read User Index timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUserIndexReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * WriteUser Control Point success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param userControlPointAndroid  {@link UserControlPointAndroid}
     * @param argument                 callback argument
     */
    void onUserControlPointWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull UserControlPointAndroid userControlPointAndroid
            , @Nullable Bundle argument);

    /**
     * Write User Control Point error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onUserControlPointWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write User Control Point timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUserControlPointWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read User Control Point's Client Characteristic Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId                     task target descriptor incetanceId
     * @param clientCharacteristicConfigurationAndroid {@link ClientCharacteristicConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onUserControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read User Control Point's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onUserControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read User Control Point's Client Characteristic Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUserControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);


    /**
     * Start User Control Point indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onUserControlPointIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start User Control Point indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onUserControlPointIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start User Control Point indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUserControlPointIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop User Control Point indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onUserControlPointIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop User Control Point indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onUserControlPointIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop User Control Point indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUserControlPointIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * User Control Point indicated callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param userControlPointAndroid  {@link UserControlPointAndroid}
     */
    void onUserControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull UserControlPointAndroid userControlPointAndroid);

    /**
     * Read Registered User's Client Characteristic Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId                     task target descriptor incetanceId
     * @param clientCharacteristicConfigurationAndroid {@link ClientCharacteristicConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onRegisteredUserClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Registered User's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onRegisteredUserClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Registered User's Client Characteristic Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRegisteredUserClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);


    /**
     * Start Registered User indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onRegisteredUserIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Registered User indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onRegisteredUserIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Registered User indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRegisteredUserIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Registered User indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onRegisteredUserIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Registered User indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}, {@link org.im97mori.ble.constants.ErrorCodeAndroid#BUSY}
     * @param argument                 callback argument
     */
    void onRegisteredUserIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Registered User indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRegisteredUserIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Registered User indicated callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param registeredUserAndroid    {@link RegisteredUserAndroid}
     */
    void onRegisteredUserIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull RegisteredUserAndroid registeredUserAndroid);

}
