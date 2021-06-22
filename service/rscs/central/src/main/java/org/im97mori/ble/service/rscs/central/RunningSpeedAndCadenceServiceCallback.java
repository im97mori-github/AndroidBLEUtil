package org.im97mori.ble.service.rscs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a53.RSCMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a54.RSCFeatureAndroid;
import org.im97mori.ble.characteristic.u2a55.SCControlPointAndroid;
import org.im97mori.ble.characteristic.u2a5d.SensorLocationAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;

import java.util.UUID;

/**
 * Running Speed and Cadence Service (Service UUID: 0x1814) callback
 */
@SuppressWarnings("unused")
public interface RunningSpeedAndCadenceServiceCallback {

    /**
     * Read RSC Feature success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param rscFeatureAndroid        {@link RSCFeatureAndroid}
     * @param argument                 callback argument
     */
    void onRSCFeatureReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull RSCFeatureAndroid rscFeatureAndroid
            , @Nullable Bundle argument);

    /**
     * Read RSC Feature error callback
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
    void onRSCFeatureReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read RSC Feature timeout callback
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
    void onRSCFeatureReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read RSC Measurement's Client Characteristic Configuration success callback
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
    void onRSCMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read RSC Measurement's Client Characteristic Configuration error callback
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
    void onRSCMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read RSC Measurement's Client Characteristic Configuration timeout callback
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
    void onRSCMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start RSC Measurement notificate success callback
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
    void onRSCMeasurementNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start RSC Measurement notificate error callback
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
    void onRSCMeasurementNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start RSC Measurement notificate timeout callback
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
    void onRSCMeasurementNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop RSC Measurement notificate success callback
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
    void onRSCMeasurementNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop RSC Measurement notificate error callback
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
    void onRSCMeasurementNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop RSC Measurement notificate timeout callback
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
    void onRSCMeasurementNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * RSC Measurement notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param rscMeasurementAndroid    {@link RSCMeasurementAndroid}
     */
    void onRSCMeasurementNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull RSCMeasurementAndroid rscMeasurementAndroid);

    /**
     * Read Sensor Location success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param sensorLocationAndroid    {@link SensorLocationAndroid}
     * @param argument                 callback argument
     */
    void onSensorLocationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SensorLocationAndroid sensorLocationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Sensor Location error callback
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
    void onSensorLocationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Sensor Location timeout callback
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
    void onSensorLocationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write SC Control Point success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param scControlPointAndroid    {@link SCControlPointAndroid}
     * @param argument                 callback argument
     */
    void onSCControlPointWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SCControlPointAndroid scControlPointAndroid
            , @Nullable Bundle argument);

    /**
     * Write SC Control Point error callback
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
    void onSCControlPointWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write SC Control Point timeout callback
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
    void onSCControlPointWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read SC Control Point's Client Characteristic Configuration success callback
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
    void onSCControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read SC Control Point's Client Characteristic Configuration error callback
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
    void onSCControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read SC Control Point's Client Characteristic Configuration timeout callback
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
    void onSCControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start SC Control Point indicate success callback
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
    void onSCControlPointIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start SC Control Point indicate error callback
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
    void onSCControlPointIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start SC Control Point indicate timeout callback
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
    void onSCControlPointIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop SC Control Point indicate success callback
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
    void onSCControlPointIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop SC Control Point indicate error callback
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
    void onSCControlPointIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop SC Control Point indicate timeout callback
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
    void onSCControlPointIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * SC Control Point indicated callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param scControlPointAndroid    {@link SCControlPointAndroid}
     */
    void onSCControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull SCControlPointAndroid scControlPointAndroid);

}
