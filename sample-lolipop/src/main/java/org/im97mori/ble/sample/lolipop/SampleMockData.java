package org.im97mori.ble.sample.lolipop;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

@SuppressWarnings("WeakerAccess")
public class SampleMockData extends MockData {

    public static final UUID SAMPLE_PRIMARY_SERVICE_1 = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_READABLE_CHARACTERISTIC = UUID.fromString("00000010-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_READABLE_DESCRIPTOR = UUID.fromString("00000100-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_WRITABLE_CHARACTERISTIC = UUID.fromString("00000020-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_WRITABLE_DESCRIPTOR = UUID.fromString("00000200-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_NOTIFICATABLE_CHARACTERISTIC = UUID.fromString("00000030-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_INDICATABLE_CHARACTERISTIC = UUID.fromString("00000040-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_WRITE_CHARACTERISTIC_RELIABLE = UUID.fromString("00000050-a087-4fa3-add4-3b8a7d5d4921");

    public static final UUID SAMPLE_PRIMARY_SERVICE_2 = UUID.fromString("00000002-a087-4fa3-add4-3b8a7d5d4922");

    public static final UUID SAMPLE_READABLE_CHARACTERISTIC_2 = UUID.fromString("00000060-a087-4fa3-add4-3b8a7d5d4921");


    public static class Builder {

        private final List<ServiceData> mServiceDataList = new LinkedList<>();

        public Builder() {
            ServiceData serviceData;
            CharacteristicData characteristicData;
            List<CharacteristicData> characteristicDataList;
            DescriptorData descriptorData;
            List<DescriptorData> descriptorDataList;

            characteristicDataList = new LinkedList<>();
            descriptorDataList = new LinkedList<>();
            descriptorData = new DescriptorData();
            descriptorData.uuid = SAMPLE_READABLE_DESCRIPTOR;
            descriptorData.permission = BluetoothGattDescriptor.PERMISSION_READ;
            descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
            descriptorData.delay = 0;
            descriptorData.data = SAMPLE_READABLE_DESCRIPTOR.toString().getBytes();
            descriptorDataList.add(descriptorData);
            characteristicData = new CharacteristicData();
            characteristicData.uuid = SAMPLE_READABLE_CHARACTERISTIC;
            characteristicData.property = BluetoothGattCharacteristic.PROPERTY_READ;
            characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_READ;
            characteristicData.descriptorDataList = descriptorDataList;
            characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
            characteristicData.delay = 0;
            characteristicData.data = SAMPLE_READABLE_CHARACTERISTIC.toString().getBytes();
            characteristicDataList.add(characteristicData);

            descriptorDataList = new LinkedList<>();
            descriptorData = new DescriptorData();
            descriptorData.uuid = SAMPLE_WRITABLE_DESCRIPTOR;
            descriptorData.permission = BluetoothGattDescriptor.PERMISSION_WRITE;
            descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
            descriptorData.delay = 0;
            descriptorData.data = null;
            descriptorDataList.add(descriptorData);
            characteristicData = new CharacteristicData();
            characteristicData.uuid = SAMPLE_WRITABLE_CHARACTERISTIC;
            characteristicData.property = BluetoothGattCharacteristic.PROPERTY_WRITE;
            characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_WRITE;
            characteristicData.descriptorDataList = descriptorDataList;
            characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
            characteristicData.delay = 0;
            characteristicData.data = null;
            characteristicDataList.add(characteristicData);

            descriptorDataList = new LinkedList<>();
            descriptorData = new DescriptorData();
            descriptorData.uuid = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
            descriptorData.permission = BluetoothGattDescriptor.PERMISSION_WRITE;
            descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
            descriptorData.delay = 0;
            descriptorData.data = null;
            descriptorDataList.add(descriptorData);
            characteristicData = new CharacteristicData();
            characteristicData.uuid = SAMPLE_NOTIFICATABLE_CHARACTERISTIC;
            characteristicData.property = BluetoothGattCharacteristic.PROPERTY_NOTIFY;
            characteristicData.permission = 0;
            characteristicData.descriptorDataList = descriptorDataList;
            characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
            characteristicData.delay = 0;
            characteristicData.data = SAMPLE_NOTIFICATABLE_CHARACTERISTIC.toString().getBytes();
            characteristicData.notificationCount = 10;
            characteristicDataList.add(characteristicData);

            descriptorDataList = new LinkedList<>();
            descriptorData = new DescriptorData();
            descriptorData.uuid = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
            descriptorData.permission = BluetoothGattDescriptor.PERMISSION_WRITE;
            descriptorData.responseCode = BluetoothGatt.GATT_SUCCESS;
            descriptorData.delay = 0;
            descriptorData.data = null;
            descriptorDataList.add(descriptorData);
            characteristicData = new CharacteristicData();
            characteristicData.uuid = SAMPLE_INDICATABLE_CHARACTERISTIC;
            characteristicData.property = BluetoothGattCharacteristic.PROPERTY_INDICATE;
            characteristicData.permission = 0;
            characteristicData.descriptorDataList = descriptorDataList;
            characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
            characteristicData.delay = 0;
            characteristicData.data = SAMPLE_INDICATABLE_CHARACTERISTIC.toString().getBytes();
            characteristicData.notificationCount = 10;
            characteristicDataList.add(characteristicData);

            descriptorDataList = new LinkedList<>();
            characteristicData = new CharacteristicData();
            characteristicData.uuid = SAMPLE_WRITE_CHARACTERISTIC_RELIABLE;
            characteristicData.property = BluetoothGattCharacteristic.PROPERTY_WRITE;
            characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_WRITE;
            characteristicData.descriptorDataList = descriptorDataList;
            characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
            characteristicData.delay = 0;
            characteristicData.data = null;
            characteristicDataList.add(characteristicData);
            serviceData = new ServiceData();
            serviceData.uuid = SAMPLE_PRIMARY_SERVICE_1;
            serviceData.type = BluetoothGattService.SERVICE_TYPE_PRIMARY;
            serviceData.characteristicDataList = characteristicDataList;
            mServiceDataList.add(serviceData);

            characteristicDataList = new LinkedList<>();
            characteristicData = new CharacteristicData();
            characteristicData.uuid = SAMPLE_READABLE_CHARACTERISTIC_2;
            characteristicData.property = BluetoothGattCharacteristic.PROPERTY_READ;
            characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_READ;
            characteristicData.descriptorDataList = descriptorDataList;
            characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
            characteristicData.delay = 0;
            characteristicData.data = SAMPLE_READABLE_CHARACTERISTIC_2.toString().getBytes();
            characteristicDataList.add(characteristicData);
            characteristicData = new CharacteristicData();
            characteristicData.uuid = SAMPLE_READABLE_CHARACTERISTIC_2;
            characteristicData.property = BluetoothGattCharacteristic.PROPERTY_READ;
            characteristicData.permission = BluetoothGattCharacteristic.PERMISSION_READ;
            characteristicData.descriptorDataList = descriptorDataList;
            characteristicData.responseCode = BluetoothGatt.GATT_SUCCESS;
            characteristicData.delay = 0;
            characteristicData.data = SAMPLE_READABLE_CHARACTERISTIC_2.toString().getBytes();
            characteristicDataList.add(characteristicData);
            serviceData = new ServiceData();
            serviceData.uuid = SAMPLE_PRIMARY_SERVICE_2;
            serviceData.type = BluetoothGattService.SERVICE_TYPE_PRIMARY;
            serviceData.characteristicDataList = characteristicDataList;
            mServiceDataList.add(serviceData);
        }

        public SampleMockData build() {
            SampleMockData sampleMockData = new SampleMockData();
            sampleMockData.serviceDataList = mServiceDataList;
            return sampleMockData;
        }
    }

}
