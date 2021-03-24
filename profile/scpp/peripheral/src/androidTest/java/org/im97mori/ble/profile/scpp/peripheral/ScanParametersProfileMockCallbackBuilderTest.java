package org.im97mori.ble.profile.scpp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a31.ScanRefresh;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ScanParametersProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, scanParametersServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(scanParametersServiceMockCallbackBuilder, baseBuilder.mScanParametersServiceMockCallbackBuilder);
    }

    @Test
    public void test_addScanIntervalWindow_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[]{1, 2, 3, 4};
        final ScanIntervalWindow scanIntervalWindow = new ScanIntervalWindow(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback>() {
            @NonNull
            @Override
            public ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> addScanIntervalWindow(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addScanIntervalWindow(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , scanParametersServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addScanIntervalWindow(scanIntervalWindow));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addScanIntervalWindow_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[]{1, 2, 3, 4};

        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback>() {
            @NonNull
            @Override
            public ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> addScanIntervalWindow(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addScanIntervalWindow(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , scanParametersServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addScanIntervalWindow(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addScanIntervalWindow_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 0;
        final long originalDelay = 1;
        final byte[] originalValue = new byte[]{2, 3, 4, 5};

        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback>() {
            @NonNull
            @Override
            public ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> addScanIntervalWindow(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addScanIntervalWindow(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , scanParametersServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addScanIntervalWindow(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeScanIntervalWindow_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback>() {

            @NonNull
            @Override
            public ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> removeScanIntervalWindow() {
                atomicBoolean.set(true);
                return super.removeScanIntervalWindow();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , scanParametersServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeScanIntervalWindow());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addScanRefresh_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalCharacteristicValue = new byte[]{1};
        final ScanRefresh currentTime = new ScanRefresh(originalCharacteristicValue);
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback>() {
            @NonNull
            @Override
            public ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> addScanRefresh(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalCharacteristicValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addScanRefresh(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , scanParametersServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addScanRefresh(currentTime, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addScanRefresh_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;
        final byte[] originalCharacteristicValue = new byte[]{6};
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;

        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback>() {
            @NonNull
            @Override
            public ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> addScanRefresh(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalCharacteristicValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addScanRefresh(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , scanParametersServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addScanRefresh(originalCharacteristicResponseCode, originalCharacteristicDelay, originalCharacteristicValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCurrentTime_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder = new ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback>() {
            @NonNull
            @Override
            public ScanParametersServiceMockCallback.Builder<ScanParametersServiceMockCallback> removeScanRefresh() {
                atomicBoolean.set(true);
                return super.removeScanRefresh();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , scanParametersServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeScanRefresh());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new ScanParametersServiceMockCallback.Builder<>())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Scan Interval Window data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new ScanParametersServiceMockCallback.Builder<>())
                    .addScanIntervalWindow(new ScanIntervalWindow(0, 1))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

}
