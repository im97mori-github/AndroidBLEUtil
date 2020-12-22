package org.im97mori.ble.profile.cscp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a5b.CSCMeasurement;
import org.im97mori.ble.characteristic.u2a5c.CSCFeature;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CyclingSpeedAndCadenceProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(cyclingSpeedAndCadenceServiceMockCallbackBuilder, baseBuilder.mCyclingSpeedAndCadenceServiceMockCallback);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
    }

    @Test
    public void test_addCSCFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CSCFeature cscFeature = new CSCFeature(new byte[1]);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addCSCFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(cscFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addCSCFeature(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCSCFeature(cscFeature));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCSCFeature_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CSCFeature cscFeature = new CSCFeature(new byte[1]);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addCSCFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(cscFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addCSCFeature(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCSCFeature(cscFeature));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCSCFeature_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final CSCFeature cscFeature = new CSCFeature(new byte[1]);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addCSCFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(cscFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addCSCFeature(responseCode, delay, value);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCSCFeature(originalResponseCode, originalDelay, cscFeature.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCSCFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> removeCSCFeature() {
                atomicBoolean.set(true);
                return super.removeCSCFeature();
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCSCFeature());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCSCMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CSCMeasurement cscMeasurement = new CSCMeasurement(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addCSCMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(cscMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addCSCMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCSCMeasurement(cscMeasurement, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCSCMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalNotificationCount = 40;
        final int originalDescriptorResponseCode = 41;
        final long originalDescriptorDelay = 42;
        final CSCMeasurement cscMeasurement = new CSCMeasurement(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addCSCMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(cscMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addCSCMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCSCMeasurement(originalCharacteristicResponseCode, originalCharacteristicDelay, cscMeasurement.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCSCMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> removeCSCMeasurement() {
                atomicBoolean.set(true);
                return super.removeCSCMeasurement();
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCSCMeasurement());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSensorLocation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(sensorLocation.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSensorLocation(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSensorLocation(sensorLocation));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSensorLocation_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(sensorLocation.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSensorLocation(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSensorLocation(sensorLocation.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSensorLocation_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(sensorLocation.getBytes(), value);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                atomicBoolean.set(true);
                return super.addSensorLocation(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSensorLocation(originalResponseCode, originalDelay, sensorLocation.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSensorLocation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> removeSensorLocation() {
                atomicBoolean.set(true);
                return super.removeSensorLocation();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSensorLocation());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSCControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalDescriptorResponseCode = 3;
        final long originalDescriptorDelay = 4;
        final byte[] originalDescriptorValue = new byte[]{5};
        final int originalSetCumulativeValueResponseValue = 6;
        final int originalUpdateSensorLocationResponseValue = 7;
        final int originalRequestSupportedSensorLocationsResponseValue = 8;
        final byte[] originalRequestSupportedSensorLocationsResponseParameter = new byte[]{9};
        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {


            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> addSCControlPoint(int characteristicResponseCode
                    , long characteristicDelay
                    , int descriptorResponseCode
                    , long descriptorDelay
                    , @NonNull byte[] descriptorValue
                    , int setCumulativeValueResponseValue
                    , int updateSensorLocationResponseValue
                    , int requestSupportedSensorLocationsResponseValue
                    , @NonNull byte[] requestSupportedSensorLocationsResponseParameter) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                assertEquals(originalSetCumulativeValueResponseValue, setCumulativeValueResponseValue);
                assertEquals(originalUpdateSensorLocationResponseValue, updateSensorLocationResponseValue);
                assertEquals(originalRequestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseValue);
                assertArrayEquals(originalRequestSupportedSensorLocationsResponseParameter, requestSupportedSensorLocationsResponseParameter);
                atomicBoolean.set(true);
                return super.addSCControlPoint(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, setCumulativeValueResponseValue, updateSensorLocationResponseValue, requestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseParameter);
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSCControlPoint(originalCharacteristicResponseCode
                , originalCharacteristicDelay
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , originalDescriptorValue
                , originalSetCumulativeValueResponseValue
                , originalUpdateSensorLocationResponseValue
                , originalRequestSupportedSensorLocationsResponseValue
                , originalRequestSupportedSensorLocationsResponseParameter));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSCControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> removeSCControlPoint() {
                atomicBoolean.set(true);
                return super.removeSCControlPoint();
            }

        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSCControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";
        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(manufacturerName);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeManufacturerNameString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumber));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";
        ModelNumberString modelNumberString = new ModelNumberString(modelNumber);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumberString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeModelNumberString() {
                atomicBoolean.set(true);
                return super.removeModelNumberString();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeModelNumberString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeModelNumberString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        CyclingSpeedAndCadenceServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingSpeedAndCadenceServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.removeModelNumberString());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00101() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString("")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00102() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString(new ManufacturerNameString(""))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00103() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString(new ManufacturerNameString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00104() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString(0, 0, new ManufacturerNameString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00201() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString("")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00202() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString(new ManufacturerNameString(""))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00203() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString(new ManufacturerNameString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00204() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString(0, 0, new ManufacturerNameString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00301() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addModelNumberString("")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00302() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addModelNumberString(new ModelNumberString(""))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00303() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addModelNumberString(new ModelNumberString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00304() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00401() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addModelNumberString("")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00402() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addModelNumberString(new ModelNumberString(""))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00403() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addModelNumberString(new ModelNumberString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00404() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addModelNumberString(0, 0, new ModelNumberString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00501() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>())
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addManufacturerNameString(0, 0, new ManufacturerNameString("").getBytes())
                    .addModelNumberString(0, 0, new ModelNumberString("").getBytes())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00502() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingSpeedAndCadenceServiceMockCallback.Builder<>(), null)
                    .addCSCFeature(new CSCFeature(new byte[1]))
                    .addCSCMeasurement(new CSCMeasurement(new byte[1]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

}
