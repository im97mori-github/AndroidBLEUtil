package org.im97mori.ble.service.dis.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a23.SystemIdAndroid;
import org.im97mori.ble.characteristic.u2a24.ModelNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a25.SerialNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a26.FirmwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a27.HardwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a28.SoftwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameStringAndroid;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataListAndroid;
import org.im97mori.ble.characteristic.u2a50.PnpIdAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.FIRMWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HARDWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MANUFACTURER_NAME_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MODEL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PNP_ID_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SERIAL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SOFTWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SYSTEM_ID_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

/**
 * Device Information Service (Service UUID: 0x180A) for Central
 */
public class DeviceInformationService extends AbstractCentralService {

    /**
     * {@link DeviceInformationServiceCallback} instance
     */
    private final DeviceInformationServiceCallback mDeviceInformationServiceCallback;

    /**
     * @param bleConnection                    {@link BLEConnection} instance
     * @param deviceInformationServiceCallback {@link DeviceInformationServiceCallback} instance
     * @param bleCallback                      {@link BLECallback} instance (optional)
     */
    public DeviceInformationService(@NonNull BLEConnection bleConnection, @NonNull DeviceInformationServiceCallback deviceInformationServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mDeviceInformationServiceCallback = deviceInformationServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (DEVICE_INFORMATION_SERVICE.equals(bluetoothGattService.getUuid())) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        mAvailableCharacteristicSet.add(bluetoothGattCharacteristic.getUuid());
                    }
                    break;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && DEVICE_INFORMATION_SERVICE.equals(serviceUUID)) {
            if (MANUFACTURER_NAME_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onManufacturerNameStringReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ManufacturerNameStringAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (MODEL_NUMBER_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onModelNumberStringReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ModelNumberStringAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SERIAL_NUMBER_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSerialNumberStringReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SerialNumberStringAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HARDWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onHardwareRevisionStringReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HardwareRevisionStringAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FIRMWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onFirmwareRevisionStringReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FirmwareRevisionStringAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SOFTWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSoftwareRevisionStringReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SoftwareRevisionStringAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SYSTEM_ID_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSystemIdReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SystemIdAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onIEEE_11073_20601_RegulatoryCertificationDataListReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, IEEE_11073_20601_RegulatoryCertificationDataListAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (PNP_ID_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onPnPIdReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, PnpIdAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && DEVICE_INFORMATION_SERVICE.equals(serviceUUID)) {
            if (MANUFACTURER_NAME_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onManufacturerNameStringReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (MODEL_NUMBER_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onModelNumberStringReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SERIAL_NUMBER_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSerialNumberStringReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (HARDWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onHardwareRevisionStringReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (FIRMWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onFirmwareRevisionStringReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SOFTWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSoftwareRevisionStringReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SYSTEM_ID_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSystemIdReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onIEEE_11073_20601_RegulatoryCertificationDataListReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (PNP_ID_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onPnPIdReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && DEVICE_INFORMATION_SERVICE.equals(serviceUUID)) {
            if (MANUFACTURER_NAME_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onManufacturerNameStringReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (MODEL_NUMBER_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onModelNumberStringReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SERIAL_NUMBER_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSerialNumberStringReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (HARDWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onHardwareRevisionStringReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (FIRMWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onFirmwareRevisionStringReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SOFTWARE_REVISION_STRING_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSoftwareRevisionStringReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SYSTEM_ID_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onSystemIdReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onIEEE_11073_20601_RegulatoryCertificationDataListReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (PNP_ID_CHARACTERISTIC.equals(characteristicUUID)) {
                mDeviceInformationServiceCallback.onPnPIdReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * @return {@code true}:target device has Manufacturer Name String, {@code false}:no Manufacturer Name String
     */
    public synchronized boolean hasManufacturerNameString() {
        return mAvailableCharacteristicSet.contains(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has Model Number String, {@code false}:no Model Number String
     */
    public synchronized boolean hasModelNumberString() {
        return mAvailableCharacteristicSet.contains(MODEL_NUMBER_STRING_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has Serial Number String, {@code false}:no Serial Number String
     */
    public synchronized boolean hasSerialNumberString() {
        return mAvailableCharacteristicSet.contains(SERIAL_NUMBER_STRING_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has Hardware Revision String, {@code false}:no Hardware Revision String
     */
    public synchronized boolean hasHardwareRevisionString() {
        return mAvailableCharacteristicSet.contains(HARDWARE_REVISION_STRING_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has Firmware Revision String, {@code false}:no Firmware Revision String
     */
    public synchronized boolean hasFirmwareRevisionString() {
        return mAvailableCharacteristicSet.contains(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has Firmware Revision String, {@code false}:no Firmware Revision String
     */
    public synchronized boolean hasSoftwareRevisionString() {
        return mAvailableCharacteristicSet.contains(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has System ID, {@code false}:no System ID
     */
    public synchronized boolean hasSystemId() {
        return mAvailableCharacteristicSet.contains(SYSTEM_ID_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has IEEE 11073-20601 Regulatory Certification Data List, {@code false}:no IEEE 11073-20601 Regulatory Certification Data List
     */
    public synchronized boolean hasIEEE_11073_20601_RegulatoryCertificationDataList() {
        return mAvailableCharacteristicSet.contains(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC);
    }

    /**
     * @return {@code true}:target device has PnP ID, {@code false}:no PnP ID
     */
    public synchronized boolean hasPnpId() {
        return mAvailableCharacteristicSet.contains(PNP_ID_CHARACTERISTIC);
    }

    /**
     * get Manufacturer Name String
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has Manufacturer Name String
     * @see DeviceInformationServiceCallback#onManufacturerNameStringReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ManufacturerNameStringAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onManufacturerNameStringReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onManufacturerNameStringReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getManufacturerNameString() {
        Integer taskId = null;
        if (isStarted() && hasManufacturerNameString()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, MANUFACTURER_NAME_STRING_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Model Number String
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has Model Number String
     * @see DeviceInformationServiceCallback#onModelNumberStringReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ModelNumberStringAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onModelNumberStringReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onModelNumberStringReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getModelNumberString() {
        Integer taskId = null;
        if (isStarted() && hasModelNumberString()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, MODEL_NUMBER_STRING_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Serial Number String
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has Serial Number String
     * @see DeviceInformationServiceCallback#onSerialNumberStringReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SerialNumberStringAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onSerialNumberStringReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onSerialNumberStringReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSerialNumberString() {
        Integer taskId = null;
        if (isStarted() && hasSerialNumberString()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, SERIAL_NUMBER_STRING_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Hardware Revision String
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has Hardware Revision String
     * @see DeviceInformationServiceCallback#onHardwareRevisionStringReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HardwareRevisionStringAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onHardwareRevisionStringReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onHardwareRevisionStringReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHardwareRevisionString() {
        Integer taskId = null;
        if (isStarted() && hasHardwareRevisionString()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, HARDWARE_REVISION_STRING_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Firmware Revision String
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has Firmware Revision String
     * @see DeviceInformationServiceCallback#onFirmwareRevisionStringReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FirmwareRevisionStringAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onFirmwareRevisionStringReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onFirmwareRevisionStringReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFirmwareRevisionString() {
        Integer taskId = null;
        if (isStarted() && hasFirmwareRevisionString()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, FIRMWARE_REVISION_STRING_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Software Revision String
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has Software Revision String
     * @see DeviceInformationServiceCallback#onSoftwareRevisionStringReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SoftwareRevisionStringAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onSoftwareRevisionStringReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onSoftwareRevisionStringReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSoftwareRevisionString() {
        Integer taskId = null;
        if (isStarted() && hasSoftwareRevisionString()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, SOFTWARE_REVISION_STRING_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get System ID
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has System ID
     * @see DeviceInformationServiceCallback#onSystemIdReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SystemIdAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onSystemIdReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onSystemIdReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSystemId() {
        Integer taskId = null;
        if (isStarted() && hasSystemId()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, SYSTEM_ID_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get IEEE 11073-20601 Regulatory Certification Data List
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has IEEE 11073-20601 Regulatory Certification Data List
     * @see DeviceInformationServiceCallback#onIEEE_11073_20601_RegulatoryCertificationDataListReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, IEEE_11073_20601_RegulatoryCertificationDataListAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onIEEE_11073_20601_RegulatoryCertificationDataListReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onIEEE_11073_20601_RegulatoryCertificationDataListReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIEEE_11073_20601_RegulatoryCertificationDataList() {
        Integer taskId = null;
        if (isStarted() && hasIEEE_11073_20601_RegulatoryCertificationDataList()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get PnP ID
     *
     * @return task id. if {@code null} returned, service is not ready or target device do not has PnP ID
     * @see DeviceInformationServiceCallback#onPnPIdReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, PnpIdAndroid, Bundle)
     * @see DeviceInformationServiceCallback#onPnPIdReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see DeviceInformationServiceCallback#onPnPIdReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    public synchronized Integer getPnpId() {
        Integer taskId = null;
        if (isStarted() && hasPnpId()) {
            taskId = mBLEConnection.createReadCharacteristicTask(DEVICE_INFORMATION_SERVICE, null, PNP_ID_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
