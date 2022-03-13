package org.im97mori.ble.service.rscs.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a53.RSCMeasurement;
import org.im97mori.ble.characteristic.u2a54.RSCFeature;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.RSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class RunningSpeedAndCadenceServiceMockCallbackBuilderTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RSC Feature data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RSC Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00004() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_TRUE
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
        assertEquals("Instantaneous Stride Length Measurement not Supported", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00005() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
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
        assertEquals("Total Distance Measurement not Supported", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00006() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_RUNNING
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
        assertEquals("Walking or Running Status not Supported", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00007() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_INSTANTANEOUS_STRIDE_LENGTH_MEASUREMENT_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_INSTANTANEOUS_STRIDE_LENGTH_MEASUREMENT_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00008() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
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
        assertEquals("no SC Control Point data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00009() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_WALKING_OR_RUNNING_STATUS_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_WALKING_OR_RUNNING_STATUS_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_RUNNING
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00010() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_CALIBRATION_PROCEDURE_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_CALIBRATION_PROCEDURE_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(0
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
        assertEquals("no SC Control Point data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00011() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(0
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
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00012() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(0
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
        assertEquals("no SC Control Point data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00013() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER}
                    )
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00014() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_CALIBRATION_PROCEDURE_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_CALIBRATION_PROCEDURE_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER}
                    )
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00015() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER}
                    )
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00016() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_INSTANTANEOUS_STRIDE_LENGTH_MEASUREMENT_SUPPORTED_TRUE
                            | RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE
                            | RSCFeature.RSC_FEATURE_WALKING_OR_RUNNING_STATUS_SUPPORTED_TRUE
                            | RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , (RSCFeature.RSC_FEATURE_INSTANTANEOUS_STRIDE_LENGTH_MEASUREMENT_SUPPORTED_TRUE
                            | RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE
                            | RSCFeature.RSC_FEATURE_WALKING_OR_RUNNING_STATUS_SUPPORTED_TRUE
                            | RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE) >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(RSCMeasurement.FLAGS_INSTANTANEOUS_STRIDE_LENGTH_PRESENT_TRUE
                                    | RSCMeasurement.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                                    | RSCMeasurement.FLAGS_WALKING_OR_RUNNING_STATUS_BITS_RUNNING
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addRSCFeature_00001() {
        RSCFeature rscFeature = new RSCFeature(new byte[2]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(rscFeature)
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RSC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RSC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rscFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addRSCFeature_00002() {
        RSCFeature rscFeature = new RSCFeature(new byte[2]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(rscFeature.getBytes())
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RSC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RSC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rscFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addRSCFeature_00003() {
        RSCFeature rscFeature = new RSCFeature(new byte[2]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , rscFeature.getBytes())
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RSC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RSC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rscFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeRSCFeature_00001() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeRSCFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RSC Feature data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addRSCMeasurement_00001() {
        RSCMeasurement rscMeasurement = new RSCMeasurement(
                0
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
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(rscMeasurement
                            , clientCharacteristicConfiguration)
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RSC_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RSC_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rscMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addRSCMeasurement_00002() {
        RSCMeasurement rscMeasurement = new RSCMeasurement(
                0
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
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , rscMeasurement.getBytes()
                            , 1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RSC_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(RSC_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rscMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeRSCMeasurement_00001() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeRSCMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no RSC Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSensorLocation_00001() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(sensorLocation)
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSensorLocation_00002() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(sensorLocation.getBytes())
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSensorLocation_00003() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , sensorLocation.getBytes())
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeSensorLocation_00001() {
        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE, RSCFeature.RSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeSensorLocation()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Sensor Location data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSCControlPoint_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            RunningSpeedAndCadenceServiceMockCallback callback = new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[2]))
                    .addRSCMeasurement(new RSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , descriptorValue
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SC_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_RESPONSE_CODE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeSCControlPoint_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        Exception exception = null;
        try {
            new RunningSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addRSCFeature(new RSCFeature(new byte[]{RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE, RSCFeature.RSC_FEATURE_TOTAL_DISTANCE_MEASUREMENT_SUPPORTED_TRUE >> 8}))
                    .addRSCMeasurement(new RSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , descriptorValue
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeSCControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no SC Control Point data", exception.getMessage());
    }

}
