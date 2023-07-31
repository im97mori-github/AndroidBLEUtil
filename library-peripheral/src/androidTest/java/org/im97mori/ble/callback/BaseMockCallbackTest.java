package org.im97mori.ble.callback;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
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
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/** @noinspection DataFlowIssue*/
public class BaseMockCallbackTest extends AbstractPeripheralTest {

    static class BaseMockCallbackInner extends BaseMockCallback {
        /**
         * @param mockData   {@link MockData} instance
         * @param isFallback fallback flag
         */
        BaseMockCallbackInner(@NonNull MockData mockData, boolean isFallback) {
            super(mockData, isFallback);
        }

        public BaseMockCallbackInner(@NonNull List<MockData> mockDataList, boolean isFallback) {
            super(mockDataList, isFallback);
        }

        @Override
        public void onServerStarted() {

        }

        @Override
        public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {

        }

        @Override
        public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {

        }

        @Override
        public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

        }

        @Override
        public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {

        }

        @Override
        public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {

        }

        @Override
        public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

        }

        @Override
        public void onAdvertisingStartFailed(@Nullable Integer errorCode) {

        }

        @Override
        public void onAdvertisingFinished() {

        }
    }

    @Test
    public void test_constructor_001() {
        UUID serviceUUID1 = UUID.randomUUID();
        int serviceType1 = 1;
        ServiceData serviceData1 = new ServiceData(serviceUUID1
                , serviceType1
                , new ArrayList<>());
        MockData mockData1 = new MockData(Collections.singletonList(serviceData1));

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();

        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(mockData1, true);
        baseMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(serviceUUID1, bluetoothGattService.getUuid());
        assertEquals(serviceType1, bluetoothGattService.getType());
        assertEquals(0, bluetoothGattService.getCharacteristics().size());
    }

    @Test
    public void test_constructor_002() {
        UUID serviceUUID1 = UUID.randomUUID();
        int serviceType1 = 1;
        ServiceData serviceData1 = new ServiceData(serviceUUID1
                , serviceType1
                , new ArrayList<>());
        MockData mockData1 = new MockData(Collections.singletonList(serviceData1));

        UUID serviceUUID2 = UUID.randomUUID();
        int serviceType2 = 2;
        ServiceData serviceData2 = new ServiceData(serviceUUID2
                , serviceType2
                , new ArrayList<>());
        MockData mockData2 = new MockData(Collections.singletonList(serviceData2));

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();

        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(Arrays.asList(mockData1, mockData2), true);
        baseMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(2, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(serviceUUID1, bluetoothGattService.getUuid());
        assertEquals(serviceType1, bluetoothGattService.getType());
        bluetoothGattService = bluetoothGattServiceList.get(1);
        assertEquals(serviceUUID2, bluetoothGattService.getUuid());
        assertEquals(serviceType2, bluetoothGattService.getType());
    }

    @Test
    public void test_setup_001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceType = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicProperty = 2;
        int characteristicPermission = 3;
        int characteristicResponseCode = 4;
        long characteristicDelay = 5;
        byte[] characteristicDataArray = new byte[]{6};
        int notificationCount = 7;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorPermission = 8;
        int descriptorResponseCode = 9;
        long descriptorDelay = 10;
        byte[] descriptorDataArray = new byte[]{11};

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();

        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        DescriptorData descriptorData = new DescriptorData(descriptorUUID
                , descriptorPermission
                , descriptorResponseCode
                , descriptorDelay
                , descriptorDataArray);
        CharacteristicData characteristicData = new CharacteristicData(characteristicUUID
                , characteristicProperty
                , characteristicPermission
                , Collections.singletonList(descriptorData)
                , characteristicResponseCode
                , characteristicDelay
                , characteristicDataArray
                , notificationCount);
        ServiceData serviceData = new ServiceData(serviceUUID
                , serviceType
                , Collections.singletonList(characteristicData));
        MockData mockData = new MockData(Collections.singletonList(serviceData));
        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(mockData, true);
        baseMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(serviceUUID, bluetoothGattService.getUuid());
        assertEquals(serviceType, bluetoothGattService.getType());
        assertEquals(1, bluetoothGattService.getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristics().get(0);
        assertEquals(characteristicUUID, bluetoothGattCharacteristic.getUuid());
        assertEquals(characteristicProperty, bluetoothGattCharacteristic.getProperties());
        assertEquals(characteristicPermission, bluetoothGattCharacteristic.getPermissions());
        assertEquals(1, bluetoothGattCharacteristic.getDescriptors().size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptors().get(0);
        assertEquals(descriptorUUID, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_tearDown_001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceType = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicProperty = 2;
        int characteristicPermission = 3;
        int characteristicResponseCode = 4;
        long characteristicDelay = 5;
        byte[] characteristicDataArray = new byte[]{6};
        int notificationCount = 7;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorPermission = 8;
        int descriptorResponseCode = 9;
        long descriptorDelay = 10;
        byte[] descriptorDataArray = new byte[]{11};

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateRemoveServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        DescriptorData descriptorData = new DescriptorData(descriptorUUID
                , descriptorPermission
                , descriptorResponseCode
                , descriptorDelay
                , descriptorDataArray);
        CharacteristicData characteristicData = new CharacteristicData(characteristicUUID
                , characteristicProperty
                , characteristicPermission
                , Collections.singletonList(descriptorData)
                , characteristicResponseCode
                , characteristicDelay
                , characteristicDataArray
                , notificationCount);
        ServiceData serviceData = new ServiceData(serviceUUID
                , serviceType
                , Collections.singletonList(characteristicData));
        MockData mockData = new MockData(Collections.singletonList(serviceData));

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(descriptorUUID, descriptorPermission);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(characteristicUUID, characteristicProperty, characteristicPermission);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(serviceUUID, serviceType);

        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(mockData, true);
        assertTrue(baseMockCallback.onServiceAddSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle));
        baseMockCallback.tearDown(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(bluetoothGattService, bluetoothGattServiceList.get(0));
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_onServiceAddSuccess_001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceType = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicProperty = 2;
        int characteristicPermission = 3;
        int characteristicResponseCode = 4;
        long characteristicDelay = 5;
        byte[] characteristicDataArray = new byte[]{6};
        int notificationCount = 7;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorPermission = 8;
        int descriptorResponseCode = 9;
        long descriptorDelay = 10;
        byte[] descriptorDataArray = new byte[]{11};

        DescriptorData descriptorData = new DescriptorData(descriptorUUID
                , descriptorPermission
                , descriptorResponseCode
                , descriptorDelay
                , descriptorDataArray);
        CharacteristicData characteristicData = new CharacteristicData(characteristicUUID
                , characteristicProperty
                , characteristicPermission
                , Collections.singletonList(descriptorData)
                , characteristicResponseCode
                , characteristicDelay
                , characteristicDataArray
                , notificationCount);
        ServiceData serviceData = new ServiceData(serviceUUID
                , serviceType
                , Collections.singletonList(characteristicData));
        MockData mockData = new MockData(Collections.singletonList(serviceData));

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(descriptorUUID, descriptorPermission);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(characteristicUUID, characteristicProperty, characteristicPermission);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(serviceUUID, serviceType);

        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(mockData, true);
        assertTrue(baseMockCallback.onServiceAddSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle));
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_onServiceAddSuccess_002() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceType = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicProperty = 2;
        int characteristicPermission = 3;
        int characteristicResponseCode = 4;
        long characteristicDelay = 5;
        byte[] characteristicDataArray = new byte[]{6};
        int notificationCount = 7;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorPermission = 8;
        int descriptorResponseCode = 9;
        long descriptorDelay = 10;
        byte[] descriptorDataArray = new byte[]{11};

        DescriptorData descriptorData = new DescriptorData(descriptorUUID
                , descriptorPermission
                , descriptorResponseCode
                , descriptorDelay
                , descriptorDataArray);
        CharacteristicData characteristicData = new CharacteristicData(characteristicUUID
                , characteristicProperty
                , characteristicPermission
                , Collections.singletonList(descriptorData)
                , characteristicResponseCode
                , characteristicDelay
                , characteristicDataArray
                , notificationCount);
        ServiceData serviceData = new ServiceData(serviceUUID
                , serviceType
                , Collections.singletonList(characteristicData));
        MockData mockData = new MockData(Collections.singletonList(serviceData));

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(descriptorUUID, descriptorPermission);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(characteristicUUID, characteristicProperty, characteristicPermission);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(serviceUUID, serviceType);

        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(mockData, true);
        assertTrue(baseMockCallback.onServiceAddSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle));
        assertFalse(baseMockCallback.onServiceAddSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle));
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_onServiceAddSuccess_003() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceType = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicProperty = 2;
        int characteristicPermission = 3;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorPermission = 8;

        ServiceData serviceData = new ServiceData(serviceUUID
                , serviceType
                , new ArrayList<>());
        MockData mockData = new MockData(new ArrayList<>());

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(descriptorUUID, descriptorPermission);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(characteristicUUID, characteristicProperty, characteristicPermission);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(serviceUUID, serviceType);

        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(mockData, true);
        assertFalse(baseMockCallback.onServiceAddSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle));
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_onServiceRemoveSuccess_001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceType = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicProperty = 2;
        int characteristicPermission = 3;
        int characteristicResponseCode = 4;
        long characteristicDelay = 5;
        byte[] characteristicDataArray = new byte[]{6};
        int notificationCount = 7;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorPermission = 8;
        int descriptorResponseCode = 9;
        long descriptorDelay = 10;
        byte[] descriptorDataArray = new byte[]{11};

        DescriptorData descriptorData = new DescriptorData(descriptorUUID
                , descriptorPermission
                , descriptorResponseCode
                , descriptorDelay
                , descriptorDataArray);
        CharacteristicData characteristicData = new CharacteristicData(characteristicUUID
                , characteristicProperty
                , characteristicPermission
                , Collections.singletonList(descriptorData)
                , characteristicResponseCode
                , characteristicDelay
                , characteristicDataArray
                , notificationCount);
        ServiceData serviceData = new ServiceData(serviceUUID
                , serviceType
                , Collections.singletonList(characteristicData));
        MockData mockData = new MockData(Collections.singletonList(serviceData));

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(descriptorUUID, descriptorPermission);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(characteristicUUID, characteristicProperty, characteristicPermission);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(serviceUUID, serviceType);

        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SERVICE_DATA", serviceData);

        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(mockData, true);
        assertTrue(baseMockCallback.onServiceAddSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle));
        baseMockCallback.onServiceRemoveSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle);
        assertTrue(baseMockCallback.onServiceAddSuccess(null, MOCK_BLE_SERVER_CONNECTION, bluetoothGattService, bundle));
    }

    @Test
    public void test_isFallback_001() {
        boolean isFallback = true;
        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(new MockData(Collections.emptyList()), isFallback);
        assertEquals(isFallback, baseMockCallback.isFallback());
    }

    @Test
    public void test_isFallback_002() {
        boolean isFallback = false;
        BaseMockCallbackInner baseMockCallback = new BaseMockCallbackInner(new MockData(Collections.emptyList()), isFallback);
        assertEquals(isFallback, baseMockCallback.isFallback());
    }

}
