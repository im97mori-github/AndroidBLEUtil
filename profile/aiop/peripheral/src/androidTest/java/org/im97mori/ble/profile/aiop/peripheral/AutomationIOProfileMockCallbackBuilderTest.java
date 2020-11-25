package org.im97mori.ble.profile.aiop.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationIOProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(automationIOServiceMockCallbackBuilder, baseBuilder.mAutomationIOServiceMockCallbackBuilder);
    }

    @Test
    public void test_addDigital_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalProperty = 2;
        final int originalResponseCode = 3;
        final long originalDelay = 4;
        final byte[] originalValue = new byte[]{5};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {
            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigital(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigital(index, property, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigital(originalIndex, originalProperty, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigital_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigital(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigital(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDigitalClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigitalClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigitalClientCharacteristicConfiguration(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigitalClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigitalClientCharacteristicConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigitalClientCharacteristicConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDigitalCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigitalCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigitalCharacteristicPresentationFormat(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigitalCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigitalCharacteristicPresentationFormat(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigitalCharacteristicPresentationFormat(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDigitalCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigitalCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigitalCharacteristicUserDescription(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigitalCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigitalCharacteristicUserDescription(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigitalCharacteristicUserDescription(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDigitalCharacteristicExtendedProperties_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigitalCharacteristicExtendedProperties(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigitalCharacteristicExtendedProperties(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigitalCharacteristicExtendedProperties_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigitalCharacteristicExtendedProperties(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigitalCharacteristicExtendedProperties(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDigitalValueTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigitalValueTriggerSetting(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigitalValueTriggerSetting(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigitalValueTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigitalValueTriggerSetting(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigitalValueTriggerSetting(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDigitalTimeTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigitalTimeTriggerSetting(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigitalTimeTriggerSetting(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigitalTimeTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigitalTimeTriggerSetting(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigitalTimeTriggerSetting(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addDigitalNumberOfDigitals_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addDigitalNumberOfDigitals(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addDigitalNumberOfDigitals(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeDigitalNumberOfDigitals_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeDigitalNumberOfDigitals(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeDigitalNumberOfDigitals(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalog_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalProperty = 2;
        final int originalResponseCode = 3;
        final long originalDelay = 4;
        final byte[] originalValue = new byte[]{5};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {
            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalog(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalog(index, property, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalog(originalIndex, originalProperty, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalog_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalog(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeAnalog(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalog(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalogClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalogClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalogClientCharacteristicConfiguration(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalogClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalogClientCharacteristicConfiguration(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeAnalog(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalogClientCharacteristicConfiguration(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalogCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalogCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalogCharacteristicPresentationFormat(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalogCharacteristicPresentationFormat_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalogCharacteristicPresentationFormat(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeAnalog(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalogCharacteristicPresentationFormat(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalogCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalogCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalogCharacteristicUserDescription(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalogCharacteristicUserDescription_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalogCharacteristicUserDescription(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeAnalog(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalogCharacteristicUserDescription(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalogCharacteristicExtendedProperties_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalogCharacteristicExtendedProperties(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalogCharacteristicExtendedProperties(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalogCharacteristicExtendedProperties_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalogCharacteristicExtendedProperties(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeAnalog(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalogCharacteristicExtendedProperties(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalogValueTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalogValueTriggerSetting(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalogValueTriggerSetting(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalogValueTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalogValueTriggerSetting(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeAnalog(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalogValueTriggerSetting(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalogTimeTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalogTimeTriggerSetting(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalogTimeTriggerSetting(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalogTimeTriggerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalogTimeTriggerSetting(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeAnalog(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalogTimeTriggerSetting(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAnalogValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;
        final byte[] originalValue = new byte[]{4};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAnalogValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIndex, index);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAnalogValidRange(originalIndex, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAnalogValidRange_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAnalogValidRange(int index) {
                assertEquals(originalIndex, index);
                atomicBoolean.set(true);
                return super.removeDigital(index);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAnalogValidRange(originalIndex));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAggregate_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalProperty = 1;
        final int originalResponseCode = 2;
        final long originalDelay = 3;

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAggregate(int property, int responseCode, long delay) {
                assertEquals(originalProperty, property);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                atomicBoolean.set(true);
                return super.addAggregate(property, responseCode, delay);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAggregate(originalProperty, originalResponseCode, originalDelay));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAggregate_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAggregate() {
                atomicBoolean.set(true);
                return super.removeAggregate();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAggregate());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAggregateClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new byte[]{3};

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> addAggregateClientCharacteristicConfiguration(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAggregateClientCharacteristicConfiguration(responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAggregateClientCharacteristicConfiguration(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAggregateClientCharacteristicConfiguration_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder = new AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback>() {

            @NonNull
            @Override
            public AutomationIOServiceMockCallback.Builder<AutomationIOServiceMockCallback> removeAggregateClientCharacteristicConfiguration() {
                atomicBoolean.set(true);
                return super.removeAggregate();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, automationIOServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAggregateClientCharacteristicConfiguration());

        assertTrue(atomicBoolean.get());
    }

}
