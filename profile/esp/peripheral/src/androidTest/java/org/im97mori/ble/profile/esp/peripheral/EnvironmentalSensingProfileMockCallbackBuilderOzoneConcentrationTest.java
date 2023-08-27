package org.im97mori.ble.profile.esp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2bd4.OzoneConcentration;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnvironmentalSensingProfileMockCallbackBuilderOzoneConcentrationTest extends TestBase {

    @Test
    public void test_addOzoneConcentration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final OzoneConcentration originalValue = new OzoneConcentration(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addOzoneConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addOzoneConcentration(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addOzoneConcentration(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addOzoneConcentration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final OzoneConcentration originalValue = new OzoneConcentration(new byte[]{4, 5});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> addOzoneConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.addOzoneConcentration(index, property, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addOzoneConcentration(originalIndex, originalProperty, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeOzoneConcentration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeOzoneConcentration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeOzoneConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeOzoneConcentration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{1, 2}, 3, 4, 5, 6, 7);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationEsMeasurement(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationEsMeasurement_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingMeasurement originalValue = new EnvironmentalSensingMeasurement(new byte[]{3, 4}, 5, 6, 7, 8, 9);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationEsMeasurement(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationEsMeasurement(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeOzoneConcentrationEsMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeOzoneConcentrationEsMeasurement(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeOzoneConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeOzoneConcentrationEsMeasurement(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;
        final EnvironmentalSensingTriggerSetting originalValue = new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationEsTriggerSetting_00002() {
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
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeOzoneConcentrationEsTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicIndex = 0;
        final int originalDescriptorIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeOzoneConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
                assertEquals(originalCharacteristicIndex, characteristicIndex);
                assertEquals(originalDescriptorIndex, descriptorIndex);
                atomicBoolean.set(true);
                return super.removeOzoneConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeOzoneConcentrationEsTriggerSetting(originalCharacteristicIndex, originalDescriptorIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationEsConfiguration(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationEsConfiguration_00002() {
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
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalPermission, permission);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationEsConfiguration(index, permission, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationEsConfiguration(originalIndex, originalPermission, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeOzoneConcentrationEsConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeOzoneConcentrationEsConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeOzoneConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeOzoneConcentrationEsConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicUserDescription originalValue = new CharacteristicUserDescription(new byte[]{1});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationCharacteristicUserDescription(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final EnvironmentalSensingConfiguration originalValue = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationCharacteristicUserDescription(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeOzoneConcentrationCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeOzoneConcentrationCharacteristicUserDescription(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeOzoneConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeOzoneConcentrationCharacteristicUserDescription(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationValidRange(originalIndex, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_setOzoneConcentrationValidRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final ValidRange originalValue = new ValidRange(new byte[]{1, 2});

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> setOzoneConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue.getBytes(), value);
                atomicBoolean.set(true);
                return super.setOzoneConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.setOzoneConcentrationValidRange(originalIndex, originalResponseCode, originalDelay, originalValue.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeOzoneConcentrationValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;

        Context context = ApplicationProvider.getApplicationContext();
        EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder = new EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback>() {
            @NonNull
            @Override
            public EnvironmentalSensingServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> removeOzoneConcentrationValidRange(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeOzoneConcentration(index);
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder = new DeviceInformationServiceMockCallback.Builder<>();
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> batteryServiceMockCallbackBuilder = new BatteryServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, environmentalSensingServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeOzoneConcentrationValidRange(originalIndex));

        assertTrue(atomicBoolean.get());
    }

}
