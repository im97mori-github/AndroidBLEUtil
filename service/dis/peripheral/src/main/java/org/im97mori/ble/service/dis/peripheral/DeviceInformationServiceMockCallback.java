package org.im97mori.ble.service.dis.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a25.SerialNumberString;
import org.im97mori.ble.characteristic.u2a26.FirmwareRevisionString;
import org.im97mori.ble.characteristic.u2a27.HardwareRevisionString;
import org.im97mori.ble.characteristic.u2a28.SoftwareRevisionString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataList;
import org.im97mori.ble.characteristic.u2a50.PnpId;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIRMWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HARDWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MANUFACTURER_NAME_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MODEL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PNP_ID_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERIAL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SOFTWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SYSTEM_ID_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

/**
 * Device Information Service (Service UUID: 0x180A) for Peripheral
 */
public class DeviceInformationServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link DeviceInformationServiceMockCallback}
     *
     * @param <T> subclass of {@link DeviceInformationServiceMockCallback}
     */
    public static class Builder<T extends DeviceInformationServiceMockCallback> extends AbstractServiceMockCallback.Builder<DeviceInformationServiceMockCallback> {

        /**
         * Manufacturer Name String data
         */
        protected CharacteristicData mManufacturerNameStringCharacteristicData;

        /**
         * Model Number String data
         */
        protected CharacteristicData mModelNumberStringCharacteristicData;

        /**
         * Serial Number String data
         */
        protected CharacteristicData mSerialNumberStringCharacteristicData;

        /**
         * Hardware Revision String data
         */
        protected CharacteristicData mHardwareRevisionStringCharacteristicData;

        /**
         * Hardware Revision String data
         */
        protected CharacteristicData mFirmwareRevisionStringCharacteristicData;

        /**
         * Software Revision String data
         */
        protected CharacteristicData mSoftwareRevisionStringCharacteristicData;

        /**
         * System ID data
         */
        protected CharacteristicData mSystemIdCharacteristicData;

        /**
         * IEEE 11073-20601 Regulatory Certification Data List data
         */
        protected CharacteristicData mIEEE_11073_20601_RegulatoryCertificationDataListCharacteristicData;

        /**
         * PnP ID data
         */
        protected CharacteristicData mPnpIdCharacteristicData;

        /**
         * @see #addManufacturerNameString(ManufacturerNameString)
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull String manufacturerName) {
            return addManufacturerNameString(new ManufacturerNameString(manufacturerName));
        }

        /**
         * @see #addManufacturerNameString(byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull ManufacturerNameString manufacturerNameString) {
            return addManufacturerNameString(manufacturerNameString.getBytes());
        }

        /**
         * @see #addManufacturerNameString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull byte[] value) {
            return addManufacturerNameString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Manufacturer Name String characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addManufacturerNameString(int responceCode, long delay, @NonNull byte[] value) {
            mManufacturerNameStringCharacteristicData = new CharacteristicData(MANUFACTURER_NAME_STRING_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Manufacturer Name String characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            mManufacturerNameStringCharacteristicData = null;
            return this;
        }

        /**
         * @see #addModelNumberString(ModelNumberString)
         */
        @NonNull
        public Builder<T> addModelNumberString(@NonNull String modelNumber) {
            return addModelNumberString(new ModelNumberString(modelNumber));
        }

        /**
         * @see #addModelNumberString(byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(ModelNumberString modelNumberString) {
            return addModelNumberString(modelNumberString.getBytes());
        }

        /**
         * @see #addModelNumberString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(@NonNull byte[] value) {
            return addModelNumberString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Model Number String characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addModelNumberString(int responceCode, long delay, @NonNull byte[] value) {
            mModelNumberStringCharacteristicData = new CharacteristicData(MODEL_NUMBER_STRING_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Model Number String characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeModelNumberString() {
            mModelNumberStringCharacteristicData = null;
            return this;
        }

        /**
         * @see #addSerialNumberString(SerialNumberString)
         */
        @NonNull
        public Builder<T> addSerialNumberString(@NonNull String serialNumber) {
            return addSerialNumberString(new SerialNumberString(serialNumber));
        }

        /**
         * @see #addSerialNumberString(byte[])
         */
        @NonNull
        public Builder<T> addSerialNumberString(SerialNumberString serialNumberString) {
            return addSerialNumberString(serialNumberString.getBytes());
        }

        /**
         * @see #addSerialNumberString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSerialNumberString(@NonNull byte[] value) {
            return addSerialNumberString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Serial Number String characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSerialNumberString(int responceCode, long delay, @NonNull byte[] value) {
            mSerialNumberStringCharacteristicData = new CharacteristicData(SERIAL_NUMBER_STRING_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Serial Number String characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSerialNumberString() {
            mSerialNumberStringCharacteristicData = null;
            return this;
        }

        /**
         * @see #addHardwareRevisionString(HardwareRevisionString)
         */
        @NonNull
        public Builder<T> addHardwareRevisionString(@NonNull String hardwareRevision) {
            return addHardwareRevisionString(new HardwareRevisionString(hardwareRevision));
        }

        /**
         * @see #addHardwareRevisionString(byte[])
         */
        @NonNull
        public Builder<T> addHardwareRevisionString(HardwareRevisionString hardwareRevisionString) {
            return addHardwareRevisionString(hardwareRevisionString.getBytes());
        }

        /**
         * @see #addHardwareRevisionString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHardwareRevisionString(@NonNull byte[] value) {
            return addHardwareRevisionString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Hardware Revision String characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHardwareRevisionString(int responceCode, long delay, @NonNull byte[] value) {
            mHardwareRevisionStringCharacteristicData = new CharacteristicData(HARDWARE_REVISION_STRING_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Hardware Revision String characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeHardwareRevisionString() {
            mHardwareRevisionStringCharacteristicData = null;
            return this;
        }

        /**
         * @see #addFirmwareRevisionString(FirmwareRevisionString)
         */
        public Builder<T> addFirmwareRevisionString(@NonNull String firmwareRevision) {
            return addFirmwareRevisionString(new FirmwareRevisionString(firmwareRevision));
        }

        /**
         * @see #addFirmwareRevisionString(byte[])
         */
        public Builder<T> addFirmwareRevisionString(FirmwareRevisionString firmwareRevisionString) {
            return addFirmwareRevisionString(firmwareRevisionString.getBytes());
        }

        /**
         * @see #addFirmwareRevisionString(byte[])
         */
        public Builder<T> addFirmwareRevisionString(@NonNull byte[] value) {
            return addFirmwareRevisionString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Firmware Revision String characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addFirmwareRevisionString(int responceCode, long delay, @NonNull byte[] value) {
            mFirmwareRevisionStringCharacteristicData = new CharacteristicData(FIRMWARE_REVISION_STRING_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Firmware Revision String characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeFirmwareRevisionString() {
            mFirmwareRevisionStringCharacteristicData = null;
            return this;
        }

        /**
         * @see #addSoftwareRevisionString(SoftwareRevisionString)
         */
        public Builder<T> addSoftwareRevisionString(@NonNull String softwareRevision) {
            return addSoftwareRevisionString(new SoftwareRevisionString(softwareRevision));
        }

        /**
         * @see #addSoftwareRevisionString(byte[])
         */
        public Builder<T> addSoftwareRevisionString(SoftwareRevisionString softwareRevisionString) {
            return addSoftwareRevisionString(softwareRevisionString.getBytes());
        }

        /**
         * @see #addSoftwareRevisionString(int, long, byte[])
         */
        public Builder<T> addSoftwareRevisionString(@NonNull byte[] value) {
            return addSoftwareRevisionString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Software Revision String characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addSoftwareRevisionString(int responceCode, long delay, @NonNull byte[] value) {
            mSoftwareRevisionStringCharacteristicData = new CharacteristicData(SOFTWARE_REVISION_STRING_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Software Revision String characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeSoftwareRevisionString() {
            mSoftwareRevisionStringCharacteristicData = null;
            return this;
        }

        /**
         * @see #addSystemId(SystemId)
         */
        public Builder<T> addSystemId(long manufacturerIdentifier, int organizationallyUniqueIdentifier) {
            return addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier));
        }

        /**
         * @see #addSystemId(byte[])
         */
        public Builder<T> addSystemId(SystemId systemId) {
            return addSystemId(systemId.getBytes());
        }

        /**
         * @see #addSystemId(int, long, byte[])
         */
        public Builder<T> addSystemId(@NonNull byte[] value) {
            return addSystemId(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add System ID characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addSystemId(int responceCode, long delay, @NonNull byte[] value) {
            mSystemIdCharacteristicData = new CharacteristicData(SYSTEM_ID_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove System ID characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeSystemId() {
            mSystemIdCharacteristicData = null;
            return this;
        }

        /**
         * @see #addIEEE_11073_20601_RegulatoryCertificationDataList(byte[])
         */
        public Builder<T> addIEEE_11073_20601_RegulatoryCertificationDataList(IEEE_11073_20601_RegulatoryCertificationDataList IEEE_11073_20601_RegulatoryCertificationDataList) {
            return addIEEE_11073_20601_RegulatoryCertificationDataList(IEEE_11073_20601_RegulatoryCertificationDataList.getBytes());
        }

        /**
         * @see #addIEEE_11073_20601_RegulatoryCertificationDataList(int, long, byte[])
         */
        public Builder<T> addIEEE_11073_20601_RegulatoryCertificationDataList(@NonNull byte[] value) {
            return addIEEE_11073_20601_RegulatoryCertificationDataList(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add IEEE 11073-20601 Regulatory Certification Data List characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addIEEE_11073_20601_RegulatoryCertificationDataList(int responceCode, long delay, @NonNull byte[] value) {
            mIEEE_11073_20601_RegulatoryCertificationDataListCharacteristicData = new CharacteristicData(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove IEEE 11073-20601 Regulatory Certification Data List characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeIEEE_11073_20601_RegulatoryCertificationDataList() {
            mIEEE_11073_20601_RegulatoryCertificationDataListCharacteristicData = null;
            return this;
        }

        /**
         * @see #addPnpId(PnpId)
         */
        public Builder<T> addPnpId(int vendorIdSource, int vendorId, int productId, int productVersion) {
            return addPnpId(new PnpId(vendorIdSource, vendorId, productId, productVersion));
        }

        /**
         * @see #addPnpId(byte[])
         */
        public Builder<T> addPnpId(PnpId pnpId) {
            return addPnpId(pnpId.getBytes());
        }

        /**
         * @see #addPnpId(int, long, byte[])
         */
        public Builder<T> addPnpId(@NonNull byte[] value) {
            return addPnpId(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add PnP ID characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addPnpId(int responceCode, long delay, @NonNull byte[] value) {
            mPnpIdCharacteristicData = new CharacteristicData(PNP_ID_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove PnP ID characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removePnpId() {
            mPnpIdCharacteristicData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mManufacturerNameStringCharacteristicData != null) {
                characteristicList.add(mManufacturerNameStringCharacteristicData);
            }
            if (mModelNumberStringCharacteristicData != null) {
                characteristicList.add(mModelNumberStringCharacteristicData);
            }
            if (mSerialNumberStringCharacteristicData != null) {
                characteristicList.add(mSerialNumberStringCharacteristicData);
            }
            if (mHardwareRevisionStringCharacteristicData != null) {
                characteristicList.add(mHardwareRevisionStringCharacteristicData);
            }
            if (mFirmwareRevisionStringCharacteristicData != null) {
                characteristicList.add(mFirmwareRevisionStringCharacteristicData);
            }
            if (mSoftwareRevisionStringCharacteristicData != null) {
                characteristicList.add(mSoftwareRevisionStringCharacteristicData);
            }
            if (mSystemIdCharacteristicData != null) {
                characteristicList.add(mSystemIdCharacteristicData);
            }
            if (mIEEE_11073_20601_RegulatoryCertificationDataListCharacteristicData != null) {
                characteristicList.add(mIEEE_11073_20601_RegulatoryCertificationDataListCharacteristicData);
            }
            if (mPnpIdCharacteristicData != null) {
                characteristicList.add(mPnpIdCharacteristicData);
            }
            ServiceData serviceData = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceInformationServiceMockCallback build() {
            return new DeviceInformationServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public DeviceInformationServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
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
