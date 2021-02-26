package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TDS_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.REPORT_REFERENCE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable"})
public class EnvironmentalSensingServiceTest_11 {

    @Test
    public void test_onDescriptorReadFailed_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00906() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00907() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00908() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00909() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00910() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00911() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00912() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00913() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00914() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00915() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00916() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00917() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00919() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00920() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00921() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00922() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00923() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00924() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00925() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00926() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00927() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00928() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00929() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00930() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00931() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00932() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00933() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00934() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00935() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00936() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00937() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00938() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00939() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00940() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00941() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00942() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00943() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00944() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00945() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00946() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00947() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00948() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00949() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00950() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00951() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00952() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_00953() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01010() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01011() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01012() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01013() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01014() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01015() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01016() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01017() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01019() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01020() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01021() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01022() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01023() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01024() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01025() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01026() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01027() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01028() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01029() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01030() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01031() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01032() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01033() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01034() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01035() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01036() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01037() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01038() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01039() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01040() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01041() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01042() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01043() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01044() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01045() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01046() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01047() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01048() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01049() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01050() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01051() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01052() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01053() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01110() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01111() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01112() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01113() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01114() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01115() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01116() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01117() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01119() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01120() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01121() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01122() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01123() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01124() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01125() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01126() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01127() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01128() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01129() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01130() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01131() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01132() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01133() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01134() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01135() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01136() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01137() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01138() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01139() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01140() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01141() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01142() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01143() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01144() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01145() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01146() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01147() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01148() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01149() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01150() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01151() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01152() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01153() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01210() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingMeasurementReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01211() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01212() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01213() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01214() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01215() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01216() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01217() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01219() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01220() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01221() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01222() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01223() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();

        parcel.writeParcelable(new ParcelUuid(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR), 0);
        parcel.writeInt(originalDescriptorInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);

        parcel.setDataPosition(0);
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.singletonList(bluetoothGattDescriptor));
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01224() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01225() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01226() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01227() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01228() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01229() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01230() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01231() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01232() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01233() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureEnvironmentalSensingConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01234() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01235() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01236() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01237() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01238() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01239() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01240() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01241() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01242() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01243() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01244() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01245() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01246() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01247() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01248() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01249() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01250() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01251() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01252() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onDescriptorReadFailed_01253() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(Collections.<Parcelable>emptyList());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

}
