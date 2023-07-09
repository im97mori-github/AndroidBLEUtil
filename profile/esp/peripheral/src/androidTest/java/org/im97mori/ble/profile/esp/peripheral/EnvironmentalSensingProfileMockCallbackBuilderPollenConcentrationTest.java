package org.im97mori.ble.profile.esp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a75.PollenConcentration;
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

public class EnvironmentalSensingProfileMockCallbackBuilderPollenConcentrationTest {

    @Test
    public void test_addPollenConcentration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final PollenConcentration originalValue = new PollenConcentration(new byte[]{1, 2, 3});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addPollenConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addPollenConcentration(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addPollenConcentration(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addPollenConcentration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final PollenConcentration originalValue = new PollenConcentration(new byte[]{4, 5, 6});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addPollenConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addPollenConcentration(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addPollenConcentration(originalIndex, originalProperty, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removePollenConcentration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removePollenConcentration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removePollenConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removePollenConcentration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{1, 2}, 3, 4, 5, 6, 7);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationEsMeasurement(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationEsMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{3, 4}, 5, 6, 7, 8, 9);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationEsMeasurement(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removePollenConcentrationEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removePollenConcentrationEsMeasurement(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removePollenConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removePollenConcentrationEsMeasurement(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;
        final EnvironmentalSensingTriggerSetting originalValue = new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00002() {
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
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removePollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                atomicBoolean.set(true);
                return super.removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removePollenConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationEsConfiguration(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationEsConfiguration_00002() {
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
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationEsConfiguration(originalIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removePollenConcentrationEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removePollenConcentrationEsConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removePollenConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removePollenConcentrationEsConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicUserDescription originalValue = new CharacteristicUserDescription(new byte[]{1});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationCharacteristicUserDescription(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationCharacteristicUserDescription(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removePollenConcentrationCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removePollenConcentrationCharacteristicUserDescription(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removePollenConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removePollenConcentrationCharacteristicUserDescription(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2, 3});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationValidRange(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setPollenConcentrationValidRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2, 3});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setPollenConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setPollenConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setPollenConcentrationValidRange(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removePollenConcentrationValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removePollenConcentrationValidRange(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removePollenConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removePollenConcentrationValidRange(originalIndex));

        assertTrue(atomicBoolean.get());
    }

}
