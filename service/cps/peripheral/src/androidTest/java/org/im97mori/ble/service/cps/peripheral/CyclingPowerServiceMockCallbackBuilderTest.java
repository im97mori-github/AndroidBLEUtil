package org.im97mori.ble.service.cps.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.characteristic.u2a63.CyclingPowerMeasurement;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVector;
import org.im97mori.ble.characteristic.u2a65.CyclingPowerFeature;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CYCLING_POWER_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CyclingPowerServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Feature data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Measurement data", exception.getMessage());
    }

    @Test
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE, CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_TRUE >> 8}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Pedal Power Balance not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00004() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE, CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_TRUE >> 8}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Accumulated Torque not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00005() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE, CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE >> 8}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Wheel Revolution Data not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00006() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE, CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE >> 8}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Crank Revolution Data not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00007() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE, CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_TRUE >> 8}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Extreme Magnitudes not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00008() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{(byte) CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE, (byte) (CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Extreme Magnitudes not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00009() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{(byte) CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_TRUE, (byte) (CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Extreme Angles not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00010() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{(byte) CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE, (byte) (CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Top and Bottom Dead Spot Angles not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00011() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{(byte) CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE, (byte) (CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Top and Bottom Dead Spot Angles not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00012() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{(byte) CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE, (byte) (CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Accumulated Energy not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00013() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[]{(byte) CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_TRUE, (byte) (CyclingPowerMeasurement.FLAGS_OFFSET_COMPENSATION_INDICATION_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Offset Compensation Indicator not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00014() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Sensor Location data", exception.getMessage());
    }

    @Test
    public void test_exception_00015() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{
                            (byte) CyclingPowerFeature.CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE >> 8)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE >> 16)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE >> 24)
                    }))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00016() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{
                            (byte) CyclingPowerFeature.CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 16)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 24)
                    }))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00017() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{
                            (byte) CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE >> 8)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE >> 16)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_CRANK_LENGTH_ADJUSTMENT_SUPPORTED_TRUE >> 24)
                    }))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00018() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{
                            (byte) CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE >> 8)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE >> 16)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_OFFSET_COMPENSATION_SUPPORTED_TRUE >> 24)
                    }))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00019() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerVector(new CyclingPowerVector(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00020() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{
                            (byte) CyclingPowerFeature.CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE >> 8)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE >> 16)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_FACTORY_CALIBRATION_DATE_SUPPORTED_TRUE >> 24)
                    }))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00021() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{
                            (byte) CyclingPowerFeature.CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE >> 8)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE >> 16)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_ENHANCED_OFFSET_COMPENSATION_SUPPORTED_TRUE >> 24)
                    }))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00022() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Crank Revolution Data not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00023() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Extreme Angles not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00024() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[]{
                            (byte) CyclingPowerFeature.CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED >> 8)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED >> 16)
                            , (byte) (CyclingPowerFeature.CYCLING_POWER_FEATURE_SENSOR_MEASUREMENT_CONTEXT_TORQUE_BASED >> 24)
                    }))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , new int[9]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Sensor Measurement Context Torque based", exception.getMessage());
    }

    @Test
    public void test_exception_00025() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[9])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Sensor Measurement Context Force based", exception.getMessage());
    }

    @Test
    public void test_exception_00026() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_TANGENTIAL_COMPONENT
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Instantaneous Measurement Direction not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00027() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_RADIAL_COMPONENT
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Instantaneous Measurement Direction not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00028() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_LATERAL_COMPONENT
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Instantaneous Measurement Direction not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00029() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addCyclingPowerFeature_00001() {
        CyclingPowerFeature cyclingPowerFeature = new CyclingPowerFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(cyclingPowerFeature)
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cyclingPowerFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addCyclingPowerFeature_00002() {
        CyclingPowerFeature cyclingPowerFeature = new CyclingPowerFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(cyclingPowerFeature.getBytes())
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cyclingPowerFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addCyclingPowerFeature_00003() {
        CyclingPowerFeature cyclingPowerFeature = new CyclingPowerFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(BluetoothGatt.GATT_SUCCESS, 0, cyclingPowerFeature.getBytes())
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cyclingPowerFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeCyclingPowerFeature_00001() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeCyclingPowerFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Feature data", exception.getMessage());
    }

    @Test
    public void test_addCyclingPowerMeasurement_00001() {
        CyclingPowerMeasurement cyclingPowerMeasurement = new CyclingPowerMeasurement(
                new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(cyclingPowerMeasurement
                            , new ClientCharacteristicConfiguration(descriptorValue))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cyclingPowerMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addCyclingPowerMeasurement_00002() {
        CyclingPowerMeasurement cyclingPowerMeasurement = new CyclingPowerMeasurement(
                new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , cyclingPowerMeasurement.getBytes()
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , descriptorValue)
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cyclingPowerMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeCyclingPowerMeasurement_00001() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeCyclingPowerMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Measurement data", exception.getMessage());
    }

    @Test
    public void test_addSensorLocation_00001() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(sensorLocation)
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSensorLocation_00002() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(sensorLocation.getBytes())
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSensorLocation_00003() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(BluetoothGatt.GATT_SUCCESS, 0, sensorLocation.getBytes())
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSensorLocation_00001() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeSensorLocation()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Sensor Location data", exception.getMessage());
    }

    @Test
    public void test_addCyclingPowerControlPoint_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(descriptorValue))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , descriptorValue
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeCyclingPowerControlPoint_00001() {
        Exception exception = null;
        try {
            new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeCyclingPowerControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Cycling Power Control Point data", exception.getMessage());
    }

    @Test
    public void test_addCyclingPowerVector_00001() {
        CyclingPowerVector cyclingPowerVector = new CyclingPowerVector(0
                , 0
                , 0
                , 0
                , new int[0]
                , new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(cyclingPowerVector
                            , clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_VECTOR_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cyclingPowerVector.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addCyclingPowerVector_00002() {
        CyclingPowerVector cyclingPowerVector = new CyclingPowerVector(0
                , 0
                , 0
                , 0
                , new int[0]
                , new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , cyclingPowerVector.getBytes()
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , descriptorValue)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CYCLING_POWER_VECTOR_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cyclingPowerVector.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeCyclingPowerVector_00001() {

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingPowerServiceMockCallback callback = new CyclingPowerServiceMockCallback.Builder<>()
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(
                                    new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addCyclingPowerControlPoint(
                            BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                    )
                    .addCyclingPowerVector(new CyclingPowerVector(0
                                    , 0
                                    , 0
                                    , 0
                                    , new int[0]
                                    , new int[0])
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeCyclingPowerVector()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_POWER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

}
