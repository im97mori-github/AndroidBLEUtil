package org.im97mori.ble.service.ftms.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeatureAndroid;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataAndroid;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataAndroid;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataAndroid;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataAndroid;
import org.im97mori.ble.characteristic.u2ad1.RowerDataAndroid;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataAndroid;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatusAndroid;
import org.im97mori.ble.characteristic.u2ad4.SupportedSpeedRangeAndroid;
import org.im97mori.ble.characteristic.u2ad5.SupportedInclinationRangeAndroid;
import org.im97mori.ble.characteristic.u2ad6.SupportedResistanceLevelRangeAndroid;
import org.im97mori.ble.characteristic.u2ad7.SupportedHeartRateRangeAndroid;
import org.im97mori.ble.characteristic.u2ad8.SupportedPowerRangeAndroid;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPointAndroid;
import org.im97mori.ble.characteristic.u2ada.FitnessMachineStatusAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;

import java.util.UUID;

/**
 * Fitness Machine Service (Service UUID: 0x1826) callback
 */
public interface FitnessMachineServiceCallback {

    /**
     * Read Fitness Machine Feature success callback
     *
     * @param taskId                       task id
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fitnessMachineFeatureAndroid {@link FitnessMachineFeatureAndroid}
     * @param argument                     callback argument
     */
    void onFitnessMachineFeatureReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FitnessMachineFeatureAndroid fitnessMachineFeatureAndroid
            , @Nullable Bundle argument);

    /**
     * Read Fitness Machine Feature error callback
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
    void onFitnessMachineFeatureReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Fitness Machine Feature timeout callback
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
    void onFitnessMachineFeatureReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Treadmill Data's Client Characteristic Configuration success callback
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
    void onTreadmillDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Treadmill Data's Client Characteristic Configuration error callback
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
    void onTreadmillDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Treadmill Data's Client Characteristic Configuration timeout callback
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
    void onTreadmillDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Treadmill Data notificate success callback
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
    void onTreadmillDataNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Treadmill Data notificate error callback
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
    void onTreadmillDataNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Treadmill Data notificate timeout callback
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
    void onTreadmillDataNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Treadmill Data notificate success callback
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
    void onTreadmillDataNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Treadmill Data notificate error callback
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
    void onTreadmillDataNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Treadmill Data notificate timeout callback
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
    void onTreadmillDataNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Treadmill Data notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param treadmillDataAndroid     {@link TreadmillDataAndroid}
     */
    void onTreadmillDataNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull TreadmillDataAndroid treadmillDataAndroid);

    /**
     * Read Cross Trainer Data's Client Characteristic Configuration success callback
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
    void onCrossTrainerDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Cross Trainer Data's Client Characteristic Configuration error callback
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
    void onCrossTrainerDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Cross Trainer Data's Client Characteristic Configuration timeout callback
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
    void onCrossTrainerDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Treadmill Data notificate success callback
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
    void onCrossTrainerDataNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Cross Trainer Data notificate error callback
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
    void onCrossTrainerDataNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Cross Trainer Data notificate timeout callback
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
    void onCrossTrainerDataNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Cross Trainer Data notificate success callback
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
    void onCrossTrainerDataNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Cross Trainer Data notificate error callback
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
    void onCrossTrainerDataNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Cross Trainer Data notificate timeout callback
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
    void onCrossTrainerDataNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Cross Trainer Data notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param crossTrainerDataAndroid  {@link CrossTrainerDataAndroid}
     */
    void onCrossTrainerDataNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull CrossTrainerDataAndroid crossTrainerDataAndroid);

    /**
     * Read Step Climber Data's Client Characteristic Configuration success callback
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
    void onStepClimberDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Step Climber Data's Client Characteristic Configuration error callback
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
    void onStepClimberDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Step Climber Data's Client Characteristic Configuration timeout callback
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
    void onStepClimberDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Step Climber Data notificate success callback
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
    void onStepClimberDataNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Step Climber Data notificate error callback
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
    void onStepClimberDataNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Step Climber Data notificate timeout callback
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
    void onStepClimberDataNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Step Climber Data notificate success callback
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
    void onStepClimberDataNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Step Climber Data notificate error callback
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
    void onStepClimberDataNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Step Climber Data notificate timeout callback
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
    void onStepClimberDataNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Step Climber Data notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param stepClimberDataAndroid   {@link StepClimberDataAndroid}
     */
    void onStepClimberDataNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull StepClimberDataAndroid stepClimberDataAndroid);

    /**
     * Read Rower Data's Client Characteristic Configuration success callback
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
    void onStairClimberDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Rower Data's Client Characteristic Configuration error callback
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
    void onStairClimberDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Rower Data's Client Characteristic Configuration timeout callback
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
    void onStairClimberDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Rower Data notificate success callback
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
    void onStairClimberDataNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Rower Data notificate error callback
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
    void onStairClimberDataNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Rower Data notificate timeout callback
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
    void onStairClimberDataNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Rower Data notificate success callback
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
    void onStairClimberDataNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Rower Data notificate error callback
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
    void onStairClimberDataNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Rower Data notificate timeout callback
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
    void onStairClimberDataNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Rower Data notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param stairClimberDataAndroid  {@link StairClimberDataAndroid}
     */
    void onStairClimberDataNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull StairClimberDataAndroid stairClimberDataAndroid);

    /**
     * Read Rower Data's Client Characteristic Configuration success callback
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
    void onRowerDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Rower Data's Client Characteristic Configuration error callback
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
    void onRowerDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Rower Data's Client Characteristic Configuration timeout callback
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
    void onRowerDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Rower Data notificate success callback
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
    void onRowerDataNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Rower Data notificate error callback
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
    void onRowerDataNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Rower Data notificate timeout callback
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
    void onRowerDataNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Rower Data notificate success callback
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
    void onRowerDataNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Rower Data notificate error callback
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
    void onRowerDataNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Rower Data notificate timeout callback
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
    void onRowerDataNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Rower Data notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param rowerDataAndroid         {@link RowerDataAndroid}
     */
    void onRowerDataNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull RowerDataAndroid rowerDataAndroid);

    /**
     * Read Indoor Bike Data's Client Characteristic Configuration success callback
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
    void onIndoorBikeDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Indoor Bike Data's Client Characteristic Configuration error callback
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
    void onIndoorBikeDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Indoor Bike Data's Client Characteristic Configuration timeout callback
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
    void onIndoorBikeDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Indoor Bike Data notificate success callback
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
    void onIndoorBikeDataNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Indoor Bike Data notificate error callback
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
    void onIndoorBikeDataNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Indoor Bike Data notificate timeout callback
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
    void onIndoorBikeDataNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Indoor Bike Data notificate success callback
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
    void onIndoorBikeDataNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Indoor Bike Data notificate error callback
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
    void onIndoorBikeDataNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Indoor Bike Data notificate timeout callback
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
    void onIndoorBikeDataNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Indoor Bike Data notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param indoorBikeDataAndroid    {@link IndoorBikeDataAndroid}
     */
    void onIndoorBikeDataNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull IndoorBikeDataAndroid indoorBikeDataAndroid);

    /**
     * Read Training Status success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param trainingStatusAndroid    {@link TrainingStatusAndroid}
     * @param argument                 callback argument
     */
    void onTrainingStatusReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull TrainingStatusAndroid trainingStatusAndroid
            , @Nullable Bundle argument);

    /**
     * Read Training Status error callback
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
    void onTrainingStatusReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Training Status timeout callback
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
    void onTrainingStatusReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Training Status's Client Characteristic Configuration success callback
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
    void onTrainingStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Training Status's Client Characteristic Configuration error callback
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
    void onTrainingStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId, int status
            , @Nullable Bundle argument);

    /**
     * Read Training Status's Client Characteristic Configuration timeout callback
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
    void onTrainingStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Training Status notificate success callback
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
    void onTrainingStatusNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Training Status notificate error callback
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
    void onTrainingStatusNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Training Status notificate timeout callback
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
    void onTrainingStatusNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Training Status notificate success callback
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
    void onTrainingStatusNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Training Status notificate error callback
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
    void onTrainingStatusNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Training Status notificate timeout callback
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
    void onTrainingStatusNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Training Status notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param trainingStatusAndroid    {@link TrainingStatusAndroid}
     */
    void onTrainingStatusNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull TrainingStatusAndroid trainingStatusAndroid);

    /**
     * Read Supported Speed Range success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param supportedSpeedRangeAndroid {@link SupportedSpeedRangeAndroid}
     * @param argument                   callback argument
     */
    void onSupportedSpeedRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SupportedSpeedRangeAndroid supportedSpeedRangeAndroid
            , @Nullable Bundle argument);

    /**
     * Read Supported Speed Range error callback
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
    void onSupportedSpeedRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Supported Speed Range timeout callback
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
    void onSupportedSpeedRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Supported Inclination Range success callback
     *
     * @param taskId                           task id
     * @param bluetoothDevice                  BLE device
     * @param serviceUUID                      service {@link UUID}
     * @param serviceInstanceId                task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID               characteristic {@link UUID}
     * @param characteristicInstanceId         task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param supportedInclinationRangeAndroid {@link SupportedInclinationRangeAndroid}
     * @param argument                         callback argument
     */
    void onSupportedInclinationRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SupportedInclinationRangeAndroid supportedInclinationRangeAndroid
            , @Nullable Bundle argument);

    /**
     * Read Supported Inclination Range error callback
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
    void onSupportedInclinationRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Supported Inclination Range timeout callback
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
    void onSupportedInclinationRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Supported Resistance Level Range success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param supportedResistanceLevelRangeAndroid {@link SupportedResistanceLevelRangeAndroid}
     * @param argument                             callback argument
     */
    void onSupportedResistanceLevelRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SupportedResistanceLevelRangeAndroid supportedResistanceLevelRangeAndroid
            , @Nullable Bundle argument);

    /**
     * Read Supported Resistance Level Range error callback
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
    void onSupportedResistanceLevelRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Supported Resistance Level Range timeout callback
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
    void onSupportedResistanceLevelRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Supported Power Range success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param supportedPowerRangeAndroid {@link SupportedPowerRangeAndroid}
     * @param argument                   callback argument
     */
    void onSupportedPowerRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SupportedPowerRangeAndroid supportedPowerRangeAndroid
            , @Nullable Bundle argument);

    /**
     * Read Supported Power Range error callback
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
    void onSupportedPowerRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Supported Power Range timeout callback
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
    void onSupportedPowerRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Supported Heart Rate Range success callback
     *
     * @param taskId                         task id
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param supportedHeartRateRangeAndroid {@link SupportedHeartRateRangeAndroid}
     * @param argument                       callback argument
     */
    void onSupportedHeartRateRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SupportedHeartRateRangeAndroid supportedHeartRateRangeAndroid
            , @Nullable Bundle argument);

    /**
     * Read Supported Heart Rate Range error callback
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
    void onSupportedHeartRateRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Supported Heart Rate Range timeout callback
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
    void onSupportedHeartRateRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Fitness Machine Control Point success callback
     *
     * @param taskId                            task id
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fitnessMachineControlPointAndroid {@link FitnessMachineControlPointAndroid}
     * @param argument                          callback argument
     */
    void onFitnessMachineControlPointWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FitnessMachineControlPointAndroid fitnessMachineControlPointAndroid
            , @Nullable Bundle argument);

    /**
     * Write Fitness Machine Control Point error callback
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
    void onFitnessMachineControlPointWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Fitness Machine Control Point timeout callback
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
    void onFitnessMachineControlPointWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Fitness Machine Control Point's Client Characteristic Configuration success callback
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
    void onFitnessMachineControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Fitness Machine Control Point's Client Characteristic Configuration error callback
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
    void onFitnessMachineControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Fitness Machine Control Point's Client Characteristic Configuration timeout callback
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
    void onFitnessMachineControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Fitness Machine Control Point indicate success callback
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
    void onFitnessMachineControlPointIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Fitness Machine Control Point indicate error callback
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
    void onFitnessMachineControlPointIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Fitness Machine Control Point indicate timeout callback
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
    void onFitnessMachineControlPointIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Fitness Machine Control Point indicate success callback
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
    void onFitnessMachineControlPointIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Fitness Machine Control Point indicate error callback
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
    void onFitnessMachineControlPointIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Fitness Machine Control Point indicate timeout callback
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
    void onFitnessMachineControlPointIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Fitness Machine Control Point indicated callback
     *
     * @param bluetoothDevice                   BLE device
     * @param serviceUUID                       service {@link UUID}
     * @param serviceInstanceId                 task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                characteristic {@link UUID}
     * @param characteristicInstanceId          task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fitnessMachineControlPointAndroid {@link FitnessMachineControlPointAndroid}
     */
    void onFitnessMachineControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FitnessMachineControlPointAndroid fitnessMachineControlPointAndroid);

    /**
     * Read Fitness Machine Status's Client Characteristic Configuration success callback
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
    void onFitnessMachineStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Fitness Machine Status's Client Characteristic Configuration error callback
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
    void onFitnessMachineStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Fitness Machine Status's Client Characteristic Configuration timeout callback
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
    void onFitnessMachineStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Fitness Machine Status notificate success callback
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
    void onFitnessMachineStatusNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Fitness Machine Status notificate error callback
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
    void onFitnessMachineStatusNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Fitness Machine Status notificate timeout callback
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
    void onFitnessMachineStatusNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Fitness Machine Status notificate success callback
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
    void onFitnessMachineStatusNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Fitness Machine Status notificate error callback
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
    void onFitnessMachineStatusNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Fitness Machine Status notificate timeout callback
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
    void onFitnessMachineStatusNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Fitness Machine Status notified callback
     *
     * @param bluetoothDevice             BLE device
     * @param serviceUUID                 service {@link UUID}
     * @param serviceInstanceId           task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID          characteristic {@link UUID}
     * @param characteristicInstanceId    task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param fitnessMachineStatusAndroid {@link FitnessMachineStatusAndroid}
     */
    void onFitnessMachineStatusNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull FitnessMachineStatusAndroid fitnessMachineStatusAndroid);

}
