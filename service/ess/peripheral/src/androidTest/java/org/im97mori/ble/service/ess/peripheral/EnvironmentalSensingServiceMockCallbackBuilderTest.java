package org.im97mori.ble.service.ess.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a2c.MagneticDeclination;
import org.im97mori.ble.characteristic.u2a6c.Elevation;
import org.im97mori.ble.characteristic.u2a6d.Pressure;
import org.im97mori.ble.characteristic.u2a6e.Temperature;
import org.im97mori.ble.characteristic.u2a6f.Humidity;
import org.im97mori.ble.characteristic.u2a70.TrueWindSpeed;
import org.im97mori.ble.characteristic.u2a71.TrueWindDirection;
import org.im97mori.ble.characteristic.u2a72.ApparentWindSpeed;
import org.im97mori.ble.characteristic.u2a73.ApparentWindDirection;
import org.im97mori.ble.characteristic.u2a74.GustFactor;
import org.im97mori.ble.characteristic.u2a75.PollenConcentration;
import org.im97mori.ble.characteristic.u2a76.UVIndex;
import org.im97mori.ble.characteristic.u2a77.Irradiance;
import org.im97mori.ble.characteristic.u2a78.Rainfall;
import org.im97mori.ble.characteristic.u2a79.WindChill;
import org.im97mori.ble.characteristic.u2a7a.HeatIndex;
import org.im97mori.ble.characteristic.u2a7b.DewPoint;
import org.im97mori.ble.characteristic.u2aa0.MagneticFluxDensity2D;
import org.im97mori.ble.characteristic.u2aa1.MagneticFluxDensity3D;
import org.im97mori.ble.characteristic.u2aa3.BarometricPressureTrend;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.test.peripheral.MockBLEServerConnection;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

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
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class EnvironmentalSensingServiceMockCallbackBuilderTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00101() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00102() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDescriptorValueChanged(BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00201() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00202() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00203() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00204() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00205() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00206() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00207() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00208() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00209() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00210() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00211() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00213() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00212() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00214() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00215() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00216() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00217() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00218() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00219() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00220() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00221() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00222() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, new ApparentWindDirection(1))
                    .setApparentWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00223() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(1).getBytes())
                    .addApparentWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + APPARENT_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00224() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(1).getBytes())
                    .setApparentWindDirectionEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addApparentWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(2).getBytes())
                    .setApparentWindDirectionEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00301() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00302() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setDewPointEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00303() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00304() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00305() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00306() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00307() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00308() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00309() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00310() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00311() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00313() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00312() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00314() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00315() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00316() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00317() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00318() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00319() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00320() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00321() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00322() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, new ApparentWindSpeed(1))
                    .setApparentWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setApparentWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00323() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(1).getBytes())
                    .addApparentWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + APPARENT_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00324() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addApparentWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindSpeed(1).getBytes())
                    .setApparentWindSpeedEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addApparentWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindSpeed(2).getBytes())
                    .setApparentWindSpeedEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00401() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00402() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00403() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00404() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00405() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00406() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00407() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00408() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00409() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00410() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00411() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00413() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00412() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00414() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00415() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00416() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00417() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setDewPointEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00418() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00419() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00420() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00421() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00422() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, new DewPoint(1))
                    .setDewPointEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setDewPointEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00423() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(1).getBytes())
                    .addDewPoint(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + DEW_POINT_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00424() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addDewPoint(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(1).getBytes())
                    .setDewPointEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addDewPoint(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(2).getBytes())
                    .setDewPointEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00501() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00502() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00503() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00504() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00505() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00506() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00507() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00508() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00509() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00510() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00511() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00513() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00512() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00514() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00515() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00516() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00517() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setElevationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00518() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00519() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00520() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00521() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00522() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, new Elevation(1))
                    .setElevationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setElevationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00523() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(1).getBytes())
                    .addElevation(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + ELEVATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00524() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addElevation(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(1).getBytes())
                    .setElevationEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addElevation(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(2).getBytes())
                    .setElevationEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00601() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00602() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00603() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00604() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00605() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00606() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00607() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00608() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00609() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00610() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00611() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00613() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00612() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00614() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00615() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00616() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00617() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setGustFactorEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00618() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00619() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00620() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00621() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00622() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, new GustFactor(1))
                    .setGustFactorEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setGustFactorEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00623() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(1).getBytes())
                    .addGustFactor(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + GUST_FACTOR_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00624() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addGustFactor(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(1).getBytes())
                    .setGustFactorEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addGustFactor(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(2).getBytes())
                    .setGustFactorEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00701() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00702() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00703() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00704() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00705() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00706() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00707() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00708() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00709() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00710() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00711() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00713() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00712() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00714() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00715() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00716() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00717() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setHeatIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00718() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00719() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00720() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00721() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00722() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, new HeatIndex(1))
                    .setHeatIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHeatIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00723() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(1).getBytes())
                    .addHeatIndex(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + HEAT_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00724() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHeatIndex(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(1).getBytes())
                    .setHeatIndexEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addHeatIndex(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(2).getBytes())
                    .setHeatIndexEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00801() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00802() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00803() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00804() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00805() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00806() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00807() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00808() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00809() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00810() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00811() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00813() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00812() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00814() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00815() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00816() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00817() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setHumidityEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00818() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00819() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00820() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00821() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00822() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, new Humidity(1))
                    .setHumidityEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setHumidityEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00823() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(1).getBytes())
                    .addHumidity(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00824() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(1).getBytes())
                    .setHumidityEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addHumidity(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(2).getBytes())
                    .setHumidityEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00901() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00902() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00903() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00904() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00905() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00906() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00907() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00908() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00909() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00910() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00911() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00913() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00912() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00914() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00915() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00916() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00917() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setRainfallEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00918() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00919() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00920() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00921() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_00922() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, new Rainfall(1))
                    .setRainfallEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setRainfallEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00923() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(1).getBytes())
                    .addRainfall(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + RAINFALL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_00924() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addRainfall(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(1).getBytes())
                    .setRainfallEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addRainfall(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(2).getBytes())
                    .setRainfallEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01001() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01002() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01003() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01004() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01005() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01006() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01007() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01008() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01009() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01010() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01011() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01013() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01012() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01014() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01015() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01016() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01017() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setPressureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01018() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01019() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01020() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01021() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01022() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, new Pressure(1))
                    .setPressureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPressureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01023() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(1).getBytes())
                    .addPressure(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + PRESSURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01024() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPressure(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(1).getBytes())
                    .setPressureEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addPressure(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(2).getBytes())
                    .setPressureEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01101() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01102() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01103() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01104() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01105() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01106() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01107() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01108() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01109() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01110() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01111() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01113() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01112() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01114() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01115() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01116() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01117() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setTemperatureEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01118() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01119() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01120() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01121() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01122() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, new Temperature(1))
                    .setTemperatureEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTemperatureEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01123() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(1).getBytes())
                    .addTemperature(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + TEMPERATURE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01124() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTemperature(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(1).getBytes())
                    .setTemperatureEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addTemperature(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(2).getBytes())
                    .setTemperatureEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01201() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01202() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01203() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01204() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01205() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01206() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01207() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01208() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01209() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01210() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01211() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01213() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01212() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01214() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01215() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01216() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01217() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01218() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01219() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01220() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01221() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01222() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, new TrueWindDirection(1))
                    .setTrueWindDirectionEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindDirectionEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01223() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(1).getBytes())
                    .addTrueWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + TRUE_WIND_DIRECTION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01224() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(1).getBytes())
                    .setTrueWindDirectionEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addTrueWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(2).getBytes())
                    .setTrueWindDirectionEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01301() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01302() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01303() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01304() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01305() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01306() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01307() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01308() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01309() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01310() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01311() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01313() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01312() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01314() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01315() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01316() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01317() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setTrueWindSpeedEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01318() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01319() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01320() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01321() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01322() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, new TrueWindSpeed(1))
                    .setTrueWindSpeedEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setTrueWindSpeedEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01323() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(1).getBytes())
                    .addTrueWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + TRUE_WIND_SPEED_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01324() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addTrueWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(1).getBytes())
                    .setTrueWindSpeedEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addTrueWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(2).getBytes())
                    .setTrueWindSpeedEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01401() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01402() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01403() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01404() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01405() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01406() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01407() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01408() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01409() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01410() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01411() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01413() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01412() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01414() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01415() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01416() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01417() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setUVIndexEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01418() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01419() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01420() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01421() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01422() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, new UVIndex(1))
                    .setUVIndexEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setUVIndexEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01423() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(1).getBytes())
                    .addUVIndex(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + UV_INDEX_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01424() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addUVIndex(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new UVIndex(1).getBytes())
                    .setUVIndexEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addUVIndex(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new UVIndex(2).getBytes())
                    .setUVIndexEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01501() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01502() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01503() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01504() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01505() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01506() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01507() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01508() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01509() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01510() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01511() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01513() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01512() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01514() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01515() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01516() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01517() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setWindChillEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01518() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01519() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01520() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01521() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01522() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, new WindChill(1))
                    .setWindChillEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setWindChillEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01523() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(1).getBytes())
                    .addWindChill(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + WIND_CHILL_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01524() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addWindChill(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(1).getBytes())
                    .setWindChillEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addWindChill(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(2).getBytes())
                    .setWindChillEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01601() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01602() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01603() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01604() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01605() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01606() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01607() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01608() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01609() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01610() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01611() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01613() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01612() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01614() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01615() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01616() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01617() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setBarometricPressureTrendEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01618() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01619() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01620() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01621() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01622() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, new BarometricPressureTrend(1))
                    .setBarometricPressureTrendEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setBarometricPressureTrendEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01623() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(1).getBytes())
                    .addBarometricPressureTrend(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01624() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addBarometricPressureTrend(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(1).getBytes())
                    .setBarometricPressureTrendEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addBarometricPressureTrend(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(2).getBytes())
                    .setBarometricPressureTrendEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01701() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01702() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01703() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01704() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01705() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01706() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01707() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01708() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01709() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01710() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01711() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01713() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01712() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01714() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01715() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01716() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01717() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticDeclinationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01718() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01719() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01720() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01721() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01722() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, new MagneticDeclination(1))
                    .setMagneticDeclinationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticDeclinationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01723() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(1).getBytes())
                    .addMagneticDeclination(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + MAGNETIC_DECLINATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01724() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticDeclination(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(1).getBytes())
                    .setMagneticDeclinationEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addMagneticDeclination(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(2).getBytes())
                    .setMagneticDeclinationEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01801() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01802() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01803() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01804() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01805() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01806() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01807() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01808() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01809() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01810() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01811() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01813() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01812() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01814() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01815() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01816() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01817() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity2DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01818() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01819() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01820() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01821() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01822() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, new MagneticFluxDensity2D(1, 2))
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity2DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01823() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(1, 11).getBytes())
                    .addMagneticFluxDensity2D(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(2, 22).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01824() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity2D(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(1, 11).getBytes())
                    .setMagneticFluxDensity2DEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addMagneticFluxDensity2D(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(2, 22).getBytes())
                    .setMagneticFluxDensity2DEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01901() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01902() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01903() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01904() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01905() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01906() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01907() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setApparentWindDirectionEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01908() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01909() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01910() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01911() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01913() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01912() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01914() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01915() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01916() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01917() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setMagneticFluxDensity3DEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01918() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01919() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01920() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01921() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_01922() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, new MagneticFluxDensity3D(1, 2, 3))
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setMagneticFluxDensity3DEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_01923() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(1, 11, 111).getBytes())
                    .addMagneticFluxDensity3D(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(2, 22, 222).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_01924() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addMagneticFluxDensity3D(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(1, 11, 111).getBytes())
                    .setMagneticFluxDensity3DEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addMagneticFluxDensity3D(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(2, 22, 222).getBytes())
                    .setMagneticFluxDensity3DEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_02001() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02002() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02003() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02004() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02005() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02006() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02007() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02008() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02009() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02010() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02011() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02013() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02012() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02014() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02015() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02016() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02017() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02018() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02019() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02020() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02021() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02022() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, new Irradiance(1))
                    .setIrradianceEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setIrradianceEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_02023() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(1).getBytes())
                    .addIrradiance(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + IRRADIANCE_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02024() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addIrradiance(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(1).getBytes())
                    .setIrradianceEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addIrradiance(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(2).getBytes())
                    .setIrradianceEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_02101() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02102() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02103() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(1, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02104() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02105() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 3, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02106() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02107() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setIrradianceEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02108() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsConfiguration(1, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02109() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02110() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02111() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02113() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 3, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Trigger Setting data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02112() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02114() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02115() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02116() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02117() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsTriggerSetting(0, 2, new EnvironmentalSensingTriggerSetting(0))
                    .setPollenConcentrationEsConfiguration(0, new EnvironmentalSensingConfiguration(2))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02118() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02119() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02120() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02121() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Descriptor Value Changed data", exception.getMessage());
    }

    @Test
    public void test_exception_02122() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, new PollenConcentration(1))
                    .setPollenConcentrationEsTriggerSetting(0, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 1, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsTriggerSetting(0, 2, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                    .setPollenConcentrationEsConfiguration(0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingConfiguration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_02123() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(1).getBytes())
                    .addPollenConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(2).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_exception_02124() {
        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(1).getBytes())
                    .setPollenConcentrationEsMeasurement(0, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .addPollenConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(2).getBytes())
                    .setPollenConcentrationEsMeasurement(1, 0, 0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0).getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addDescriptorValueChanged_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>().build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addDescriptorValueChanged_00002() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(descriptorValue))
                .build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertNull(bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addDescriptorValueChanged_00003() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addDescriptorValueChanged(0, 1, descriptorValue)
                .build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertNull(bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeDescriptorValueChanged_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(descriptorValue))
                .removeDescriptorValueChanged()
                .build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

}
