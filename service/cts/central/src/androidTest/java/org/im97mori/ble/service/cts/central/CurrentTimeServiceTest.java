package org.im97mori.ble.service.cts.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformationAndroid;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformationAndroid;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a2b.CurrentTimeAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CURRENT_TIME_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class CurrentTimeServiceTest {

    @Test
    public void test_onBLEDisconnected_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_onBLEDisconnected_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CurrentTimeAndroid currentTimeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, currentTimeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LocalTimeInformationAndroid localTimeInformationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, localTimeInformationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onReferenceTimeInformationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReferenceTimeInformationAndroid referenceTimeInformationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, referenceTimeInformationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onReferenceTimeInformationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onReferenceTimeInformationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CurrentTimeAndroid currentTimeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, currentTimeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LocalTimeInformationAndroid localTimeInformationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, localTimeInformationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CurrentTimeAndroid currentTimeAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, currentTimeAndroid.getBytes());
                isCalled.set(true);
            }

        };

        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_isCurrentTimeCharacteristicWritable_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_isCurrentTimeCharacteristicWritable_00002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_isCurrentTimeCharacteristicWritable_00003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicSupporeted_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicSupporeted_00002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicSupporeted_00003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_isReferenceTimeInformationCharacteristicSupporeted_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_isReferenceTimeInformationCharacteristicSupporeted_00002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_isReferenceTimeInformationCharacteristicSupporeted_00003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_getCurrentTime_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getCurrentTime());
    }

    @Test
    public void test_getCurrentTime_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getCurrentTime());
    }

    @Test
    public void test_getCurrentTime_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getCurrentTime();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setCurrentTime_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        assertNull(currentTimeService.setCurrentTime(currentTime));
    }

    @Test
    public void test_setCurrentTime_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        assertNull(currentTimeService.setCurrentTime(currentTime));
    }

    @Test
    public void test_setCurrentTime_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isCurrentTimeCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        assertNull(currentTimeService.setCurrentTime(currentTime));
    }

    @Test
    public void test_setCurrentTime_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isCurrentTimeCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        Integer taskId = currentTimeService.setCurrentTime(currentTime);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getCurrentTimeClientCharacteristicConfiguration_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCurrentTimeClientCharacteristicConfiguration_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCurrentTimeClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getCurrentTimeClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startCurrentTimeNotification_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.startCurrentTimeNotification());
    }

    @Test
    public void test_startCurrentTimeNotification_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.startCurrentTimeNotification());
    }

    @Test
    public void test_startCurrentTimeNotification_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.startCurrentTimeNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopCurrentTimeNotification_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.stopCurrentTimeNotification());
    }

    @Test
    public void test_stopCurrentTimeNotification_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.stopCurrentTimeNotification());
    }

    @Test
    public void test_stopCurrentTimeNotification_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.stopCurrentTimeNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getLocalTimeInformation_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getLocalTimeInformation());
    }

    @Test
    public void test_getLocalTimeInformation_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getLocalTimeInformation());
    }

    @Test
    public void test_getLocalTimeInformation_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getLocalTimeInformation());
    }

    @Test
    public void test_getLocalTimeInformation_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getLocalTimeInformation();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setLocalTimeInformation_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        assertNull(currentTimeService.setLocalTimeInformation(localTimeInformation));
    }

    @Test
    public void test_setLocalTimeInformation_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        assertNull(currentTimeService.setLocalTimeInformation(localTimeInformation));
    }

    @Test
    public void test_setLocalTimeInformation_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        assertNull(currentTimeService.setLocalTimeInformation(localTimeInformation));
    }

    @Test
    public void test_setLocalTimeInformation_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        Integer taskId = currentTimeService.setLocalTimeInformation(localTimeInformation);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getReferenceTimeInformation_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getReferenceTimeInformation());
    }

    @Test
    public void test_getReferenceTimeInformation_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getReferenceTimeInformation());
    }

    @Test
    public void test_getReferenceTimeInformation_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(new MockBLEConnection(), new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isReferenceTimeInformationCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getReferenceTimeInformation());
    }

    @Test
    public void test_getReferenceTimeInformation_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(mockBLEConnection, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isReferenceTimeInformationCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getReferenceTimeInformation();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
