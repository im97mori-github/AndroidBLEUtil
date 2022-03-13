package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a2c.MagneticDeclinationAndroid;
import org.im97mori.ble.characteristic.u2a6c.ElevationAndroid;
import org.im97mori.ble.characteristic.u2a6d.PressureAndroid;
import org.im97mori.ble.characteristic.u2a6e.TemperatureAndroid;
import org.im97mori.ble.characteristic.u2a6f.HumidityAndroid;
import org.im97mori.ble.characteristic.u2a70.TrueWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a71.TrueWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a72.ApparentWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a73.ApparentWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a74.GustFactorAndroid;
import org.im97mori.ble.characteristic.u2a75.PollenConcentrationAndroid;
import org.im97mori.ble.characteristic.u2a76.UVIndexAndroid;
import org.im97mori.ble.characteristic.u2a77.IrradianceAndroid;
import org.im97mori.ble.characteristic.u2a78.RainfallAndroid;
import org.im97mori.ble.characteristic.u2a79.WindChillAndroid;
import org.im97mori.ble.characteristic.u2a7a.HeatIndexAndroid;
import org.im97mori.ble.characteristic.u2a7b.DewPointAndroid;
import org.im97mori.ble.characteristic.u2a7d.DescriptorValueChangedAndroid;
import org.im97mori.ble.characteristic.u2aa0.MagneticFluxDensity2DAndroid;
import org.im97mori.ble.characteristic.u2aa1.MagneticFluxDensity3DAndroid;
import org.im97mori.ble.characteristic.u2aa3.BarometricPressureTrendAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfigurationAndroid;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurementAndroid;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSettingAndroid;

import java.util.UUID;

/**
 * Environmental Sensing Service (Service UUID: 0x181A) callback
 */
public interface EnvironmentalSensingServiceCallback {

    /**
     * Read Descriptor Value Changed's Client Characteristic Configuration success callback
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
    void onDescriptorValueChangedClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Descriptor Value Changed's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDescriptorValueChangedClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Descriptor Value Changed's Client Characteristic Configuration timeout callback
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
    void onDescriptorValueChangedClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Descriptor Value Changed indicate success callback
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
    void onDescriptorValueChangedIndicateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Descriptor Value Changed indicate error callback
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
    void onDescriptorValueChangedIndicateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Descriptor Value Changed indicate timeout callback
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
    void onDescriptorValueChangedIndicateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Descriptor Value Changed indicate success callback
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
    void onDescriptorValueChangedIndicateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Descriptor Value Changed indicate error callback
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
    void onDescriptorValueChangedIndicateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Descriptor Value Changed indicate timeout callback
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
    void onDescriptorValueChangedIndicateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Descriptor Value Changed indicated callback
     *
     * @param bluetoothDevice               BLE device
     * @param serviceUUID                   service {@link UUID}
     * @param serviceInstanceId             task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID            characteristic {@link UUID}
     * @param characteristicInstanceId      task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorValueChangedAndroid {@link DescriptorValueChangedAndroid}
     */
    void onDescriptorValueChangedIndicated(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull DescriptorValueChangedAndroid descriptorValueChangedAndroid);

    /**
     * Read Apparent Wind Direction success callback
     *
     * @param taskId                       task id
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                        characteristic index
     * @param apparentWindDirectionAndroid {@link ApparentWindDirectionAndroid}
     * @param argument                     callback argument
     */
    void onApparentWindDirectionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Apparent Wind Direction notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Apparent Wind Direction notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Apparent Wind Direction notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Apparent Wind Direction notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Direction's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Direction's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Direction's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Direction's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Apparent Wind Direction's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Direction's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Apparent Wind Direction's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onApparentWindDirectionCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Apparent Wind Direction's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onApparentWindDirectionCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Apparent Wind Direction's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Apparent Wind Direction's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindDirectionValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Direction's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindDirectionValidRangeReadTimeout(@NonNull Integer taskId
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
     * Apparent Wind Direction notified callback
     *
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param apparentWindDirectionAndroid {@link ApparentWindDirectionAndroid}
     */
    void onApparentWindDirectionNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid);

    /**
     * Read Apparent Wind Speed success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param apparentWindSpeedAndroid {@link ApparentWindSpeedAndroid}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindSpeedAndroid apparentWindSpeedAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Apparent Wind Speed notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Apparent Wind Speed notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Apparent Wind Speed notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Apparent Wind Speed notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Speed's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Speed's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Speed's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Apparent Wind Speed's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Apparent Wind Speed's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Apparent Wind Speed's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Apparent Wind Speed's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onApparentWindSpeedCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Apparent Wind Speed's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onApparentWindSpeedCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Apparent Wind Speed's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Apparent Wind Speed's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onApparentWindSpeedValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Apparent Wind Speed's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onApparentWindSpeedValidRangeReadTimeout(@NonNull Integer taskId
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
     * Apparent Wind Speed notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param apparentWindSpeedAndroid {@link ApparentWindSpeedAndroid}
     */
    void onApparentWindSpeedNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ApparentWindSpeedAndroid apparentWindSpeedAndroid);

    /**
     * Read Dew Point success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param dewPointAndroid          {@link DewPointAndroid}
     * @param argument                 callback argument
     */
    void onDewPointReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DewPointAndroid dewPointAndroid
            , @Nullable Bundle argument);

    /**
     * Read Dew Point error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Dew Point timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Dew Point notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onDewPointNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Dew Point notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Dew Point notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onDewPointNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Dew Point notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Dew Point's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onDewPointEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Dew Point's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Dew Point's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Dew Point's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onDewPointEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Dew Point's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Dew Point's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Dew Point's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onDewPointEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Dew Point's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Dew Point's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Dew Point's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onDewPointEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Dew Point's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Dew Point's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Dew Point's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onDewPointEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Dew Point's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Dew Point's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Dew Point's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onDewPointCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Dew Point's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Dew Point's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Dew Point's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onDewPointCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Dew Point's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Dew Point's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Dew Point's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onDewPointValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Dew Point's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onDewPointValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Dew Point's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onDewPointValidRangeReadTimeout(@NonNull Integer taskId
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
     * Dew Point notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param dewPointAndroid          {@link DewPointAndroid}
     */
    void onDewPointNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull DewPointAndroid dewPointAndroid);

    /**
     * Read Elevation success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param elevationAndroid         {@link ElevationAndroid}
     * @param argument                 callback argument
     */
    void onElevationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ElevationAndroid elevationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Elevation error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onElevationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Elevation timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Elevation notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onElevationNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Elevation notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Elevation notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onElevationNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Elevation notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Elevation's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onElevationEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Elevation's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Elevation's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Elevation's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onElevationEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Elevation's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Elevation's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Elevation's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onElevationEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Elevation's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Elevation's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Elevation's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onElevationEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Elevation's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Elevation's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Elevation's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onElevationEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Elevation's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Elevation's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Elevation's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onElevationCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Elevation's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Elevation's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Elevation's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onElevationCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Elevation's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Elevation's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Elevation's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onElevationValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Elevation's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onElevationValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Elevation's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onElevationValidRangeReadTimeout(@NonNull Integer taskId
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
     * Elevation notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param elevationAndroid         {@link ElevationAndroid}
     */
    void onElevationNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull ElevationAndroid elevationAndroid);

    /**
     * Read Gust Factor success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param gustFactorAndroid        {@link GustFactorAndroid}
     * @param argument                 callback argument
     */
    void onGustFactorReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull GustFactorAndroid gustFactorAndroid
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Gust Factor notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onGustFactorNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Gust Factor notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Gust Factor notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onGustFactorNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Gust Factor notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Gust Factor's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Gust Factor's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Gust Factor's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onGustFactorEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Gust Factor's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Gust Factor's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Gust Factor's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Gust Factor's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Gust Factor's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onGustFactorEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Gust Factor's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Gust Factor's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Gust Factor's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Gust Factor's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Gust Factor's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Gust Factor's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onGustFactorCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Gust Factor's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Gust Factor's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Gust Factor's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Gust Factor's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onGustFactorValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Gust Factor's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onGustFactorValidRangeReadTimeout(@NonNull Integer taskId
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
     * Gust Factor notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param gustFactorAndroid        {@link GustFactorAndroid}
     */
    void onGustFactorNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull GustFactorAndroid gustFactorAndroid);

    /**
     * Read Heat Index success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param heatIndexAndroid         {@link HeatIndexAndroid}
     * @param argument                 callback argument
     */
    void onHeatIndexReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HeatIndexAndroid heatIndexAndroid
            , @Nullable Bundle argument);

    /**
     * Read Heat Index error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Heat Index timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Heat Index notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Heat Index notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Heat Index notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Heat Index notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Heat Index's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Heat Index's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Heat Index's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Heat Index's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Heat Index's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Heat Index's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Heat Index's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onHeatIndexEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Heat Index's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Heat Index's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Heat Index's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Heat Index's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Heat Index's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Heat Index's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onHeatIndexEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Heat Index's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Heat Index's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Heat Index's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Heat Index's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Heat Index's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Heat Index's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onHeatIndexCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Heat Index's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Heat Index's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Heat Index's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Heat Index's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHeatIndexValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Heat Index's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHeatIndexValidRangeReadTimeout(@NonNull Integer taskId
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
     * Heat Index notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param heatIndexAndroid         {@link HeatIndexAndroid}
     */
    void onHeatIndexNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HeatIndexAndroid heatIndexAndroid);

    /**
     * Read Humidity success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param humidityAndroid          {@link HumidityAndroid}
     * @param argument                 callback argument
     */
    void onHumidityReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HumidityAndroid humidityAndroid
            , @Nullable Bundle argument);

    /**
     * Read Humidity error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Humidity timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Humidity notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onHumidityNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Humidity notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Humidity notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onHumidityNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Humidity notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Humidity's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Humidity's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Humidity's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Humidity's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Humidity's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Humidity's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Humidity's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onHumidityEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Humidity's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Humidity's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Humidity's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Humidity's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Humidity's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Humidity's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onHumidityEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Humidity's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Humidity's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Humidity's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Humidity's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Humidity's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Humidity's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onHumidityCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Humidity's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Humidity's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Humidity's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onHumidityValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Humidity's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onHumidityValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Humidity's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onHumidityValidRangeReadTimeout(@NonNull Integer taskId
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
     * Humidity notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param humidityAndroid          {@link HumidityAndroid}
     */
    void onHumidityNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull HumidityAndroid humidityAndroid);

    /**
     * Read Irradiance success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param irradianceAndroid        {@link IrradianceAndroid}
     * @param argument                 callback argument
     */
    void onIrradianceReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull IrradianceAndroid irradianceAndroid
            , @Nullable Bundle argument);

    /**
     * Read Irradiance error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Irradiance timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Irradiance notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onIrradianceNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Irradiance notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Irradiance notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onIrradianceNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Irradiance notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Irradiance's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Irradiance's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Irradiance's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Irradiance's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Irradiance's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Irradiance's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Irradiance's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onIrradianceEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Irradiance's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Irradiance's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Irradiance's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Irradiance's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Irradiance's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Irradiance's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onIrradianceEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Irradiance's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Irradiance's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Irradiance's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Irradiance's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Irradiance's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Irradiance's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onIrradianceCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Irradiance's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Irradiance's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Irradiance's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Irradiance's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onIrradianceValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Irradiance's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onIrradianceValidRangeReadTimeout(@NonNull Integer taskId
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
     * Irradiance notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param irradianceAndroid        {@link IrradianceAndroid}
     */
    void onIrradianceNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull IrradianceAndroid irradianceAndroid);

    /**
     * Read Pollen Concentration success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                      characteristic index
     * @param pollenConcentrationAndroid {@link PollenConcentrationAndroid}
     * @param argument                   callback argument
     */
    void onPollenConcentrationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PollenConcentrationAndroid pollenConcentrationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Pollen Concentration notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Pollen Concentration notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Pollen Concentration notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Pollen Concentration notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onPollenConcentrationEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Pollen Concentration's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Pollen Concentration's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onPollenConcentrationEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Pollen Concentration's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onPollenConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Pollen Concentration's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Pollen Concentration's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pollen Concentration's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Pollen Concentration's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Pollen Concentration's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Pollen Concentration's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Pollen Concentration's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Pollen Concentration's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onPollenConcentrationCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Pollen Concentration's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Pollen Concentration's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Pollen Concentration's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onPollenConcentrationCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Pollen Concentration's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Pollen Concentration's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Pollen Concentration's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onPollenConcentrationValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Pollen Concentration's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Pollen Concentration's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPollenConcentrationValidRangeReadTimeout(@NonNull Integer taskId
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
     * Pollen Concentration notified callback
     *
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param pollenConcentrationAndroid {@link PollenConcentrationAndroid}
     */
    void onPollenConcentrationNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PollenConcentrationAndroid pollenConcentrationAndroid);

    /**
     * Read  success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param rainfallAndroid          {@link RainfallAndroid}
     * @param argument                 callback argument
     */
    void onRainfallReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull RainfallAndroid rainfallAndroid
            , @Nullable Bundle argument);

    /**
     * Read Rainfall error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Rainfall timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Rainfall notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onRainfallNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Rainfall notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Rainfall notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onRainfallNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Rainfall notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Rainfall's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onRainfallEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Rainfall's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Rainfall's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Rainfall's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onRainfallEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Rainfall's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Rainfall's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Rainfall's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onRainfallEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Rainfall's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Rainfall's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Rainfall's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onRainfallEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Rainfall's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Rainfall's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Rainfall's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onRainfallEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Rainfall's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Rainfall's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Rainfall's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onRainfallCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Rainfall's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Rainfall's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Rainfall's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onRainfallCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Rainfall's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Rainfall's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Rainfall's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onRainfallValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Rainfall's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onRainfallValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Rainfall's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onRainfallValidRangeReadTimeout(@NonNull Integer taskId
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
     * Rainfall notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param rainfallAndroid          {@link RainfallAndroid}
     */
    void onRainfallNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull RainfallAndroid rainfallAndroid);

    /**
     * Read Pressure success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param pressureAndroid          {@link PressureAndroid}
     * @param argument                 callback argument
     */
    void onPressureReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PressureAndroid pressureAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pressure error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onPressureReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Pressure timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Pressure notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onPressureNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Pressure notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Pressure notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onPressureNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Pressure notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Pressure's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onPressureEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pressure's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Pressure's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Pressure's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onPressureEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pressure's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Pressure's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Pressure's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onPressureEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Pressure's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Pressure's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Pressure's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onPressureEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Pressure's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Pressure's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Pressure's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onPressureEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Pressure's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Pressure's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Pressure's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onPressureCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Pressure's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Pressure's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Pressure's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onPressureCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Pressure's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Pressure's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Pressure's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onPressureValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Pressure's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onPressureValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Pressure's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onPressureValidRangeReadTimeout(@NonNull Integer taskId
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
     * Pressure notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param pressureAndroid          {@link PressureAndroid}
     */
    void onPressureNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull PressureAndroid pressureAndroid);

    /**
     * Read Temperature success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param temperatureAndroid       {@link TemperatureAndroid}
     * @param argument                 callback argument
     */
    void onTemperatureReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TemperatureAndroid temperatureAndroid
            , @Nullable Bundle argument);

    /**
     * Read Temperature error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Temperature timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Temperature notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onTemperatureNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Temperature notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Temperature notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onTemperatureNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Temperature notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Temperature's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onTemperatureEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Temperature's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Temperature's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Temperature's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onTemperatureEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Temperature's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Temperature's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Temperature's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onTemperatureEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Temperature's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Temperature's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Temperature's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onTemperatureEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Temperature's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Temperature's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Temperature's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onTemperatureEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Temperature's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Temperature's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Temperature's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onTemperatureCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Temperature's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Temperature's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Temperature's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onTemperatureCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Temperature's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Temperature's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Temperature's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onTemperatureValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Temperature's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTemperatureValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Temperature's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTemperatureValidRangeReadTimeout(@NonNull Integer taskId
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
     * Temperature notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param temperatureAndroid       {@link TemperatureAndroid}
     */
    void onTemperatureNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TemperatureAndroid temperatureAndroid);

    /**
     * Read True Wind Direction success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param trueWindDirectionAndroid {@link TrueWindDirectionAndroid}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindDirectionAndroid trueWindDirectionAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start True Wind Direction notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start True Wind Direction notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop True Wind Direction notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop True Wind Direction notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read True Wind Direction's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read True Wind Direction's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write True Wind Direction's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write True Wind Direction's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write True Wind Direction's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Direction's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read True Wind Direction's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write True Wind Direction's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write True Wind Direction's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write True Wind Direction's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read True Wind Direction's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onTrueWindDirectionCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read True Wind Direction's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read True Wind Direction's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write True Wind Direction's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onTrueWindDirectionCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write True Wind Direction's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write True Wind Direction's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read True Wind Direction's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read True Wind Direction's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindDirectionValidRangeReadFailed(@NonNull Integer taskId
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
     * Read True Wind Direction's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindDirectionValidRangeReadTimeout(@NonNull Integer taskId
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
     * True Wind Direction notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param trueWindDirectionAndroid {@link TrueWindDirectionAndroid}
     */
    void onTrueWindDirectionNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindDirectionAndroid trueWindDirectionAndroid);

    /**
     * Read True Wind Speed success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param trueWindSpeedAndroid     {@link TrueWindSpeedAndroid}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindSpeedAndroid trueWindSpeedAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start True Wind Speed notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start True Wind Speed notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop True Wind Speed notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop True Wind Speed notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read True Wind Speed's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read True Wind Speed's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write True Wind Speed's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write True Wind Speed's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write True Wind Speed's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read True Wind Speed's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read True Wind Speed's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write True Wind Speed's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write True Wind Speed's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write True Wind Speed's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read True Wind Speed's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onTrueWindSpeedCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read True Wind Speed's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read True Wind Speed's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write True Wind Speed's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onTrueWindSpeedCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write True Wind Speed's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write True Wind Speed's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read True Wind Speed's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read True Wind Speed's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onTrueWindSpeedValidRangeReadFailed(@NonNull Integer taskId
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
     * Read True Wind Speed's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onTrueWindSpeedValidRangeReadTimeout(@NonNull Integer taskId
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
     * True Wind Speed notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param trueWindSpeedAndroid     {@link TrueWindSpeedAndroid}
     */
    void onTrueWindSpeedNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull TrueWindSpeedAndroid trueWindSpeedAndroid);

    /**
     * Read UV Index success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param uvIndexAndroid           {@link UVIndexAndroid}
     * @param argument                 callback argument
     */
    void onUVIndexReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull UVIndexAndroid uvIndexAndroid
            , @Nullable Bundle argument);

    /**
     * Read UV Index error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read UV Index timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start UV Index notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onUVIndexNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start UV Index notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop UV Index notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onUVIndexNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop UV Index notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read UV Index's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onUVIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read UV Index's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read UV Index's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read UV Index's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onUVIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read UV Index's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read UV Index's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write UV Index's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onUVIndexEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write UV Index's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write UV Index's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read UV Index's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onUVIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read UV Index's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read UV Index's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write UV Index's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onUVIndexEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write UV Index's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write UV Index's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read UV Index's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onUVIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read UV Index's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read UV Index's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write UV Index's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onUVIndexCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write UV Index's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write UV Index's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read UV Index's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onUVIndexValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read UV Index's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onUVIndexValidRangeReadFailed(@NonNull Integer taskId
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
     * Read UV Index's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onUVIndexValidRangeReadTimeout(@NonNull Integer taskId
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
     * UV Index notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param uvIndexAndroid           {@link UVIndexAndroid}
     */
    void onUVIndexNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull UVIndexAndroid uvIndexAndroid);

    /**
     * Read Wind Chill success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param windChillAndroid         {@link WindChillAndroid}
     * @param argument                 callback argument
     */
    void onWindChillReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull WindChillAndroid windChillAndroid
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Wind Chill notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onWindChillNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Wind Chill notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Wind Chill notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onWindChillNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Wind Chill notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onWindChillEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Wind Chill's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Wind Chill's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onWindChillEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Wind Chill's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onWindChillEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Wind Chill's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Wind Chill's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onWindChillEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Wind Chill's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Wind Chill's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Wind Chill's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onWindChillEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Wind Chill's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Wind Chill's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Wind Chill's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onWindChillCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Wind Chill's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Wind Chill's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Wind Chill's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onWindChillCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Wind Chill's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Wind Chill's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Wind Chill's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onWindChillValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Wind Chill's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onWindChillValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Wind Chill's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onWindChillValidRangeReadTimeout(@NonNull Integer taskId
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
     * Wind Chill notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param windChillAndroid         {@link WindChillAndroid}
     */
    void onWindChillNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull WindChillAndroid windChillAndroid);

    /**
     * Read Barometric Pressure Trend success callback
     *
     * @param taskId                         task id
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                          characteristic index
     * @param barometricPressureTrendAndroid {@link BarometricPressureTrendAndroid}
     * @param argument                       callback argument
     */
    void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull BarometricPressureTrendAndroid barometricPressureTrendAndroid
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Barometric Pressure Trend notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Barometric Pressure Trend notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Barometric Pressure Trend notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Barometric Pressure Trend notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Barometric Pressure Trend's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Barometric Pressure Trend's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Barometric Pressure Trend's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Barometric Pressure Trend's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Barometric Pressure Trend's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Barometric Pressure Trend's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Barometric Pressure Trend's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onBarometricPressureTrendCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Barometric Pressure Trend's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onBarometricPressureTrendCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Barometric Pressure Trend's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Barometric Pressure Trend's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Barometric Pressure Trend's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onBarometricPressureTrendValidRangeReadTimeout(@NonNull Integer taskId
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
     * Barometric Pressure Trend notified callback
     *
     * @param bluetoothDevice                BLE device
     * @param serviceUUID                    service {@link UUID}
     * @param serviceInstanceId              task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID             characteristic {@link UUID}
     * @param characteristicInstanceId       task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param barometricPressureTrendAndroid {@link BarometricPressureTrendAndroid}
     */
    void onBarometricPressureTrendNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull BarometricPressureTrendAndroid barometricPressureTrendAndroid);

    /**
     * Read Magnetic Declination success callback
     *
     * @param taskId                     task id
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                      characteristic index
     * @param magneticDeclinationAndroid {@link MagneticDeclinationAndroid}
     * @param argument                   callback argument
     */
    void onMagneticDeclinationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticDeclinationAndroid magneticDeclinationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Magnetic Declination notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Magnetic Declination notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Magnetic Declination notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Magnetic Declination notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Declination's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Magnetic Declination's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Declination's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Declination's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Declination's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Declination's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Declination's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Magnetic Declination's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Declination's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Magnetic Declination's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Magnetic Declination's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onMagneticDeclinationCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Magnetic Declination's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Declination's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Magnetic Declination's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onMagneticDeclinationCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Magnetic Declination's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Magnetic Declination's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Magnetic Declination's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Magnetic Declination's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticDeclinationValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Declination's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticDeclinationValidRangeReadTimeout(@NonNull Integer taskId
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
     * Magnetic Declination notified callback
     *
     * @param bluetoothDevice            BLE device
     * @param serviceUUID                service {@link UUID}
     * @param serviceInstanceId          task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID         characteristic {@link UUID}
     * @param characteristicInstanceId   task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param magneticDeclinationAndroid {@link MagneticDeclinationAndroid}
     */
    void onMagneticDeclinationNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticDeclinationAndroid magneticDeclinationAndroid);

    /**
     * Read Magnetic Flux Density - 2D success callback
     *
     * @param taskId                       task id
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                        characteristic index
     * @param magneticFluxDensity2DAndroid {@link MagneticFluxDensity2DAndroid}
     * @param argument                     callback argument
     */
    void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity2DAndroid magneticFluxDensity2DAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Magnetic Flux Density - 2D notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Magnetic Flux Density - 2D notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Magnetic Flux Density - 2D notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Magnetic Flux Density - 2D notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 2D's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 2D's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 2D's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 2D's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 2D's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 2D's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 2D's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onMagneticFluxDensity2DCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 2D's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onMagneticFluxDensity2DCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 2D's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 2D's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 2D's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity2DValidRangeReadTimeout(@NonNull Integer taskId
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
     * Magnetic Flux Density - 2D notified callback
     *
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param magneticFluxDensity2DAndroid {@link MagneticFluxDensity2DAndroid}
     */
    void onMagneticFluxDensity2DNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity2DAndroid magneticFluxDensity2DAndroid);

    /**
     * Read Magnetic Flux Density - 3D success callback
     *
     * @param taskId                       task id
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                        characteristic index
     * @param magneticFluxDensity3DAndroid {@link MagneticFluxDensity3DAndroid}
     * @param argument                     callback argument
     */
    void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity3DAndroid magneticFluxDensity3DAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Magnetic Flux Density - 3D notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Start Magnetic Flux Density - 3D notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Magnetic Flux Density - 3D notify success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , @Nullable Bundle argument);

    /**
     * Stop Magnetic Flux Density - 3D notify error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer index
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D's ES Measurement success callback
     *
     * @param taskId                                 task id
     * @param bluetoothDevice                        BLE device
     * @param serviceUUID                            service {@link UUID}
     * @param serviceInstanceId                      task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                     characteristic {@link UUID}
     * @param characteristicInstanceId               task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                  characteristic index
     * @param descriptorInstanceId                   task target descriptor instance id
     * @param environmentalSensingMeasurementAndroid {@link EnvironmentalSensingMeasurementAndroid}
     * @param argument                               callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D's ES Measurement error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's ES Measurement timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadTimeout(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 3D's ES Trigger Setting success callback
     *
     * @param taskId                                    task id
     * @param bluetoothDevice                           BLE device
     * @param serviceUUID                               service {@link UUID}
     * @param serviceInstanceId                         task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                        characteristic {@link UUID}
     * @param characteristicInstanceId                  task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex                       characteristic index
     * @param descriptorInstanceId                      task target descriptor instance id
     * @param descriptorIndex                           descriptor index
     * @param environmentalSensingTriggerSettingAndroid {@link EnvironmentalSensingTriggerSettingAndroid}
     * @param argument                                  callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @NonNull Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 3D's ES Trigger Setting error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 3D's ES Trigger Setting timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param characteristicIndex      characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param descriptorIndex          descriptor index
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer characteristicIndex
            , @Nullable Integer descriptorInstanceId
            , @Nullable Integer descriptorIndex
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Magnetic Flux Density - 3D's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadTimeout(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 3D's ES Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                    characteristic index
     * @param descriptorInstanceId                     task target descriptor instance id
     * @param environmentalSensingConfigurationAndroid {@link EnvironmentalSensingConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull Integer descriptorInstanceId
            , @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Write Magnetic Flux Density - 3D's ES Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 3D's ES Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteTimeout(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onMagneticFluxDensity3DCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 3D's Characteristic User Description success callback
     *
     * @param taskId                               task id
     * @param bluetoothDevice                      BLE device
     * @param serviceUUID                          service {@link UUID}
     * @param serviceInstanceId                    task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                   characteristic {@link UUID}
     * @param characteristicInstanceId             task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                                characteristic index
     * @param descriptorInstanceId                 task target descriptor instance id
     * @param characteristicUserDescriptionAndroid {@link CharacteristicUserDescriptionAndroid}
     * @param argument                             callback argument
     */
    void onMagneticFluxDensity3DCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 3D's Characteristic User Description error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId
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
     * Write Magnetic Flux Density - 3D's Characteristic User Description timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's Valid Range success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param validRangeAndroid        {@link ValidRangeAndroid}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DValidRangeReadSuccess(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's Valid Range error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DValidRangeReadFailed(@NonNull Integer taskId
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
     * Read Magnetic Flux Density - 3D's Valid Range timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param index                    characteristic index
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onMagneticFluxDensity3DValidRangeReadTimeout(@NonNull Integer taskId
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
     * Magnetic Flux Density - 3D notified callback
     *
     * @param bluetoothDevice              BLE device
     * @param serviceUUID                  service {@link UUID}
     * @param serviceInstanceId            task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID           characteristic {@link UUID}
     * @param characteristicInstanceId     task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param magneticFluxDensity3DAndroid {@link MagneticFluxDensity3DAndroid}
     */
    void onMagneticFluxDensity3DNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @Nullable Integer index
            , @NonNull MagneticFluxDensity3DAndroid magneticFluxDensity3DAndroid);

}
