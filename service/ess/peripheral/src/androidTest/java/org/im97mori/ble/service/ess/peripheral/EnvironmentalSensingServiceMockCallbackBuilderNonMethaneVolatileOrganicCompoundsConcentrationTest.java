package org.im97mori.ble.service.ess.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;
import org.im97mori.ble.characteristic.u2bd3.NonMethaneVolatileOrganicCompoundsConcentration;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class EnvironmentalSensingServiceMockCallbackBuilderNonMethaneVolatileOrganicCompoundsConcentrationTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addNonMethaneVolatileOrganicCompoundsConcentration_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>().build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addNonMethaneVolatileOrganicCompoundsConcentration_00002() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addNonMethaneVolatileOrganicCompoundsConcentration_00003() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(originalProperties, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addNonMethaneVolatileOrganicCompoundsConcentration_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(originalProperties0, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex1);
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentration_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .removeNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentration_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .removeNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(1, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingMeasurement environmentalSensingMeasurement = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex, environmentalSensingMeasurement)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(1, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingMeasurement environmentalSensingMeasurement0 = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        EnvironmentalSensingMeasurement environmentalSensingMeasurement1 = new EnvironmentalSensingMeasurement(new byte[2], 1, 1, 1, 1, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, environmentalSensingMeasurement0)
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, environmentalSensingMeasurement1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(originalProperties0, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex1);
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingMeasurement environmentalSensingMeasurement = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex, environmentalSensingMeasurement)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(1, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingMeasurement environmentalSensingMeasurement0 = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        EnvironmentalSensingMeasurement environmentalSensingMeasurement1 = new EnvironmentalSensingMeasurement(new byte[2], 1, 1, 1, 1, 1);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, environmentalSensingMeasurement0)
                    .removeNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0)
                    .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, environmentalSensingMeasurement1)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00002() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00003() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00004() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 3;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00101() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(3);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00102() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00103() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00104() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(0);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(4, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(2);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00002() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00003() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00004() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex = 3;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00101() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(3);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00102() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00103() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting_00104() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(0);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, 0, environmentalSensingTriggerSetting0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, 1, environmentalSensingTriggerSetting1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, environmentalSensingConfiguration)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration_00002() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        int descriptorPermission = BluetoothGattDescriptor.PERMISSION_READ;
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, 0, environmentalSensingTriggerSetting0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, 1, environmentalSensingTriggerSetting1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes())
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration_00101() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, originalValue0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex0, environmentalSensingConfiguration0)
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, originalValue1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex1, environmentalSensingConfiguration1)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration_00102() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        int descriptorPermission = BluetoothGattDescriptor.PERMISSION_READ;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, originalValue0)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex0, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration0.getBytes())
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, originalValue1)
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex1, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration1.getBytes())
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, originalValue)
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex, environmentalSensingConfiguration)
                    .removeNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex)
                    .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration_00101() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, originalValue0)
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex0, environmentalSensingConfiguration0)
                    .removeNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0)
                    .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, originalValue1)
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                    .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(characteristicIndex1, environmentalSensingConfiguration1)
                    .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex, characteristicUserDescription)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00002() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00101() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex0, characteristicUserDescription0)
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex1, characteristicUserDescription1)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00102() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex0, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription0.getBytes())
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex1, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription1.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex, characteristicUserDescription)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription_00101() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex0, characteristicUserDescription0)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex0)
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex1, characteristicUserDescription1)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(characteristicIndex1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex, validRange)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00002() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00101() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex0, validRange0)
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex1, validRange1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00102() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex0, BluetoothGatt.GATT_SUCCESS, 0, validRange0.getBytes())
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex1, BluetoothGatt.GATT_SUCCESS, 0, validRange1.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00001() {
        int characteristicIndex = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex, validRange)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeNonMethaneVolatileOrganicCompoundsConcentrationValidRange_00101() {
        int characteristicIndex0 = 0;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue0 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(1));
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        NonMethaneVolatileOrganicCompoundsConcentration originalValue1 = new NonMethaneVolatileOrganicCompoundsConcentration(new IEEE_11073_20601_SFLOAT(2));
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex0, validRange0)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex0)
                .addNonMethaneVolatileOrganicCompoundsConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex1, validRange1)
                .removeNonMethaneVolatileOrganicCompoundsConcentrationValidRange(characteristicIndex1)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

}
