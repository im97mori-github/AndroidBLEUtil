package org.im97mori.ble.profile.cpp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.characteristic.u2a63.CyclingPowerMeasurement;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVector;
import org.im97mori.ble.characteristic.u2a65.CyclingPowerFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CyclingPowerProfileMockCallbackBuilderTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(cyclingPowerServiceMockCallbackBuilder, baseBuilder.mCyclingPowerServiceMockCallbackBuilder);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
        assertEquals(batteryServiceMockCallbackBuilder, baseBuilder.mBatteryServiceMockCallbackBuilder);
    }

    @Test
    public void test_addCyclingPowerFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CyclingPowerFeature cyclingPowerFeature = new CyclingPowerFeature(new byte[4]);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(cyclingPowerFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addCyclingPowerFeature(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerFeature(cyclingPowerFeature));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCyclingPowerFeature_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CyclingPowerFeature cyclingPowerFeature = new CyclingPowerFeature(new byte[4]);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(cyclingPowerFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addCyclingPowerFeature(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerFeature(cyclingPowerFeature.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCyclingPowerFeature_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final CyclingPowerFeature cyclingPowerFeature = new CyclingPowerFeature(new byte[4]);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(cyclingPowerFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addCyclingPowerFeature(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerFeature(originalResponseCode, originalDelay, cyclingPowerFeature.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCyclingPowerFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> removeCyclingPowerFeature() {
                atomicBoolean.set(true);
                return super.removeCyclingPowerFeature();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCyclingPowerFeature());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCyclingPowerMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CyclingPowerMeasurement cyclingPowerMeasurement = new CyclingPowerMeasurement(new byte[4]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(cyclingPowerMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addCyclingPowerMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerMeasurement(cyclingPowerMeasurement, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCyclingPowerMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalNotificationCount = 40;
        final int originalDescriptorResponseCode = 41;
        final long originalDescriptorDelay = 42;
        final CyclingPowerMeasurement cyclingPowerMeasurement = new CyclingPowerMeasurement(new byte[4]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(cyclingPowerMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addCyclingPowerMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerMeasurement(originalCharacteristicResponseCode, originalCharacteristicDelay, cyclingPowerMeasurement.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCyclingPowerMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> removeCyclingPowerMeasurement() {
                atomicBoolean.set(true);
                return super.removeCyclingPowerMeasurement();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCyclingPowerMeasurement());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSensorLocation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(sensorLocation.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSensorLocation(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSensorLocation(sensorLocation));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSensorLocation_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(sensorLocation.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSensorLocation(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(sensorLocation.getBytes(), value);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                atomicBoolean.set(true);
                return super.addSensorLocation(responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSensorLocation(originalResponseCode, originalDelay, sensorLocation.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSensorLocation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> removeSensorLocation() {
                atomicBoolean.set(true);
                return super.removeSensorLocation();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSensorLocation());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCyclingPowerControlPoint_00001() {
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
        final int originalSetCrankLengthResponseValue = 10;
        final int originalRequestCrankLengthResponseValue = 11;
        final byte[] originalRequestCrankLengthResponseParameter = new byte[]{12};
        final int originalSetChainLengthResponseValue = 13;
        final int originalRequestChainLengthResponseValue = 14;
        final byte[] originalRequestChainLengthResponseParameter = new byte[]{15};
        final int originalSetChainWeightResponseValue = 16;
        final int originalRequestChainWeightResponseValue = 17;
        final byte[] originalRequestChainWeightResponseParameter = new byte[]{18};
        final int originalSetSpanLengthResponseValue = 19;
        final int originalRequestSpanLengthResponseValue = 20;
        final byte[] originalRequestSpanLengthResponseParameter = new byte[]{21};
        final int originalStartOffsetCompensationResponseValue = 22;
        final byte[] originalStartOffsetCompensationResponseParameter = new byte[]{23};
        final int originalMaskCyclingPowerMeasurementCharacteristicContentResponseValue = 24;
        final int originalRequestSamplingRateResponseValue = 25;
        final byte[] originalRequestSamplingRateResponseParameter = new byte[]{26};
        final int originalRequestFactoryCalibrationDateResponseValue = 27;
        final byte[] originalRequestFactoryCalibrationDateResponseParameter = new byte[]{28};
        final int originalStartEnhancedOffsetCompensationResponseValue = 29;
        final byte[] originalStartEnhancedOffsetCompensationResponseParameter = new byte[]{30};

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {


            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerControlPoint(int characteristicResponseCode
                    , long characteristicDelay
                    , int descriptorResponseCode
                    , long descriptorDelay
                    , @NonNull byte[] descriptorValue
                    , int setCumulativeValueResponseValue
                    , int updateSensorLocationResponseValue
                    , int requestSupportedSensorLocationsResponseValue
                    , @NonNull byte[] requestSupportedSensorLocationsResponseParameter
                    , int setCrankLengthResponseValue
                    , int requestCrankLengthResponseValue
                    , @NonNull byte[] requestCrankLengthResponseParameter
                    , int setChainLengthResponseValue
                    , int requestChainLengthResponseValue
                    , @NonNull byte[] requestChainLengthResponseParameter
                    , int setChainWeightResponseValue
                    , int requestChainWeightResponseValue
                    , @NonNull byte[] requestChainWeightResponseParameter
                    , int setSpanLengthResponseValue
                    , int requestSpanLengthResponseValue
                    , @NonNull byte[] requestSpanLengthResponseParameter
                    , int startOffsetCompensationResponseValue
                    , @NonNull byte[] startOffsetCompensationResponseParameter
                    , int maskCyclingPowerMeasurementCharacteristicContentResponseValue
                    , int requestSamplingRateResponseValue
                    , @NonNull byte[] requestSamplingRateResponseParameter
                    , int requestFactoryCalibrationDateResponseValue
                    , @NonNull byte[] requestFactoryCalibrationDateResponseParameter
                    , int startEnhancedOffsetCompensationResponseValue
                    , @NonNull byte[] startEnhancedOffsetCompensationResponseParameter) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                assertEquals(originalSetCumulativeValueResponseValue, setCumulativeValueResponseValue);
                assertEquals(originalUpdateSensorLocationResponseValue, updateSensorLocationResponseValue);
                assertEquals(originalRequestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseValue);
                assertArrayEquals(originalRequestSupportedSensorLocationsResponseParameter, requestSupportedSensorLocationsResponseParameter);
                assertEquals(originalSetCrankLengthResponseValue, setCrankLengthResponseValue);
                assertEquals(originalRequestCrankLengthResponseValue, requestCrankLengthResponseValue);
                assertArrayEquals(originalRequestCrankLengthResponseParameter, requestCrankLengthResponseParameter);
                assertEquals(originalSetChainLengthResponseValue, setChainLengthResponseValue);
                assertEquals(originalRequestChainLengthResponseValue, requestChainLengthResponseValue);
                assertArrayEquals(originalRequestChainLengthResponseParameter, requestChainLengthResponseParameter);
                assertEquals(originalSetChainWeightResponseValue, setChainWeightResponseValue);
                assertEquals(originalRequestChainWeightResponseValue, requestChainWeightResponseValue);
                assertArrayEquals(originalRequestChainWeightResponseParameter, requestChainWeightResponseParameter);
                assertEquals(originalSetSpanLengthResponseValue, setSpanLengthResponseValue);
                assertEquals(originalRequestSpanLengthResponseValue, requestSpanLengthResponseValue);
                assertArrayEquals(originalRequestSpanLengthResponseParameter, requestSpanLengthResponseParameter);
                assertEquals(originalStartOffsetCompensationResponseValue, startOffsetCompensationResponseValue);
                assertArrayEquals(originalStartOffsetCompensationResponseParameter, startOffsetCompensationResponseParameter);
                assertEquals(originalMaskCyclingPowerMeasurementCharacteristicContentResponseValue, maskCyclingPowerMeasurementCharacteristicContentResponseValue);
                assertEquals(originalRequestSamplingRateResponseValue, requestSamplingRateResponseValue);
                assertArrayEquals(originalRequestSamplingRateResponseParameter, requestSamplingRateResponseParameter);
                assertEquals(originalRequestFactoryCalibrationDateResponseValue, requestFactoryCalibrationDateResponseValue);
                assertArrayEquals(originalRequestFactoryCalibrationDateResponseParameter, requestFactoryCalibrationDateResponseParameter);
                assertEquals(originalStartEnhancedOffsetCompensationResponseValue, startEnhancedOffsetCompensationResponseValue);
                assertArrayEquals(originalStartEnhancedOffsetCompensationResponseParameter, startEnhancedOffsetCompensationResponseParameter);
                atomicBoolean.set(true);
                return super.addCyclingPowerControlPoint(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, setCumulativeValueResponseValue, updateSensorLocationResponseValue, requestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseParameter, setCrankLengthResponseValue, requestCrankLengthResponseValue, requestCrankLengthResponseParameter, setChainLengthResponseValue, requestChainLengthResponseValue, requestChainLengthResponseParameter, setChainWeightResponseValue, requestChainWeightResponseValue, requestChainWeightResponseParameter, setSpanLengthResponseValue, requestSpanLengthResponseValue, requestSpanLengthResponseParameter, startOffsetCompensationResponseValue, startOffsetCompensationResponseParameter, maskCyclingPowerMeasurementCharacteristicContentResponseValue, requestSamplingRateResponseValue, requestSamplingRateResponseParameter, requestFactoryCalibrationDateResponseValue, requestFactoryCalibrationDateResponseParameter, startEnhancedOffsetCompensationResponseValue, startEnhancedOffsetCompensationResponseParameter);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerControlPoint(originalCharacteristicResponseCode
                , originalCharacteristicDelay
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , originalDescriptorValue
                , originalSetCumulativeValueResponseValue
                , originalUpdateSensorLocationResponseValue
                , originalRequestSupportedSensorLocationsResponseValue
                , originalRequestSupportedSensorLocationsResponseParameter
                , originalSetCrankLengthResponseValue
                , originalRequestCrankLengthResponseValue
                , originalRequestCrankLengthResponseParameter
                , originalSetChainLengthResponseValue
                , originalRequestChainLengthResponseValue
                , originalRequestChainLengthResponseParameter
                , originalSetChainWeightResponseValue
                , originalRequestChainWeightResponseValue
                , originalRequestChainWeightResponseParameter
                , originalSetSpanLengthResponseValue
                , originalRequestSpanLengthResponseValue
                , originalRequestSpanLengthResponseParameter
                , originalStartOffsetCompensationResponseValue
                , originalStartOffsetCompensationResponseParameter
                , originalMaskCyclingPowerMeasurementCharacteristicContentResponseValue
                , originalRequestSamplingRateResponseValue
                , originalRequestSamplingRateResponseParameter
                , originalRequestFactoryCalibrationDateResponseValue
                , originalRequestFactoryCalibrationDateResponseParameter
                , originalStartEnhancedOffsetCompensationResponseValue
                , originalStartEnhancedOffsetCompensationResponseParameter));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCyclingPowerControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> removeCyclingPowerControlPoint() {
                atomicBoolean.set(true);
                return super.removeSensorLocation();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCyclingPowerControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCyclingPowerVector_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CyclingPowerVector cyclingPowerVector = new CyclingPowerVector(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerVector(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(cyclingPowerVector.getBytes(), characteristicValue);
                assertArrayEquals(descriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addCyclingPowerVector(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerVector(cyclingPowerVector, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCyclingPowerVector_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalNotificationCount = 40;
        final int originalDescriptorResponseCode = 41;
        final long originalDescriptorDelay = 42;
        final CyclingPowerVector cyclingPowerVector = new CyclingPowerVector(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> addCyclingPowerVector(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(cyclingPowerVector.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addCyclingPowerVector(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCyclingPowerVector(originalCharacteristicResponseCode, originalCharacteristicDelay, cyclingPowerVector.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCyclingPowerVector_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback>() {

            @NonNull
            @Override
            public CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> removeCyclingPowerVector() {
                atomicBoolean.set(true);
                return super.removeCyclingPowerVector();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCyclingPowerVector());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";
        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(manufacturerName);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
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
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

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
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeManufacturerNameString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

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
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumber));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";
        ModelNumberString modelNumberString = new ModelNumberString(modelNumber);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumberString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
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
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

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
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeModelNumberString() {
                atomicBoolean.set(true);
                return super.removeModelNumberString();
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeModelNumberString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeModelNumberString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, null, batteryServiceMockCallbackBuilder);

        Exception exception = null;
        try {
            assertEquals(baseBuilder, baseBuilder.removeModelNumberString());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addBatteryLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final BatteryLevel batteryLevel = new BatteryLevel(1);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> addBatteryLevel(int index, int property, int responseCode, long delay, @NonNull byte[] value, int notificationCount) {
                assertEquals(originalIndex, index);
                assertArrayEquals(batteryLevel.getBytes(), value);
                atomicBoolean.set(true);
                return super.addBatteryLevel(index, property, responseCode, delay, value, notificationCount);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBatteryLevel(originalIndex, batteryLevel));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBatteryLevel_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final BatteryLevel batteryLevel = new BatteryLevel(4);
        final int originalNotificationCount = 5;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> addBatteryLevel(int index, int property, int responseCode, long delay, @NonNull byte[] value, int notificationCount) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(batteryLevel.getBytes(), value);
                assertEquals(originalNotificationCount, notificationCount);
                atomicBoolean.set(true);
                return super.addBatteryLevel(index, property, responseCode, delay, value, notificationCount);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBatteryLevel(originalIndex, originalProperty, originalResponseCode, originalDelay, batteryLevel.getBytes(), originalNotificationCount));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBatteryLevel_00101() {
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final BatteryLevel batteryLevel = new BatteryLevel(4);
        final int originalNotificationCount = 5;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.addBatteryLevel(originalIndex, originalProperty, originalResponseCode, originalDelay, batteryLevel.getBytes(), originalNotificationCount);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeBatteryLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> removeBatteryLevel(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeBatteryLevel(index);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevel(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevel_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.removeBatteryLevel(originalIndex);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_setBatteryLevelCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(new byte[]{1, 2, 3, 4, 5, 6, 7});

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(characteristicPresentationFormat.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelCharacteristicPresentationFormat(index, responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelCharacteristicPresentationFormat(originalIndex, characteristicPresentationFormat));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelCharacteristicPresentationFormat_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(new byte[]{3, 4, 5, 6, 7, 8, 9});

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(characteristicPresentationFormat.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelCharacteristicPresentationFormat(index, responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelCharacteristicPresentationFormat(originalIndex, originalResponseCode, originalDelay, characteristicPresentationFormat.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelCharacteristicPresentationFormat_00101() {
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(new byte[]{3, 4, 5, 6, 7, 8, 9});

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.setBatteryLevelCharacteristicPresentationFormat(originalIndex, originalResponseCode, originalDelay, characteristicPresentationFormat.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeBatteryLevelCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> removeBatteryLevelCharacteristicPresentationFormat(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeBatteryLevelCharacteristicPresentationFormat(index);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevelCharacteristicPresentationFormat(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevelCharacteristicPresentationFormat_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.removeBatteryLevelCharacteristicPresentationFormat(originalIndex);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_setBatteryLevelClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelClientCharacteristicConfiguration(index, responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelClientCharacteristicConfiguration(originalIndex, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelClientCharacteristicConfiguration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {


            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> setBatteryLevelClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), value);
                atomicBoolean.set(true);
                return super.setBatteryLevelClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setBatteryLevelClientCharacteristicConfiguration(originalIndex, originalResponseCode, originalDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setBatteryLevelClientCharacteristicConfiguration_00101() {
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.setBatteryLevelClientCharacteristicConfiguration(originalIndex, originalResponseCode, originalDelay, clientCharacteristicConfiguration.getBytes());
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_removeBatteryLevelClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<BatteryServiceMockCallback>() {

            @NonNull
            @Override
            public BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> removeBatteryLevelClientCharacteristicConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeBatteryLevelClientCharacteristicConfiguration(index);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevelClientCharacteristicConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevelClientCharacteristicConfiguration_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        CyclingPowerServiceMockCallback.Builder<CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder = new CyclingPowerServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

        Exception exception = null;
        try {
            baseBuilder.removeBatteryLevelClientCharacteristicConfiguration(originalIndex);
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addModelNumberString(0, 0, new ModelNumberString("").getBytes())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), new DeviceInformationServiceMockCallback.Builder<>(), new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
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
        CyclingPowerProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext(), new CyclingPowerServiceMockCallback.Builder<>(), null, new BatteryServiceMockCallback.Builder<>())
                    .addCyclingPowerFeature(new CyclingPowerFeature(new byte[4]))
                    .addCyclingPowerMeasurement(new CyclingPowerMeasurement(new byte[4]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();

        assertNotNull(callback);
    }

}
