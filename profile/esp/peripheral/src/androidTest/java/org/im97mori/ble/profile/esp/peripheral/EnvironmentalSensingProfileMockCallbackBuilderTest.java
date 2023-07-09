package org.im97mori.ble.profile.esp.peripheral;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class EnvironmentalSensingProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(environmentalSensingServiceMockCallbackBuilder, baseBuilder.mEnvironmentalSensingServiceMockCallbackBuilder);
        assertEquals(deviceInformationServiceMockCallbackBuilder, baseBuilder.mDeviceInformationServiceMockCallbackBuilder);
        assertEquals(batteryServiceMockCallbackBuilder, baseBuilder.mBatteryServiceMockCallbackBuilder);
    }

    @Test
    public void test_addDescriptorValueChanged_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addDescriptorValueChanged(int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addDescriptorValueChanged(descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDescriptorValueChanged(clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDescriptorValueChanged_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalDescriptorResponseCode = 1;
        final long originalDescriptorDelay = 2;
        final byte[] originalValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addDescriptorValueChanged(int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(descriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addDescriptorValueChanged(descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDescriptorValueChanged(originalDescriptorResponseCode, originalDescriptorDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDescriptorValueChanged_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeDescriptorValueChanged() {
                atomicBoolean.set(true);
                return super.removeDescriptorValueChanged();
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDescriptorValueChanged());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerName));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String manufacturerName = "manufacturerName";
        ManufacturerNameString manufacturerNameString = new ManufacturerNameString(manufacturerName);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(manufacturerNameString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addManufacturerNameString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addManufacturerNameString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "manufacturerName".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, null, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeManufacturerNameString() {
                atomicBoolean.set(true);
                return super.removeManufacturerNameString();
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeManufacturerNameString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeManufacturerNameString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, null, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumber));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String modelNumber = "modelNumber";
        ModelNumberString modelNumberString = new ModelNumberString(modelNumber);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(modelNumberString));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addModelNumberString(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addModelNumberString_00101() {
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = "modelNumber".getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, null, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback>() {
            @NonNull
            @Override
            public DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> removeModelNumberString() {
                atomicBoolean.set(true);
                return super.removeModelNumberString();
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeModelNumberString());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeModelNumberString_00101() {
        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, null, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevel(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevel_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevelCharacteristicPresentationFormat(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevelCharacteristicPresentationFormat_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

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
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
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
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBatteryLevelClientCharacteristicConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBatteryLevelClientCharacteristicConfiguration_00101() {
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, null);

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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
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
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , new DeviceInformationServiceMockCallback.Builder<>()
                    , new BatteryServiceMockCallback.Builder<>())
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
        EnvironmentalSensingProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new EnvironmentalSensingServiceMockCallback.Builder<>()
                    , null
                    , new BatteryServiceMockCallback.Builder<>())
                    .build();

        assertNotNull(callback);
    }

}
