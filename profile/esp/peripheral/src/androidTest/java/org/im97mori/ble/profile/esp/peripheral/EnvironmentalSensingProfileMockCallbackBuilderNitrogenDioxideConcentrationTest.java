package org.im97mori.ble.profile.esp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2bd2.NitrogenDioxideConcentration;
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

public class EnvironmentalSensingProfileMockCallbackBuilderNitrogenDioxideConcentrationTest {

    @Test
    public void test_addNitrogenDioxideConcentration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final NitrogenDioxideConcentration originalValue = new NitrogenDioxideConcentration(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addNitrogenDioxideConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addNitrogenDioxideConcentration(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addNitrogenDioxideConcentration(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addNitrogenDioxideConcentration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final NitrogenDioxideConcentration originalValue = new NitrogenDioxideConcentration(new byte[]{4, 5});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addNitrogenDioxideConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addNitrogenDioxideConcentration(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addNitrogenDioxideConcentration(originalIndex, originalProperty, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNitrogenDioxideConcentration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeNitrogenDioxideConcentration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeNitrogenDioxideConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNitrogenDioxideConcentration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{1, 2}, 3, 4, 5, 6, 7);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationEsMeasurement(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationEsMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{3, 4}, 5, 6, 7, 8, 9);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationEsMeasurement(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNitrogenDioxideConcentrationEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeNitrogenDioxideConcentrationEsMeasurement(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeNitrogenDioxideConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNitrogenDioxideConcentrationEsMeasurement(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;
        final EnvironmentalSensingTriggerSetting originalValue = new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationEsTriggerSetting_00002() {
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
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNitrogenDioxideConcentrationEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeNitrogenDioxideConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                atomicBoolean.set(true);
                return super.removeNitrogenDioxideConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNitrogenDioxideConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationEsConfiguration(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationEsConfiguration_00002() {
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
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationEsConfiguration(originalIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNitrogenDioxideConcentrationEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeNitrogenDioxideConcentrationEsConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeNitrogenDioxideConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNitrogenDioxideConcentrationEsConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicUserDescription originalValue = new CharacteristicUserDescription(new byte[]{1});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationCharacteristicUserDescription(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationCharacteristicUserDescription(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNitrogenDioxideConcentrationCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeNitrogenDioxideConcentrationCharacteristicUserDescription(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeNitrogenDioxideConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNitrogenDioxideConcentrationCharacteristicUserDescription(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationValidRange(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setNitrogenDioxideConcentrationValidRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setNitrogenDioxideConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setNitrogenDioxideConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setNitrogenDioxideConcentrationValidRange(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNitrogenDioxideConcentrationValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeNitrogenDioxideConcentrationValidRange(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeNitrogenDioxideConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNitrogenDioxideConcentrationValidRange(originalIndex));

        assertTrue(atomicBoolean.get());
    }

}
