package org.im97mori.ble.profile.hrp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a37.HeartRateMeasurement;
import org.im97mori.ble.characteristic.u2a38.BodySensorLocation;
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HeartRateProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
        assertEquals(heartRateServiceMockCallbackBuilder, baseBuilder.mHeartRateServiceMockCallbackBuilder);
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responceCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responceCode, delay, value);
            }
        };
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";
        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(manufacturerName);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responceCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responceCode, delay, value);
            }
        };
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responceCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responceCode, delay, value);
            }
        };
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponceCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responceCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponceCode, responceCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responceCode, delay, value);
            }
        };
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponceCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8, 0};
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> addHeartRateMeasurement(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(characteristicValue, characteristicValue);
                assertArrayEquals(descriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addHeartRateMeasurement(characteristicResponceCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponceCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        byte[] characteristicValue = new byte[]{HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8, 0};
        final HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(characteristicValue);

        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalDescriptorResponseCode = 40;
        final long originalDescriptorDelay = 41;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> addHeartRateMeasurement(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(heartRateMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponceCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalDescriptorResponseCode, descriptorResponceCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addHeartRateMeasurement(characteristicResponceCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponceCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateMeasurement(originalCharacteristicResponseCode, originalCharacteristicDelay, heartRateMeasurement.getBytes(), originalDescriptorResponseCode, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBloodPressureMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> removeHeartRateMeasurement() {
                atomicBoolean.set(true);
                return super.removeHeartRateMeasurement();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeHeartRateMeasurement());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBodySensorLocation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{BodySensorLocation.BODY_SENSOR_LOCATION_CHEST};
        BodySensorLocation bodySensorLocation = new BodySensorLocation(characteristicValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> addBodySensorLocation(int responceCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(characteristicValue, value);
                atomicBoolean.set(true);
                return super.addBodySensorLocation(responceCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBodySensorLocation(bodySensorLocation));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBodySensorLocation_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        byte[] characteristicValue = new byte[]{BodySensorLocation.BODY_SENSOR_LOCATION_CHEST};
        final BodySensorLocation bodySensorLocation = new BodySensorLocation(characteristicValue);

        final int originalCharacteristicResponseCode = 75;
        final long originalCharacteristicDelay = 76;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> addBodySensorLocation(int responceCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(bodySensorLocation.getBytes(), value);
                assertEquals(originalCharacteristicResponseCode, responceCode);
                assertEquals(originalCharacteristicDelay, delay);
                atomicBoolean.set(true);
                return super.addBodySensorLocation(responceCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBodySensorLocation(originalCharacteristicResponseCode, originalCharacteristicDelay, bodySensorLocation.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBodySensorLocation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> removeBodySensorLocation() {
                atomicBoolean.set(true);
                return super.removeBodySensorLocation();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBodySensorLocation());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED};
        HeartRateControlPoint heartRateControlPoint = new HeartRateControlPoint(characteristicValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> addHeartRateControlPoint(int responceCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(characteristicValue, value);
                atomicBoolean.set(true);
                return super.addHeartRateControlPoint(responceCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateControlPoint(heartRateControlPoint));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addHeartRateControlPoint_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        byte[] characteristicValue = new byte[]{HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED};
        final HeartRateControlPoint heartRateControlPoint = new HeartRateControlPoint(characteristicValue);

        final int originalResponseCode = 1;
        final long originalDelay = 2;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> addHeartRateControlPoint(int responceCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(heartRateControlPoint.getBytes(), value);
                assertEquals(originalResponseCode, responceCode);
                assertEquals(originalDelay, delay);
                atomicBoolean.set(true);
                return super.addHeartRateControlPoint(responceCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addHeartRateControlPoint(originalResponseCode, originalDelay, heartRateControlPoint.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeHeartRateControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder = new HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback>() {

            @NonNull
            @Override
            public HeartRateServiceMockCallback.Builder<HeartRateServiceMockCallback> removeHeartRateControlPoint() {
                atomicBoolean.set(true);
                return super.removeHeartRateControlPoint();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeHeartRateControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HeartRateServiceMockCallback.Builder<>()).build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Manufacturer Name String data", exception.getMessage());
    }

    @Test
    public void test_build_00101() {
        final byte[] characteristicValue = new byte[]{HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8 | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT, 0, 1, 2};
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HeartRateServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("");
            baseBuilder.addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Heart Rate Control Point data", exception.getMessage());
    }

    @Test
    public void test_build_00102() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(new byte[]{HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8 | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT, 0, 1, 2});

        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        HeartRateControlPoint heartRateControlPoint = new HeartRateControlPoint(new byte[]{HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED});

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HeartRateServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("");
            baseBuilder.addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration);
            baseBuilder.addHeartRateControlPoint(heartRateControlPoint);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00201() {
        final byte[] characteristicValue = new byte[]{HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8, 0};
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HeartRateServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("");
            baseBuilder.addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

}
