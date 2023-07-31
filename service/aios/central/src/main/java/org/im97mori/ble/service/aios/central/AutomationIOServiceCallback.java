package org.im97mori.ble.service.aios.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a56.DigitalAndroid;
import org.im97mori.ble.characteristic.u2a58.AnalogAndroid;
import org.im97mori.ble.characteristic.u2a5a.AggregateAndroid;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedPropertiesAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormatAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitalsAndroid;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSettingAndroid;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSettingAndroid;

import java.util.UUID;

/**
 * Automation IO (Service UUID: 0x1815) callback
 * @noinspection EmptyMethod
 */
@SuppressWarnings("unused")
public interface AutomationIOServiceCallback {

    /**
     * Read Digital success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param digitalAndroid           {@link DigitalAndroid}
     * @param argument                 callback argument
     */
    void onDigitalReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DigitalAndroid digitalAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Digital success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param digitalAndroid           {@link DigitalAndroid}
     * @param argument                 callback argument
     */
    void onDigitalWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DigitalAndroid digitalAndroid
            , @Nullable Bundle argument);

    /**
     * Write Digital error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param status                   {@link BLEConnection#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_WRITE_CHARACTERISTIC_NOT_FOUND}
     * @param argument                 callback argument
     */
    void onDigitalWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Digital timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Digital with no response success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param digitalAndroid           {@link DigitalAndroid}
     * @param argument                 callback argument
     */
    void onDigitalWriteWithNoResponseSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DigitalAndroid digitalAndroid
            , @Nullable Bundle argument);

    /**
     * Write Digital with no response error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param status                   {@link BLEConnection#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_WRITE_CHARACTERISTIC_NOT_FOUND}
     * @param argument                 callback argument
     */
    void onDigitalWriteWithNoResponseFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Digital with no response timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalWriteWithNoResponseTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Digital's Client Characteristic Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index or null
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param clientCharacteristicConfigurationAndroid {@link ClientCharacteristicConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onDigitalClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital's Client Characteristic Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Digital notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onDigitalNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Digital notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Digital notify timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalNotifyStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Digital notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onDigitalNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Digital notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Digital notify timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalNotifyStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Digital indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onDigitalIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Digital indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Digital indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Digital indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onDigitalIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Digital indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Digital indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic Presentation Format success callback
     *
     * @param taskId                                  task id
     * @param bluetoothDevice                         BLE device
     * @param serviceUUID                             service {@link UUID}
     * @param serviceInstanceId                       task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                      characteristic {@link UUID}
     * @param characteristicInstanceId                task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                   characteristic index or null
     * @param descriptorInstanceId                    task target descriptor instance id
     * @param characteristicPresentationFormatAndroid {@link CharacteristicPresentationFormatAndroid}
     * @param argument                                callback argument
     */
    void onDigitalCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic Presentation Format error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic Presentation Format error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index or null
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onDigitalCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Digital's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index or null
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onDigitalCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument);

    /**
     * Write Digital's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Digital's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic Extended Properties success callback
     *
     * @param taskId                                  task id
     * @param bluetoothDevice                         BLE device
     * @param serviceUUID                             service {@link UUID}
     * @param serviceInstanceId                       task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                      characteristic {@link UUID}
     * @param characteristicInstanceId                task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                   characteristic index or null
     * @param descriptorInstanceId                    task target descriptor instance id
     * @param characteristicExtendedPropertiesAndroid {@link CharacteristicExtendedPropertiesAndroid}
     * @param argument                                callback argument
     */
    void onDigitalCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic Extended Properties error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital's Characteristic Extended Properties timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Digital's Value Trigger Setting success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                      characteristic index or null
     * @param descriptorInstanceId       task target descriptor instance id
     * @param valueTriggerSettingAndroid {@link ValueTriggerSettingAndroid}
     * @param argument                   callback argument
     */
    void onDigitalValueTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital's Value Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalValueTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital's Value Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalValueTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Digital's Value Trigger Setting success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                      characteristic index or null
     * @param descriptorInstanceId       task target descriptor instance id
     * @param valueTriggerSettingAndroid {@link ValueTriggerSettingAndroid}
     * @param argument                   callback argument
     */
    void onDigitalValueTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Digital's Value Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalValueTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId, int status
            , @Nullable Bundle argument);

    /**
     * Write Digital's Value Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalValueTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Digital's Time Trigger Setting success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                     characteristic index or null
     * @param descriptorInstanceId      task target descriptor instance id
     * @param timeTriggerSettingAndroid {@link TimeTriggerSettingAndroid}
     * @param argument                  callback argument
     */
    void onDigitalTimeTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital's Time Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalTimeTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital's Time Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalTimeTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Digital's Time Trigger Setting success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                     characteristic index or null
     * @param descriptorInstanceId      task target descriptor instance id
     * @param timeTriggerSettingAndroid {@link TimeTriggerSettingAndroid}
     * @param argument                  callback argument
     */
    void onDigitalTimeTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Digital's Time Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalTimeTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Digital's Time Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalTimeTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Digital's Number of Digitals success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param numberOfDigitalsAndroid  {@link NumberOfDigitalsAndroid}
     * @param argument                 callback argument
     */
    void onDigitalNumberOfDigitalsReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull NumberOfDigitalsAndroid numberOfDigitalsAndroid
            , @Nullable Bundle argument);

    /**
     * Read Digital's Number of Digitals error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDigitalNumberOfDigitalsReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Digital's Number of Digitals timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDigitalNumberOfDigitalsReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param analogAndroid            {@link AnalogAndroid}
     * @param argument                 callback argument
     */
    void onAnalogReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull AnalogAndroid analogAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Analog success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param analogAndroid            {@link AnalogAndroid}
     * @param argument                 callback argument
     */
    void onAnalogWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull AnalogAndroid analogAndroid
            , @Nullable Bundle argument);

    /**
     * Write Analog error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Analog timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Analog with no response success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param analogAndroid            {@link AnalogAndroid}
     * @param argument                 callback argument
     */
    void onAnalogWriteWithNoResponseSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull AnalogAndroid analogAndroid
            , @Nullable Bundle argument);

    /**
     * Write Analog with no response error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogWriteWithNoResponseFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Analog with no response timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogWriteWithNoResponseTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog's Client Characteristic Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index or null
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param clientCharacteristicConfigurationAndroid {@link ClientCharacteristicConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onAnalogClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog's Client Characteristic Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Analog notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onAnalogNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Analog notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Analog notify timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogNotifyStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Analog notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onAnalogNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Analog notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Analog notify timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogNotifyStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Analog indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onAnalogIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Analog indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Analog indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Analog indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onAnalogIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Analog indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Analog indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic Presentation Format success callback
     *
     * @param taskId                                  task id
     * @param bluetoothDevice                         BLE device
     * @param serviceUUID                             service {@link UUID}
     * @param serviceInstanceId                       task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                      characteristic {@link UUID}
     * @param characteristicInstanceId                task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                   characteristic index or null
     * @param descriptorInstanceId                    task target descriptor instance id
     * @param characteristicPresentationFormatAndroid {@link CharacteristicPresentationFormatAndroid}
     * @param argument                                callback argument
     */
    void onAnalogCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic Presentation Format error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic Presentation Format error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index or null
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onAnalogCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Analog's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index or null
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onAnalogCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid
            , @Nullable Bundle argument);

    /**
     * Write Analog's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Analog's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic Extended Properties success callback
     *
     * @param taskId                                  task id
     * @param bluetoothDevice                         BLE device
     * @param serviceUUID                             service {@link UUID}
     * @param serviceInstanceId                       task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                      characteristic {@link UUID}
     * @param characteristicInstanceId                task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                   characteristic index or null
     * @param descriptorInstanceId                    task target descriptor instance id
     * @param characteristicExtendedPropertiesAndroid {@link CharacteristicExtendedPropertiesAndroid}
     * @param argument                                callback argument
     */
    void onAnalogCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic Extended Properties error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog's Characteristic Extended Properties timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog's Value Trigger Setting success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                      characteristic index or null
     * @param descriptorInstanceId       task target descriptor instance id
     * @param valueTriggerSettingAndroid {@link ValueTriggerSettingAndroid}
     * @param argument                   callback argument
     */
    void onAnalogValueTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog's Value Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogValueTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog's Value Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogValueTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Analog's Value Trigger Setting success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                      characteristic index or null
     * @param descriptorInstanceId       task target descriptor instance id
     * @param valueTriggerSettingAndroid {@link ValueTriggerSettingAndroid}
     * @param argument                   callback argument
     */
    void onAnalogValueTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Analog's Value Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogValueTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Analog's Value Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogValueTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog's Time Trigger Setting success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                     characteristic index or null
     * @param descriptorInstanceId      task target descriptor instance id
     * @param timeTriggerSettingAndroid {@link TimeTriggerSettingAndroid}
     * @param argument                  callback argument
     */
    void onAnalogTimeTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog's Time Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogTimeTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog's Time Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogTimeTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Analog's Time Trigger Setting success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                     characteristic index or null
     * @param descriptorInstanceId      task target descriptor instance id
     * @param timeTriggerSettingAndroid {@link TimeTriggerSettingAndroid}
     * @param argument                  callback argument
     */
    void onAnalogTimeTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Analog's Time Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogTimeTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Analog's Time Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogTimeTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Analog's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onAnalogValidRangeReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull ValidRangeAndroid validRangeAndroid
            , @Nullable Bundle argument);

    /**
     * Read Analog's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAnalogValidRangeReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Analog's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAnalogValidRangeReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Aggregate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aggregateAndroid         {@link AggregateAndroid}
     * @param argument                 callback argument
     */
    void onAggregateReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AggregateAndroid aggregateAndroid
            , @Nullable Bundle argument);

    /**
     * Read Aggregate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAggregateReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Aggregate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAggregateReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Aggregate's Client Characteristic Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param clientCharacteristicConfigurationAndroid {@link ClientCharacteristicConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onAggregateClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Aggregate's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAggregateClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Aggregate's Client Characteristic Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAggregateClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Aggregate notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onAggregateNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Aggregate notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAggregateNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Aggregate notify timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAggregateNotifyStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Aggregate notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onAggregateNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Aggregate notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAggregateNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId, int status
            , @Nullable Bundle argument);

    /**
     * Stop Aggregate notify timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAggregateNotifyStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Aggregate indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param argument                 callback argument
     */
    void onAggregateIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Aggregate indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAggregateIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Aggregate indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAggregateIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Aggregate indicate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param argument                 callback argument
     */
    void onAggregateIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Aggregate indicate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onAggregateIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Aggregate indicate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onAggregateIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Digital notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param digitalAndroid           {@link DigitalAndroid}
     */
    void onDigitalNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DigitalAndroid digitalAndroid);

    /**
     * Digital indicated callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param digitalAndroid           {@link DigitalAndroid}
     */
    void onDigitalIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DigitalAndroid digitalAndroid);

    /**
     * Analog notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param analogAndroid            {@link AnalogAndroid}
     */
    void onAnalogNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull AnalogAndroid analogAndroid);

    /**
     * Analog indicated callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index or null
     * @param analogAndroid            {@link DigitalAndroid}
     */
    void onAnalogIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull AnalogAndroid analogAndroid);

    /**
     * Aggregate notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aggregateAndroid         {@link AggregateAndroid}
     */
    void onAggregateNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AggregateAndroid aggregateAndroid);

    /**
     * Aggregate indicated callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param aggregateAndroid         {@link AggregateAndroid}
     */
    void onAggregateIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AggregateAndroid aggregateAndroid);

}
