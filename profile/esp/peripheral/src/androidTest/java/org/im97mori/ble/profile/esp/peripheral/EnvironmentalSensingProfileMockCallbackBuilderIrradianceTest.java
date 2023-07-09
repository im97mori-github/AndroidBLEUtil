package org.im97mori.ble.profile.esp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a77.Irradiance;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnvironmentalSensingProfileMockCallbackBuilderIrradianceTest {

    @Test
    public void test_addIrradiance_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final Irradiance originalValue = new Irradiance(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addIrradiance(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addIrradiance(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addIrradiance(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addIrradiance_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final Irradiance originalValue = new Irradiance(new byte[]{4, 5});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addIrradiance(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addIrradiance(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addIrradiance(originalIndex, originalProperty, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIrradiance_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeIrradiance(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeIrradiance(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIrradiance(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{1, 2}, 3, 4, 5, 6, 7);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceEsMeasurement(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceEsMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{3, 4}, 5, 6, 7, 8, 9);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceEsMeasurement(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIrradianceEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeIrradianceEsMeasurement(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeIrradiance(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIrradianceEsMeasurement(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;
        final EnvironmentalSensingTriggerSetting originalValue = new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceEsTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;
        final int originalPermission = 2;
        final int originalResponseCode = 3;
        final long originalDelay = 4;
        final EnvironmentalSensingTriggerSetting originalValue = new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIrradianceEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                atomicBoolean.set(true);
                return super.removeIrradianceEsTriggerSetting(characteristicIndex, descriptorIndex);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIrradianceEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceEsConfiguration(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceEsConfiguration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalPermission = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceEsConfiguration(originalIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIrradianceEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeIrradianceEsConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeIrradiance(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIrradianceEsConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicUserDescription originalValue = new CharacteristicUserDescription(new byte[]{1});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceCharacteristicUserDescription(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceCharacteristicUserDescription(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIrradianceCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeIrradianceCharacteristicUserDescription(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeIrradiance(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIrradianceCharacteristicUserDescription(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceValidRange(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setIrradianceValidRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setIrradianceValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setIrradianceCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setIrradianceValidRange(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeIrradianceValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeIrradianceValidRange(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeIrradiance(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeIrradianceValidRange(originalIndex));

        assertTrue(atomicBoolean.get());
    }

}
