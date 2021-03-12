package org.im97mori.ble.service.gap.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.test.peripheral.MockBLEServerConnection;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_HASH_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERVICE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ATTRIBUTE_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GenericAttributeServiceMockCallbackTest {

    @Test
    public void test_onServiceAddSuccess_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        GenericAttributeServiceMockCallback genericAttributeServiceMockCallback = new GenericAttributeServiceMockCallback(new MockData(), false) {
            @Override
            protected void updateGenericAttributeServiceStatus(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService) {
                atomicBoolean.set(true);
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(UUID.randomUUID(), BluetoothGattService.SERVICE_TYPE_PRIMARY);

        assertFalse(genericAttributeServiceMockCallback.onServiceAddSuccess(1, new MockBLEServerConnection(), bluetoothGattService, null));
        assertFalse(atomicBoolean.get());
    }

    @Test
    public void test_onServiceAddSuccess_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        UUID uuid = UUID.randomUUID();
        int serviceInstanceId = 1;
        int serviceType = BluetoothGattService.SERVICE_TYPE_PRIMARY;

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(uuid), 0);
        parcel.writeInt(serviceInstanceId);
        parcel.writeInt(serviceType);
        parcel.writeTypedList(Collections.<BluetoothGattCharacteristic>emptyList());

        parcel.setDataPosition(0);
        BluetoothGattService bluetoothGattService = BluetoothGattService.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        ServiceData serviceData = new ServiceData(uuid, serviceType, Collections.<CharacteristicData>emptyList());
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        GenericAttributeServiceMockCallback genericAttributeServiceMockCallback = new GenericAttributeServiceMockCallback(new MockData(Collections.singletonList(serviceData)), false) {
            @Override
            protected void updateGenericAttributeServiceStatus(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService) {
                atomicBoolean.set(true);
            }
        };

        assertTrue(genericAttributeServiceMockCallback.onServiceAddSuccess(1, new MockBLEServerConnection(), bluetoothGattService, bundle));
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_onServiceRemoveSuccess_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        GenericAttributeServiceMockCallback genericAttributeServiceMockCallback = new GenericAttributeServiceMockCallback(new MockData(), false) {
            @Override
            protected void updateGenericAttributeServiceStatus(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService) {
                atomicBoolean.set(true);
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(UUID.randomUUID(), BluetoothGattService.SERVICE_TYPE_PRIMARY);

        genericAttributeServiceMockCallback.onServiceRemoveSuccess(1, new MockBLEServerConnection(), bluetoothGattService, null);
        assertFalse(atomicBoolean.get());
    }

    @Test
    public void test_onServiceRemoveSuccess_00002() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        UUID uuid = UUID.randomUUID();
        int serviceInstanceId = 1;
        int serviceType = BluetoothGattService.SERVICE_TYPE_PRIMARY;

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(uuid), 0);
        parcel.writeInt(serviceInstanceId);
        parcel.writeInt(serviceType);
        parcel.writeTypedList(Collections.<BluetoothGattCharacteristic>emptyList());

        parcel.setDataPosition(0);
        BluetoothGattService bluetoothGattService = BluetoothGattService.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        ServiceData serviceData = new ServiceData(uuid, serviceType, Collections.<CharacteristicData>emptyList());
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        GenericAttributeServiceMockCallback genericAttributeServiceMockCallback = new GenericAttributeServiceMockCallback(new MockData(Collections.singletonList(serviceData)), false) {
            @Override
            protected void updateGenericAttributeServiceStatus(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService) {
                atomicInteger.addAndGet(1);
            }
        };

        assertTrue(genericAttributeServiceMockCallback.onServiceAddSuccess(1, new MockBLEServerConnection(), bluetoothGattService, bundle));

        genericAttributeServiceMockCallback.onServiceRemoveSuccess(2, new MockBLEServerConnection(), bluetoothGattService, bundle);
        assertEquals(2, atomicInteger.get());
    }

    @Test
    public void test_updateGenericAttributeServiceStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        GenericAttributeServiceMockCallback genericAttributeServiceMockCallback = new GenericAttributeServiceMockCallback(new MockData(), false) {
            @Override
            protected synchronized void startNotification(@Nullable Integer taskId, @NonNull BLEServerConnection bleServerConnection, @Nullable BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int descriptorInstanceId, long delay, @Nullable Integer notificationCount, @Nullable Bundle argument) {
                atomicBoolean.set(true);
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(UUID.randomUUID(), BluetoothGattService.SERVICE_TYPE_PRIMARY);

        genericAttributeServiceMockCallback.updateGenericAttributeServiceStatus(new MockBLEServerConnection(), bluetoothGattService);
        assertFalse(atomicBoolean.get());
    }

    @Test
    public void test_updateGenericAttributeServiceStatus_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        UUID characteristicUUID = DATABASE_HASH_CHARACTERISTIC;
        int characteristicInstanceId = 1;
        int charactereisticProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        int characteristicPermissions = BluetoothGattCharacteristic.PERMISSION_READ;
        int characteristicKeySize = 16;
        int characteristicWriteType = BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT;
        byte[] oldCharacteristicData = new byte[16];
        new Random().nextBytes(oldCharacteristicData);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(characteristicUUID), 0);
        parcel.writeInt(characteristicInstanceId);
        parcel.writeInt(charactereisticProperties);
        parcel.writeInt(characteristicPermissions);
        parcel.writeInt(characteristicKeySize);
        parcel.writeInt(characteristicWriteType);
        parcel.writeTypedList(Collections.<BluetoothGattDescriptor>emptyList());
        parcel.setDataPosition(0);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.setValue(oldCharacteristicData);

        UUID serviceUuid = GENERIC_ATTRIBUTE_SERVICE;
        int serviceInstanceId = 2;
        int serviceType = BluetoothGattService.SERVICE_TYPE_PRIMARY;

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(serviceUuid), 0);
        parcel.writeInt(serviceInstanceId);
        parcel.writeInt(serviceType);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattCharacteristic));

        parcel.setDataPosition(0);
        BluetoothGattService bluetoothGattService = BluetoothGattService.CREATOR.createFromParcel(parcel);
        parcel.recycle();

        CharacteristicData characteristicData = new CharacteristicData(characteristicUUID
                , charactereisticProperties
                , characteristicPermissions
                , Collections.<DescriptorData>emptyList()
                , 0
                , 0
                , oldCharacteristicData
                , 0);
        ServiceData serviceData = new ServiceData(serviceUuid, serviceType, Collections.singletonList(characteristicData));
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        GenericAttributeServiceMockCallback genericAttributeServiceMockCallback = new GenericAttributeServiceMockCallback(new MockData(Collections.singletonList(serviceData)), false) {
            @Override
            protected synchronized void startNotification(@Nullable Integer taskId, @NonNull BLEServerConnection bleServerConnection, @Nullable BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int descriptorInstanceId, long delay, @Nullable Integer notificationCount, @Nullable Bundle argument) {
                atomicBoolean.set(true);
            }

        };

        assertNull(characteristicData.currentData);
        assertTrue(genericAttributeServiceMockCallback.onServiceAddSuccess(1, new MockBLEServerConnection(), bluetoothGattService, bundle));
        assertNotNull(characteristicData.currentData);
        assertFalse(Arrays.equals(oldCharacteristicData, characteristicData.getBytes()));

        assertFalse(atomicBoolean.get());
    }

    @Test
    public void test_updateGenericAttributeServiceStatus_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        UUID descriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        int descriptorInstanceId = 1;
        int descriptorPermission = BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE;

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(descriptorUUID), 0);
        parcel.writeInt(descriptorInstanceId);
        parcel.writeInt(descriptorPermission);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        UUID characteristicUUID = SERVICE_CHANGED_CHARACTERISTIC;
        int characteristicInstanceId = 2;
        int charactereisticProperties = BluetoothGattCharacteristic.PROPERTY_INDICATE;
        int characteristicPermissions = 0;
        int characteristicKeySize = 16;
        int characteristicWriteType = BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT;

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(characteristicUUID), 0);
        parcel.writeInt(characteristicInstanceId);
        parcel.writeInt(charactereisticProperties);
        parcel.writeInt(characteristicPermissions);
        parcel.writeInt(characteristicKeySize);
        parcel.writeInt(characteristicWriteType);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);

        UUID serviceUuid = GENERIC_ATTRIBUTE_SERVICE;
        int serviceInstanceId = 3;
        int serviceType = BluetoothGattService.SERVICE_TYPE_PRIMARY;

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(serviceUuid), 0);
        parcel.writeInt(serviceInstanceId);
        parcel.writeInt(serviceType);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattCharacteristic));

        parcel.setDataPosition(0);
        BluetoothGattService bluetoothGattService = BluetoothGattService.CREATOR.createFromParcel(parcel);
        parcel.recycle();

        DescriptorData descriptorData = new DescriptorData(descriptorUUID
                , descriptorPermission
                , 0
                , 0
                , BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        CharacteristicData characteristicData = new CharacteristicData(characteristicUUID
                , charactereisticProperties
                , characteristicPermissions
                , Collections.singletonList(descriptorData)
                , 0
                , 0
                , null
                , 0);
        ServiceData serviceData = new ServiceData(serviceUuid, serviceType, Collections.singletonList(characteristicData));
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        GenericAttributeServiceMockCallback genericAttributeServiceMockCallback = new GenericAttributeServiceMockCallback(new MockData(Collections.singletonList(serviceData)), false) {
            @Override
            protected synchronized void startNotification(@Nullable Integer taskId, @NonNull BLEServerConnection bleServerConnection, @Nullable BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int descriptorInstanceId, long delay, @Nullable Integer notificationCount, @Nullable Bundle argument) {
                atomicBoolean.set(true);
            }

        };

        assertTrue(genericAttributeServiceMockCallback.onServiceAddSuccess(1, new MockBLEServerConnection(), bluetoothGattService, bundle));
        assertTrue(atomicBoolean.get());
    }

}
