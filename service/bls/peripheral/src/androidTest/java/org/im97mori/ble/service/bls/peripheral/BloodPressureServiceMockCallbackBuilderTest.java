package org.im97mori.ble.service.bls.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.BLOOD_PRESSURE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.BLOOD_PRESSURE_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;
import org.im97mori.ble.characteristic.u2a35.BloodPressureMeasurement;
import org.im97mori.ble.characteristic.u2a36.IntermediateCuffPressure;
import org.im97mori.ble.characteristic.u2a49.BloodPressureFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BloodPressureServiceMockCallbackBuilderTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureMeasurement_00001() {
        Exception exception = null;
        try {
            new BloodPressureServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Blood Pressure Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureMeasurement_00002() {
        int icpFlags = 1;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        int icpYear = 10;
        int icpMonth = 11;
        int icpDay = 12;
        int icpHours = 13;
        int icpMinutes = 14;
        int icpSeconds = 15;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{16, 7}, 0);
        int icpUserId = 18;
        byte[] icpMeasurementStatus = new byte[]{19};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        Exception exception = null;
        try {
            new BloodPressureServiceMockCallback.Builder<>()
                    .addIntermediateCuffPressure(intermediateCuffPressure, icpclientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("no Blood Pressure Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureMeasurement_00003() {
        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        Exception exception = null;
        try {
            new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("no Blood Pressure Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureMeasurement_00101() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, clientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureMeasurement_00102() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        int icpFlags = 24;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{25, 26}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{27, 29}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{30, 31}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{32, 33}, 0);
        int icpYear = 34;
        int icpMonth = 35;
        int icpDay = 36;
        int icpHours = 37;
        int icpMinutes = 38;
        int icpSeconds = 39;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{40, 41}, 0);
        int icpUserId = 42;
        byte[] icpMeasurementStatus = new byte[]{43};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                    .addIntermediateCuffPressure(intermediateCuffPressure, icpclientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureMeasurement_00201() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureMeasurement_00202() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        int icpFlags = 24;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{25, 26}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{27, 29}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{30, 31}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{32, 33}, 0);
        int icpYear = 34;
        int icpMonth = 35;
        int icpDay = 36;
        int icpHours = 37;
        int icpMinutes = 38;
        int icpSeconds = 39;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{40, 41}, 0);
        int icpUserId = 42;
        byte[] icpMeasurementStatus = new byte[]{43};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, bpmclientCharacteristicConfiguration.getBytes())
                    .addIntermediateCuffPressure(BluetoothGatt.GATT_SUCCESS, 0, intermediateCuffPressure.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, icpclientCharacteristicConfiguration.getBytes())
                    .addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBloodPressureMeasurement_00001() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        Exception exception = null;
        try {
            new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                    .removeBloodPressureMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Blood Pressure Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIntermediateCuffPressure_00001() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        Exception exception = null;
        try {
            new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIntermediateCuffPressure_00101() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, clientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIntermediateCuffPressure_00102() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        int icpFlags = 24;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{25, 26}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{27, 29}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{30, 31}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{32, 33}, 0);
        int icpYear = 34;
        int icpMonth = 35;
        int icpDay = 36;
        int icpHours = 37;
        int icpMinutes = 38;
        int icpSeconds = 39;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{40, 41}, 0);
        int icpUserId = 42;
        byte[] icpMeasurementStatus = new byte[]{43};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                    .addIntermediateCuffPressure(intermediateCuffPressure, icpclientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIntermediateCuffPressure_00201() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIntermediateCuffPressure_00202() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        int icpFlags = 24;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{25, 26}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{27, 29}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{30, 31}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{32, 33}, 0);
        int icpYear = 34;
        int icpMonth = 35;
        int icpDay = 36;
        int icpHours = 37;
        int icpMinutes = 38;
        int icpSeconds = 39;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{40, 41}, 0);
        int icpUserId = 42;
        byte[] icpMeasurementStatus = new byte[]{43};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, bpmclientCharacteristicConfiguration.getBytes())
                    .addIntermediateCuffPressure(BluetoothGatt.GATT_SUCCESS, 0, intermediateCuffPressure.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, icpclientCharacteristicConfiguration.getBytes())
                    .addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeIntermediateCuffPressure_00001() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        int icpFlags = 24;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{25, 26}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{27, 29}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{30, 31}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{32, 33}, 0);
        int icpYear = 34;
        int icpMonth = 35;
        int icpDay = 36;
        int icpHours = 37;
        int icpMinutes = 38;
        int icpSeconds = 39;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{40, 41}, 0);
        int icpUserId = 42;
        byte[] icpMeasurementStatus = new byte[]{43};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, bpmclientCharacteristicConfiguration.getBytes())
                    .addIntermediateCuffPressure(BluetoothGatt.GATT_SUCCESS, 0, intermediateCuffPressure.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, icpclientCharacteristicConfiguration.getBytes())
                    .addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes())
                    .removeIntermediateCuffPressure()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureFeature_00001() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Blood Pressure Feature data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureFeature_00101() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, clientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureFeature_00102() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        int icpFlags = 24;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{25, 26}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{27, 29}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{30, 31}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{32, 33}, 0);
        int icpYear = 34;
        int icpMonth = 35;
        int icpDay = 36;
        int icpHours = 37;
        int icpMinutes = 38;
        int icpSeconds = 39;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{40, 41}, 0);
        int icpUserId = 42;
        byte[] icpMeasurementStatus = new byte[]{43};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                    .addIntermediateCuffPressure(intermediateCuffPressure, icpclientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureFeature_00201() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBloodPressureFeature_00202() {
        int bpmFlags = 1;
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int bpmYear = 14;
        int bpmMonth = 15;
        int bpmDay = 16;
        int bpmHours = 17;
        int bpmMinutes = 18;
        int bpmSeconds = 19;
        IEEE_11073_20601_SFLOAT bpmPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int bpmUserId = 22;
        byte[] bpmMeasurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(bpmFlags, bpmBloodPressureMeasurementCompoundValueSystolicMmhg, bpmBloodPressureMeasurementCompoundValueDiastolicMmhg, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bpmBloodPressureMeasurementCompoundValueSystolicKpa, bpmBloodPressureMeasurementCompoundValueDiastolicKpa, bpmBloodPressureMeasurementCompoundValueMeanArterialPressureKpa, bpmYear, bpmMonth, bpmDay, bpmHours, bpmMinutes, bpmSeconds, bpmPulseRate, bpmUserId, bpmMeasurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        int icpFlags = 24;
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{25, 26}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueCurrentCuffPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{27, 29}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueDiastolicUnused = new IEEE_11073_20601_SFLOAT(new byte[]{30, 31}, 0);
        IEEE_11073_20601_SFLOAT intermediateCuffPressureCompoundValueMeanArterialPressureUnused = new IEEE_11073_20601_SFLOAT(new byte[]{32, 33}, 0);
        int icpYear = 34;
        int icpMonth = 35;
        int icpDay = 36;
        int icpHours = 37;
        int icpMinutes = 38;
        int icpSeconds = 39;
        IEEE_11073_20601_SFLOAT icpPulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{40, 41}, 0);
        int icpUserId = 42;
        byte[] icpMeasurementStatus = new byte[]{43};
        IntermediateCuffPressure intermediateCuffPressure = new IntermediateCuffPressure(icpFlags
                , intermediateCuffPressureCompoundValueCurrentCuffPressureMmhg
                , intermediateCuffPressureCompoundValueCurrentCuffPressureKpa
                , intermediateCuffPressureCompoundValueDiastolicUnused
                , intermediateCuffPressureCompoundValueMeanArterialPressureUnused
                , icpYear, icpMonth, icpDay, icpHours, icpMinutes, icpSeconds, icpPulseRate, icpUserId, icpMeasurementStatus);

        byte[] icpDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration icpclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(icpDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BloodPressureServiceMockCallback callback = new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, bpmclientCharacteristicConfiguration.getBytes())
                    .addIntermediateCuffPressure(BluetoothGatt.GATT_SUCCESS, 0, intermediateCuffPressure.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, icpclientCharacteristicConfiguration.getBytes())
                    .addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BLOOD_PRESSURE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBloodPressureFeature_00001() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(new byte[]{12, 13}, 0);
        int year = 14;
        int month = 15;
        int day = 16;
        int hours = 17;
        int minutes = 18;
        int seconds = 19;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{20, 21}, 0);
        int userId = 22;
        byte[] measurementStatus = new byte[]{23};
        BloodPressureMeasurement bloodPressureMeasurement = new BloodPressureMeasurement(flags, bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg, bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg, bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa, bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, year, month, day, hours, minutes, seconds, pulseRate, userId, measurementStatus);

        byte[] bpmDescriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration bpmclientCharacteristicConfiguration = new ClientCharacteristicConfiguration(bpmDescriptorValue);

        boolean isBodyMovementDetectionFeatureSupported = false;
        boolean isCuffFitDetectionSupported = false;
        boolean isIrregularPulseDetectionSupported = false;
        boolean isPulseRateRangeDetectionSupported = false;
        boolean isMeasurementPositionDetectionSupported = false;
        boolean isMultipleBondDetectionSupported = false;
        boolean isE2eCrcSupported = false;
        boolean isUserDataServiceSupported = false;
        boolean isUserFacingTimeSupported = false;
        BloodPressureFeature bloodPressureFeature = new BloodPressureFeature(isBodyMovementDetectionFeatureSupported, isCuffFitDetectionSupported, isIrregularPulseDetectionSupported, isPulseRateRangeDetectionSupported, isMeasurementPositionDetectionSupported, isMultipleBondDetectionSupported, isE2eCrcSupported, isUserDataServiceSupported, isUserFacingTimeSupported);

        Exception exception = null;
        try {
            new BloodPressureServiceMockCallback.Builder<>()
                    .addBloodPressureMeasurement(bloodPressureMeasurement, bpmclientCharacteristicConfiguration)
                    .addBloodPressureFeature(bloodPressureFeature)
                    .removeBloodPressureFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Blood Pressure Feature data", exception.getMessage());
    }

}
