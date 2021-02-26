package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
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
import static org.im97mori.ble.BLEConstants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable"})
public class EnvironmentalSensingServiceTest_35 {

    @Test
    public void test_onSetNotificationSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00010() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00011() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00012() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onApparentWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00210() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00211() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00212() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onApparentWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onDewPointNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onDewPointNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onDewPointNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onDewPointNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00306() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onDewPointNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00307() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00308() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onDewPointNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00309() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onDewPointNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00310() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onDewPointNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00311() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onDewPointNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00312() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onDewPointNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onElevationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onElevationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onElevationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onElevationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00406() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onElevationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00407() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00408() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onElevationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00409() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onElevationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00410() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onElevationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00411() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onElevationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00412() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onElevationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onGustFactorNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onGustFactorNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onGustFactorNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onGustFactorNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00506() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onGustFactorNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00507() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00508() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onGustFactorNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00509() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onGustFactorNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00510() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onGustFactorNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00511() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onGustFactorNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00512() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onGustFactorNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00606() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHeatIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00607() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00608() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00609() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00610() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00611() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00612() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHeatIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHumidityNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHumidityNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHumidityNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHumidityNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00706() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onHumidityNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00707() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00708() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHumidityNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00709() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHumidityNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00710() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHumidityNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00711() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHumidityNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00712() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onHumidityNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onIrradianceNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onIrradianceNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onIrradianceNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onIrradianceNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00806() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onIrradianceNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00807() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00808() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onIrradianceNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00809() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onIrradianceNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00810() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onIrradianceNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00811() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onIrradianceNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00812() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onIrradianceNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00906() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPollenConcentrationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00907() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00908() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00909() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00910() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00911() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_00912() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPollenConcentrationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onRainfallNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onRainfallNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onRainfallNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onRainfallNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onRainfallNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onRainfallNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onRainfallNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01010() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onRainfallNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01011() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onRainfallNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01012() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onRainfallNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPressureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPressureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPressureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPressureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onPressureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPressureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPressureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01110() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPressureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01111() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPressureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01112() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onPressureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTemperatureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTemperatureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTemperatureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTemperatureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTemperatureNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTemperatureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTemperatureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01210() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTemperatureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01211() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTemperatureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01212() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTemperatureNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01306() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindDirectionNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01307() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01308() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01309() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01310() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01311() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01312() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindDirectionNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01406() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onTrueWindSpeedNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01407() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01408() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01409() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01410() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01411() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01412() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onTrueWindSpeedNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onUVIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onUVIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onUVIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onUVIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01506() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onUVIndexNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01507() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01508() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onUVIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01509() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onUVIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01510() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onUVIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01511() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onUVIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01512() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onUVIndexNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onWindChillNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onWindChillNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onWindChillNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onWindChillNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01606() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onWindChillNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01607() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01608() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onWindChillNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01609() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onWindChillNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01610() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onWindChillNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01611() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onWindChillNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01612() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onWindChillNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01706() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onBarometricPressureTrendNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01707() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01708() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01709() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01710() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01711() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01712() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onBarometricPressureTrendNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01806() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticDeclinationNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01807() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01808() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01809() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01810() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01811() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01812() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticDeclinationNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01906() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity2DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01907() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01908() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01909() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01910() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01911() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_01912() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity2DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
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
            public void onMagneticFluxDensity3DNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02010() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02011() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onSetNotificationSuccess_02012() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = false;
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
            public void onMagneticFluxDensity3DNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };

        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

}
