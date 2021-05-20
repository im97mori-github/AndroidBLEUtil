package org.im97mori.ble.profile.htp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a1c.TemperatureMeasurement;
import org.im97mori.ble.characteristic.u2a1d.TemperatureType;
import org.im97mori.ble.characteristic.u2a1e.IntermediateTemperature;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HealthThermometerProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
        assertEquals(healthThermometerServiceMockCallback, baseBuilder.mHealthThermometerServiceMockCallback);
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
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
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(manufacturerName.getBytes(), value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
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
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addManufacturerNameString(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
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
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));

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
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumber));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";
        ModelNumberString modelNumberString = new ModelNumberString(modelNumber);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(modelNumber.getBytes(), value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumberString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addModelNumberString(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
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
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeModelNumberString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeModelNumberString() {
                atomicBoolean.set(true);
                return super.removeModelNumberString();
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.removeModelNumberString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final SystemId systemId = new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(systemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }

        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addSystemId(manufacturerIdentifier, organizationallyUniqueIdentifier));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final SystemId systemId = new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(systemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addSystemId(systemId));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final SystemId systemId = new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(systemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addSystemId(systemId.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSystemId_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final SystemId systemId = new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(systemId.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSystemId(responseCode, delay, value);
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addSystemId(originalResponseCode, originalDelay, systemId.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSystemId_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {

            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeSystemId() {
                atomicBoolean.set(true);
                return super.removeSystemId();
            }
        };
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.removeSystemId());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTemperatureMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        final TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addTemperatureMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(temperatureMeasurement.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addTemperatureMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTemperatureMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        final TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalDescriptorResponseCode = 40;
        final long originalDescriptorDelay = 41;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addTemperatureMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(temperatureMeasurement.getBytes(), characteristicValue);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addTemperatureMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addTemperatureMeasurement(originalCharacteristicResponseCode, originalCharacteristicDelay, temperatureMeasurement.getBytes(), originalDescriptorResponseCode, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTemperatureMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> removeTemperatureMeasurement() {
                atomicBoolean.set(true);
                return super.removeTemperatureMeasurement();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.removeTemperatureMeasurement());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTemperatureType_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0};
        final TemperatureType temperatureType = new TemperatureType(characteristicValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addTemperatureType(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(temperatureType.getBytes(), value);
                atomicBoolean.set(true);
                return super.addTemperatureType(responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addTemperatureType(temperatureType));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTemperatureType_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0};
        final TemperatureType temperatureType = new TemperatureType(characteristicValue);

        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addTemperatureType(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicResponseCode, responseCode);
                assertEquals(originalCharacteristicDelay, delay);
                assertArrayEquals(temperatureType.getBytes(), value);
                atomicBoolean.set(true);
                return super.addTemperatureType(responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addTemperatureType(originalCharacteristicResponseCode, originalCharacteristicDelay, temperatureType.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTemperatureType_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> removeTemperatureType() {
                atomicBoolean.set(true);
                return super.removeTemperatureType();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.removeTemperatureType());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addIntermediateTemperature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        final IntermediateTemperature intermediateTemperature = new IntermediateTemperature(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addIntermediateTemperature(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(intermediateTemperature.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addIntermediateTemperature(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addIntermediateTemperature(intermediateTemperature, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addIntermediateTemperature_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        final IntermediateTemperature intermediateTemperature = new IntermediateTemperature(characteristicValue);

        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalDescriptorResponseCode = 40;
        final long originalDescriptorDelay = 41;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addIntermediateTemperature(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(intermediateTemperature.getBytes(), characteristicValue);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addIntermediateTemperature(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addIntermediateTemperature(originalCharacteristicResponseCode, originalCharacteristicDelay, intermediateTemperature.getBytes(), originalDescriptorResponseCode, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIntermediateTemperature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> removeIntermediateTemperature() {
                atomicBoolean.set(true);
                return super.removeIntermediateTemperature();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.removeIntermediateTemperature());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addMeasurementInterval_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0, 1};
        final MeasurementInterval measurementInterval = new MeasurementInterval(characteristicValue);

        final byte[] descriptorValue1 = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue1);

        final byte[] descriptorValue2 = new byte[]{2, 3, 4, 5};
        final ValidRange validRange = new ValidRange(descriptorValue2);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addMeasurementInterval(int measurementIntervalResponseCode
                    , long measurementIntervalDelay
                    , @NonNull byte[] measurementIntervalValue
                    , boolean isMeasurementIntervalIndicatable
                    , boolean isMeasurementIntervalWritable
                    , int clientCharacteristicConfigurationResponseCode
                    , long clientCharacteristicConfigurationDelay
                    , @NonNull byte[] clientCharacteristicConfigurationValue
                    , int validRangeResponseCode
                    , long validRangeDelay
                    , @NonNull byte[] validRangeValue) {
                assertArrayEquals(measurementInterval.getBytes(), measurementIntervalValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), clientCharacteristicConfigurationValue);
                assertArrayEquals(validRange.getBytes(), validRangeValue);
                atomicBoolean.set(true);
                return super.addMeasurementInterval(measurementIntervalResponseCode, measurementIntervalDelay, measurementIntervalValue, isMeasurementIntervalIndicatable, isMeasurementIntervalWritable, clientCharacteristicConfigurationResponseCode, clientCharacteristicConfigurationDelay, clientCharacteristicConfigurationValue, validRangeResponseCode, validRangeDelay, validRangeValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addMeasurementInterval(measurementInterval, clientCharacteristicConfiguration, validRange));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addMeasurementInterval_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] characteristicValue = new byte[]{0, 1};
        final MeasurementInterval measurementInterval = new MeasurementInterval(characteristicValue);

        final byte[] descriptorValue1 = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue1);

        final byte[] descriptorValue2 = new byte[]{2, 3, 4, 5};
        final ValidRange validRange = new ValidRange(descriptorValue2);

        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalDescriptorResponseCode1 = 40;
        final long originalDescriptorDelay1 = 41;
        final int originalDescriptorResponseCode2 = 42;
        final long originalDescriptorDelay2 = 43;

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> addMeasurementInterval(int measurementIntervalResponseCode
                    , long measurementIntervalDelay
                    , @NonNull byte[] measurementIntervalValue
                    , boolean isMeasurementIntervalIndicatable
                    , boolean isMeasurementIntervalWritable
                    , int clientCharacteristicConfigurationResponseCode
                    , long clientCharacteristicConfigurationDelay
                    , @NonNull byte[] clientCharacteristicConfigurationValue
                    , int validRangeResponseCode
                    , long validRangeDelay
                    , @NonNull byte[] validRangeValue) {
                assertEquals(originalCharacteristicResponseCode, measurementIntervalResponseCode);
                assertEquals(originalCharacteristicDelay, measurementIntervalDelay);
                assertArrayEquals(measurementInterval.getBytes(), measurementIntervalValue);
                assertEquals(originalDescriptorResponseCode1, clientCharacteristicConfigurationResponseCode);
                assertEquals(originalDescriptorDelay1, clientCharacteristicConfigurationDelay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), clientCharacteristicConfigurationValue);
                assertEquals(originalDescriptorResponseCode2, validRangeResponseCode);
                assertEquals(originalDescriptorDelay2, validRangeDelay);
                assertArrayEquals(validRange.getBytes(), validRangeValue);
                atomicBoolean.set(true);
                return super.addMeasurementInterval(measurementIntervalResponseCode, measurementIntervalDelay, measurementIntervalValue, isMeasurementIntervalIndicatable, isMeasurementIntervalWritable, clientCharacteristicConfigurationResponseCode, clientCharacteristicConfigurationDelay, clientCharacteristicConfigurationValue, validRangeResponseCode, validRangeDelay, validRangeValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.addMeasurementInterval(originalCharacteristicResponseCode, originalCharacteristicDelay, measurementInterval.getBytes(), true, true, originalDescriptorResponseCode1, originalDescriptorDelay1, clientCharacteristicConfiguration.getBytes(), originalDescriptorResponseCode2, originalDescriptorDelay2, validRange.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeMeasurementInterval_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback = new HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback>() {

            @NonNull
            @Override
            public HealthThermometerServiceMockCallback.Builder<HealthThermometerServiceMockCallback> removeMeasurementInterval() {
                atomicBoolean.set(true);
                return super.removeMeasurementInterval();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallback);
        assertEquals(baseBuilder, baseBuilder.removeMeasurementInterval());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>()).build();
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
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>())
                    .addManufacturerNameString("Manufacturer Name String data")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Model Number String data", exception.getMessage());
    }

    @Test
    public void test_build_00003() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>())
                    .addManufacturerNameString("Manufacturer Name String data")
                    .addModelNumberString("Model Number String data")
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no System ID data", exception.getMessage());
    }

    @Test
    public void test_build_00004() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>())
                    .addManufacturerNameString("Manufacturer Name String data")
                    .addModelNumberString("Model Number String data")
                    .addSystemId(0, 1)
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Temperature Measurement data", exception.getMessage());
    }

    @Test
    public void test_build_00101() {
        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("Manufacturer Name String data");
            baseBuilder.addModelNumberString("Model Number String data");
            baseBuilder.addSystemId(0, 1);
            baseBuilder.addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00201() {
        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("Manufacturer Name String data");
            baseBuilder.addModelNumberString("Model Number String data");
            baseBuilder.addSystemId(0, 1);
            baseBuilder.addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00301() {
        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("Manufacturer Name String data");
            baseBuilder.addModelNumberString("Model Number String data");
            baseBuilder.addSystemId(0, 1);
            baseBuilder.addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration);
            baseBuilder.addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("A value of 0 is not valid for the lower inclusive value", exception.getMessage());
    }

    @Test
    public void test_build_00302() {
        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(6);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("Manufacturer Name String data");
            baseBuilder.addModelNumberString("Model Number String data");
            baseBuilder.addSystemId(0, 1);
            baseBuilder.addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration);
            baseBuilder.addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Out of Range", exception.getMessage());
    }

    @Test
    public void test_build_00303() {
        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{2, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            BaseBuilder baseBuilder = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>());
            baseBuilder.addManufacturerNameString("Manufacturer Name String data");
            baseBuilder.addModelNumberString("Model Number String data");
            baseBuilder.addSystemId(0, 1);
            baseBuilder.addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration);
            baseBuilder.addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange);
            baseBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Out of Range", exception.getMessage());
    }

    @Test
    public void test_build_00304() {
        final byte[] characteristicValue = new byte[]{0, 1, 2, 3, 4, 5};
        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(characteristicValue);

        final byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(0);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        HealthThermometerProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext(), new DeviceInformationServiceMockCallback.Builder<>(), new HealthThermometerServiceMockCallback.Builder<>())
                .addManufacturerNameString("Manufacturer Name String data")
                .addModelNumberString("Model Number String data")
                .addSystemId(0, 1)
                .addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration)
                .addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange)
                .build();

        assertNotNull(callback);
    }

}
