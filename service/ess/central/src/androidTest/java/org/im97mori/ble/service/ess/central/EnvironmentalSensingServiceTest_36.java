package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DEW_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ELEVATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TDS_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.EXTERNAL_REPORT_REFERENCE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable"})
public class EnvironmentalSensingServiceTest_36 {

    @Test
    public void test_onSetNotificationFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00010() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00011() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00012() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00210() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00211() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00212() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00306() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00307() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00308() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00309() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00310() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00311() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00312() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00406() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00407() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00408() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00409() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00410() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00411() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00412() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00506() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00507() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00508() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00509() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00510() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00511() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00512() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00606() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00607() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00608() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00609() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00610() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00611() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00612() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00706() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00707() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00708() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00709() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00710() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00711() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00712() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00806() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00807() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00808() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00809() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00810() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00811() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00812() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00906() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00907() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00908() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00909() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00910() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00911() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_00912() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01010() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01011() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01012() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01110() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01111() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01112() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
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
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01210() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01211() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01212() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01306() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01307() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01308() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01309() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01310() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01311() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01312() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01406() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01407() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01408() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01409() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01410() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01411() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01412() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01506() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01507() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01508() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01509() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01510() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01511() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01512() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01606() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01607() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01608() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01609() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01610() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01611() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01612() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01706() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01707() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01708() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01709() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01710() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01711() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01712() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01806() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01807() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01808() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01809() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01810() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01811() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01812() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01906() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01907() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01908() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01909() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01910() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01911() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_01912() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02010() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02011() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationFailed_02012() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_isDescriptorValueChangedCharacteristicSupporeted_00009() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onBLEDisconnected(2, MockBLEConnection.MOCK_DEVICE, BluetoothGatt.GATT_SUCCESS, null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

}