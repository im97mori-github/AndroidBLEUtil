package org.im97mori.ble.profile.fmp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindMeProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, immediateAlertServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(immediateAlertServiceMockCallbackBuilder, baseBuilder.mImmediateAlertServiceMockCallbackBuilder);
    }

    @Test
    public void test_addAlertLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(int alertLevel) {
                assertEquals(originalAlertLevel.getAlertLevel(), alertLevel);
                atomicBoolean.set(true);
                return super.addAlertLevel(alertLevel);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, immediateAlertServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAlertLevel(originalAlertLevel.getAlertLevel()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAlertLevel_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(@NonNull AlertLevel alertLevel) {
                assertArrayEquals(originalAlertLevel.getBytes(), alertLevel.getBytes());
                atomicBoolean.set(true);
                return super.addAlertLevel(alertLevel);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, immediateAlertServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAlertLevel(originalAlertLevel));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAlertLevel_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertLevel originalAlertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);

        Context context = ApplicationProvider.getApplicationContext();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(@NonNull byte[] value) {
                assertArrayEquals(originalAlertLevel.getBytes(), value);
                atomicBoolean.set(true);
                return super.addAlertLevel(value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, immediateAlertServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAlertLevel(originalAlertLevel.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAlertLevel_00004() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final byte[] originalValue = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT).getBytes();

        Context context = ApplicationProvider.getApplicationContext();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> addAlertLevel(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addAlertLevel(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, immediateAlertServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAlertLevel(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAlertLevel_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder = new ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback>() {
            @NonNull
            @Override
            public ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> removeAlertLevel() {
                atomicBoolean.set(true);
                return super.removeAlertLevel();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, immediateAlertServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAlertLevel());

        assertTrue(atomicBoolean.get());
    }

}
