package org.im97mori.ble.service.gatt.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a00.DeviceName;
import org.im97mori.ble.characteristic.u2a00.DeviceNameAndroid;
import org.im97mori.ble.characteristic.u2a01.Appearance;
import org.im97mori.ble.characteristic.u2a01.AppearanceAndroid;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlag;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlagAndroid;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddress;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddressAndroid;
import org.im97mori.ble.characteristic.u2a04.PeripheralPreferredConnectionParametersAndroid;
import org.im97mori.ble.characteristic.u2aa6.CentralAddressResolutionAndroid;
import org.im97mori.ble.characteristic.u2ac9.ResolvablePrivateAddressOnlyAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.APPEARANCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GenericAccessServiceTest extends AbstractCentralTest {

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DEVICE_NAME_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DEVICE_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPEARANCE_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00105() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPEARANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00201() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00202() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00203() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00204() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00205() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00301() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00302() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00303() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00304() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00305() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00401() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00402() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00403() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00404() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00405() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00501() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00502() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00503() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00504() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00505() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00601() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00602() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00603() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00604() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00605() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00701() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00702() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00703() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00704() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, 0, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00705() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00706() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00707() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEVICE_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onDeviceNameReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DeviceNameAndroid deviceNameAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, deviceNameAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPEARANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onAppearanceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AppearanceAndroid appearanceAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, appearanceAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPreferredConnectionParametersReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PeripheralPreferredConnectionParametersAndroid peripheralPreferredConnectionParametersAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, peripheralPreferredConnectionParametersAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onCentralAddressResolutionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CentralAddressResolutionAndroid centralAddressResolutionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, centralAddressResolutionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onResolvablePrivateAddressOnlyReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ResolvablePrivateAddressOnlyAndroid resolvablePrivateAddressOnlyAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, resolvablePrivateAddressOnlyAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{1};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPrivacyFlagReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PeripheralPrivacyFlagAndroid peripheralPrivacyFlagAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, peripheralPrivacyFlagAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEVICE_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onDeviceNameReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPEARANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onAppearanceReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPreferredConnectionParametersReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onCentralAddressResolutionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onResolvablePrivateAddressOnlyReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPrivacyFlagReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEVICE_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onDeviceNameReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPEARANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onAppearanceReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPreferredConnectionParametersReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onCentralAddressResolutionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onResolvablePrivateAddressOnlyReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPrivacyFlagReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEVICE_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onDeviceNameWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull DeviceNameAndroid deviceNameAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, deviceNameAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPEARANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onAppearanceWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AppearanceAndroid appearanceAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, appearanceAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7, 8, 9};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onReconnectionAddressWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReconnectionAddressAndroid reconnectionAddressAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, reconnectionAddressAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{1};
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPrivacyFlagWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PeripheralPrivacyFlagAndroid peripheralPrivacyFlagAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, peripheralPrivacyFlagAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEVICE_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onDeviceNameWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPEARANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onAppearanceWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onReconnectionAddressWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPrivacyFlagWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEVICE_NAME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onDeviceNameWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPEARANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onAppearanceWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RECONNECTION_ADDRESS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onReconnectionAddressWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockGenericAccessServiceCallback mockGenericAccessServiceCallback = new MockGenericAccessServiceCallback() {

            @Override
            public void onPeripheralPrivacyFlagWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, mockGenericAccessServiceCallback, null);
        genericAccessService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_isDeviceNameCharacteristicWritable_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_isDeviceNameCharacteristicWritable_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_isDeviceNameCharacteristicWritable_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_NAME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isDeviceNameCharacteristicWritable());
    }

    @Test
    public void test_isAppearanceCharacteristicWritable_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_isAppearanceCharacteristicWritable_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPEARANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_isAppearanceCharacteristicWritable_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPEARANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isAppearanceCharacteristicWritable());
    }

    @Test
    public void test_isPeripheralPreferredConnectionParametersCharacteristicSupported_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPreferredConnectionParametersCharacteristicSupported_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPreferredConnectionParametersCharacteristicSupported_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported());
    }

    @Test
    public void test_isCentralAddressResolutionCharacteristicSupported_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_isCentralAddressResolutionCharacteristicSupported_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_isCentralAddressResolutionCharacteristicSupported_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isCentralAddressResolutionCharacteristicSupported());
    }

    @Test
    public void test_isResolvablePrivateAddressOnlyCharacteristicSupported_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_isResolvablePrivateAddressOnlyCharacteristicSupported_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_isResolvablePrivateAddressOnlyCharacteristicSupported_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported());
    }

    @Test
    public void test_isReconnectionAddressCharacteristicSupported_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_isReconnectionAddressCharacteristicSupported_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_isReconnectionAddressCharacteristicSupported_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isReconnectionAddressCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicSupported_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicSupported_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicSupported_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicSupported());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicWritable_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicWritable_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_isPeripheralPrivacyFlagCharacteristicWritable_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        genericAccessService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        genericAccessService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(genericAccessService.isPeripheralPrivacyFlagCharacteristicWritable());
    }

    @Test
    public void test_getDeviceName_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.getDeviceName());
    }

    @Test
    public void test_getDeviceName_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getDeviceName());
    }

    @Test
    public void test_getDeviceName_00003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.getDeviceName();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setDeviceName_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.setDeviceName(new DeviceName("")));
    }

    @Test
    public void test_setDeviceName_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setDeviceName(new DeviceName("")));
    }

    @Test
    public void test_setDeviceName_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isDeviceNameCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setDeviceName(new DeviceName("")));
    }

    @Test
    public void test_setDeviceName_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isDeviceNameCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.setDeviceName(new DeviceName(""));
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getAppearance_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.getAppearance());
    }

    @Test
    public void test_getAppearance_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getAppearance());
    }

    @Test
    public void test_getAppearance_00003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.getAppearance();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAppearance_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.setAppearance(new Appearance(new byte[]{0, 1})));
    }

    @Test
    public void test_setAppearance_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setAppearance(new Appearance(new byte[]{0, 1})));
    }

    @Test
    public void test_setAppearance_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isAppearanceCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setAppearance(new Appearance(new byte[]{0, 1})));
    }

    @Test
    public void test_setAppearance_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isAppearanceCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.setAppearance(new Appearance(new byte[]{0, 1}));
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getPeripheralPreferredConnectionParameters_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.getPeripheralPreferredConnectionParameters());
    }

    @Test
    public void test_getPeripheralPreferredConnectionParameters_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getPeripheralPreferredConnectionParameters());
    }

    @Test
    public void test_getPeripheralPreferredConnectionParameters_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isPeripheralPreferredConnectionParametersCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getPeripheralPreferredConnectionParameters());
    }

    @Test
    public void test_getPeripheralPreferredConnectionParameters_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isPeripheralPreferredConnectionParametersCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.getPeripheralPreferredConnectionParameters();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getCentralAddressResolutionParameters_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.getCentralAddressResolutionParameters());
    }

    @Test
    public void test_getCentralAddressResolutionParameters_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getCentralAddressResolutionParameters());
    }

    @Test
    public void test_getCentralAddressResolutionParameters_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isCentralAddressResolutionCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getCentralAddressResolutionParameters());
    }

    @Test
    public void test_getCentralAddressResolutionParameters_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isCentralAddressResolutionCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.getCentralAddressResolutionParameters();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getResolvablePrivateAddressOnly_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.getResolvablePrivateAddressOnly());
    }

    @Test
    public void test_getResolvablePrivateAddressOnly_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getResolvablePrivateAddressOnly());
    }

    @Test
    public void test_getResolvablePrivateAddressOnly_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isResolvablePrivateAddressOnlyCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getResolvablePrivateAddressOnly());
    }

    @Test
    public void test_getResolvablePrivateAddressOnly_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isResolvablePrivateAddressOnlyCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.getResolvablePrivateAddressOnly();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setReconnectionAddress_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.setReconnectionAddress(new ReconnectionAddress(new byte[]{0, 1, 2, 3, 4, 5, 6, 7})));
    }

    @Test
    public void test_setReconnectionAddress_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setReconnectionAddress(new ReconnectionAddress(new byte[]{0, 1, 2, 3, 4, 5, 6, 7})));
    }

    @Test
    public void test_setReconnectionAddress_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isReconnectionAddressCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setReconnectionAddress(new ReconnectionAddress(new byte[]{0, 1, 2, 3, 4, 5, 6, 7})));
    }

    @Test
    public void test_setReconnectionAddress_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isReconnectionAddressCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.setReconnectionAddress(new ReconnectionAddress(new byte[]{0, 1, 2, 3, 4, 5, 6, 7}));
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getPeripheralPrivacyFlag_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.getPeripheralPrivacyFlag());
    }

    @Test
    public void test_getPeripheralPrivacyFlag_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getPeripheralPrivacyFlag());
    }

    @Test
    public void test_getPeripheralPrivacyFlag_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isPeripheralPrivacyFlagCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.getPeripheralPrivacyFlag());
    }

    @Test
    public void test_getPeripheralPrivacyFlag_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isPeripheralPrivacyFlagCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.getPeripheralPrivacyFlag();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setPeripheralPrivacyFlag_00001() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null);

        assertNull(genericAccessService.setPeripheralPrivacyFlag(new PeripheralPrivacyFlag(new byte[]{0})));
    }

    @Test
    public void test_setPeripheralPrivacyFlag_00002() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setPeripheralPrivacyFlag(new PeripheralPrivacyFlag(new byte[]{0})));
    }

    @Test
    public void test_setPeripheralPrivacyFlag_00003() {
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isPeripheralPrivacyFlagCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(genericAccessService.setPeripheralPrivacyFlag(new PeripheralPrivacyFlag(new byte[]{0})));
    }

    @Test
    public void test_setPeripheralPrivacyFlag_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        GenericAccessService genericAccessService = new GenericAccessService(MOCK_BLE_CONNECTION, new MockGenericAccessServiceCallback(), null) {

            @Override
            public boolean isPeripheralPrivacyFlagCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = genericAccessService.setPeripheralPrivacyFlag(new PeripheralPrivacyFlag(new byte[]{0}));
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
