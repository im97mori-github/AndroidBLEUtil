package org.im97mori.ble.service.tip.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a11.TimeWithDst;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateState;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback;
import org.im97mori.ble.service.ndcs.peripheral.NextDstChangeServiceMockCallback;
import org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TimeProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, currentTimeServiceMockCallbackBuilder, nextDstChangeServiceMockCallbackBuilder, referenceTimeUpdateServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(currentTimeServiceMockCallbackBuilder, baseBuilder.mCurrentTimeServiceMockCallbackBuilder);
        assertEquals(nextDstChangeServiceMockCallbackBuilder, baseBuilder.mNextDstChangeServiceMockCallbackBuilder);
        assertEquals(referenceTimeUpdateServiceMockCallbackBuilder, baseBuilder.mReferenceTimeUpdateServiceMockCallbackBuilder);
    }

    @Test
    public void test_addCurrentTime_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalCharacteristicValue = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final CurrentTime currentTime = new CurrentTime(originalCharacteristicValue);
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(originalDescriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {
            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addCurrentTime(boolean isWritable, int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(originalCharacteristicValue, characteristicValue);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addCurrentTime(isWritable, characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCurrentTime(currentTime, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addCurrentTime_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final boolean originalIsWritable = false;
        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalNotificationCount = 3;
        final int originalDescriptorResponseCode = 4;
        final long originalDescriptorDelay = 5;
        final byte[] originalCharacteristicValue = new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {
            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addCurrentTime(boolean isWritable, int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(originalIsWritable, isWritable);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(originalCharacteristicValue, characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addCurrentTime(isWritable, characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addCurrentTime(originalIsWritable, originalCharacteristicResponseCode, originalCharacteristicDelay, originalCharacteristicValue, originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeCurrentTime_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {
            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> removeCurrentTime() {
                atomicBoolean.set(true);
                return super.removeCurrentTime();
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeCurrentTime());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLocalTimeInformation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2};
        final LocalTimeInformation localTimeInformation = new LocalTimeInformation(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addLocalTimeInformation(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addLocalTimeInformation(isWritable, responseCode, delay, value);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLocalTimeInformation(localTimeInformation));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLocalTimeInformation_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addLocalTimeInformation(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addLocalTimeInformation(isWritable, responseCode, delay, value);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLocalTimeInformation(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addLocalTimeInformation_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final boolean originalIsWritable = false;
        final int originalResponseCode = 0;
        final long originalDelay = 1;
        final byte[] originalValue = new byte[]{2, 3};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addLocalTimeInformation(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalIsWritable, isWritable);
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addLocalTimeInformation(isWritable, responseCode, delay, value);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addLocalTimeInformation(originalIsWritable, originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeLocalTimeInformation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> removeLocalTimeInformation() {
                atomicBoolean.set(true);
                return super.removeLocalTimeInformation();
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeLocalTimeInformation());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addReferenceTimeInformation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4};
        final ReferenceTimeInformation referenceTimeInformation = new ReferenceTimeInformation(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addReferenceTimeInformation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addReferenceTimeInformation(responseCode, delay, value);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addReferenceTimeInformation(referenceTimeInformation));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addReferenceTimeInformation_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final byte[] originalValue = new byte[]{1, 2, 3, 4};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addReferenceTimeInformation(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addReferenceTimeInformation(responseCode, delay, value);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addReferenceTimeInformation(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addReferenceTimeInformation_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 0;
        final long originalDelay = 1;
        final byte[] originalValue = new byte[]{2, 3, 4, 5};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> addReferenceTimeInformation(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addReferenceTimeInformation(responseCode, delay, value);
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addReferenceTimeInformation(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeReferenceTimeInformation_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback>() {

            @NonNull
            @Override
            public CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> removeReferenceTimeInformation() {
                atomicBoolean.set(true);
                return super.removeReferenceTimeInformation();
            }
        };
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeReferenceTimeInformation());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTimeWithDst_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        final TimeWithDst timeWithDst = new TimeWithDst(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback>() {
            @NonNull
            @Override
            public NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> addTimeWithDst(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTimeWithDst(responseCode, delay, value);
            }
        };
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTimeWithDst(timeWithDst));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTimeWithDst_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback>() {
            @NonNull
            @Override
            public NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> addTimeWithDst(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTimeWithDst(responseCode, delay, value);
            }
        };
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTimeWithDst(originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTimeWithDst_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final int originalResponseCode = 0;
        final long originalDelay = 1;
        final byte[] originalValue = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback>() {
            @NonNull
            @Override
            public NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> addTimeWithDst(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTimeWithDst(responseCode, delay, value);
            }
        };
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTimeWithDst(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTimeWithDst_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback>() {
            @NonNull
            @Override
            public NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> removeTimeWithDst() {
                atomicBoolean.set(true);
                return super.removeTimeWithDst();
            }
        };
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeTimeWithDst());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTimeUpdateControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[]{TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE};
        final TimeUpdateControlPoint timeWithDst = new TimeUpdateControlPoint(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback>() {
            @NonNull
            @Override
            public ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> addTimeUpdateControlPoint(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTimeUpdateControlPoint(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTimeUpdateControlPoint(timeWithDst));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTimeUpdateControlPoint_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final int originalResponseCode = 0;
        final long originalDelay = 1;
        final byte[] originalValue = new byte[]{TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback>() {
            @NonNull
            @Override
            public ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> addTimeUpdateControlPoint(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTimeUpdateControlPoint(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTimeUpdateControlPoint(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTimeUpdateControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback>() {
            @NonNull
            @Override
            public ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> removeTimeUpdateControlPoint() {
                atomicBoolean.set(true);
                return super.removeTimeUpdateControlPoint();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeTimeUpdateControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTimeUpdateState_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final byte[] originalValue = new byte[]{TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_CANCELED};
        final TimeUpdateState timeWithDst = new TimeUpdateState(originalValue);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback>() {
            @NonNull
            @Override
            public ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> addTimeUpdateState(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTimeUpdateState(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTimeUpdateState(timeWithDst));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addTimeUpdateState_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final int originalResponseCode = 0;
        final long originalDelay = 1;
        final byte[] originalValue = new byte[]{TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_CANCELED};

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback>() {
            @NonNull
            @Override
            public ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> addTimeUpdateState(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(originalValue, value);
                atomicBoolean.set(true);
                return super.addTimeUpdateState(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addTimeUpdateState(originalResponseCode, originalDelay, originalValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeTimeUpdateState_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        CurrentTimeServiceMockCallback.Builder<CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder = new CurrentTimeServiceMockCallback.Builder<>();
        NextDstChangeServiceMockCallback.Builder<NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder = new NextDstChangeServiceMockCallback.Builder<>();
        ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder = new ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback>() {
            @NonNull
            @Override
            public ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> removeTimeUpdateControlPoint() {
                atomicBoolean.set(true);
                return super.removeTimeUpdateControlPoint();
            }

            @NonNull
            @Override
            public ReferenceTimeUpdateServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback> removeTimeUpdateState() {
                atomicBoolean.set(true);
                return super.removeTimeUpdateState();
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context
                , currentTimeServiceMockCallbackBuilder
                , nextDstChangeServiceMockCallbackBuilder
                , referenceTimeUpdateServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeTimeUpdateState());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , new NextDstChangeServiceMockCallback.Builder<>()
                    , new ReferenceTimeUpdateServiceMockCallback.Builder<>())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Current Time data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , new NextDstChangeServiceMockCallback.Builder<>()
                    , new ReferenceTimeUpdateServiceMockCallback.Builder<>())
                    .addCurrentTime(new CurrentTime(new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time with DST data", exception.getMessage());
    }

    @Test
    public void test_build_00003() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , new NextDstChangeServiceMockCallback.Builder<>()
                    , new ReferenceTimeUpdateServiceMockCallback.Builder<>())
                    .addCurrentTime(new CurrentTime(new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addTimeWithDst(new TimeWithDst(new byte[]{1, 2, 3, 4, 5, 6, 7, 8}))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time Update Control Point data", exception.getMessage());
    }

    @Test
    public void test_build_00004() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , new NextDstChangeServiceMockCallback.Builder<>()
                    , new ReferenceTimeUpdateServiceMockCallback.Builder<>())
                    .addCurrentTime(new CurrentTime(new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addTimeWithDst(new TimeWithDst(new byte[]{1, 2, 3, 4, 5, 6, 7, 8}))
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time Update State data", exception.getMessage());
    }

    @Test
    public void test_build_00005() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , new NextDstChangeServiceMockCallback.Builder<>()
                    , new ReferenceTimeUpdateServiceMockCallback.Builder<>())
                    .addCurrentTime(new CurrentTime(new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addTimeWithDst(new TimeWithDst(new byte[]{1, 2, 3, 4, 5, 6, 7, 8}))
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .addTimeUpdateState(new TimeUpdateState(new byte[]{TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_CANCELED}))
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
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , null
                    , new ReferenceTimeUpdateServiceMockCallback.Builder<>())
                    .addCurrentTime(new CurrentTime(new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time Update Control Point data", exception.getMessage());
    }

    @Test
    public void test_build_00201() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , new NextDstChangeServiceMockCallback.Builder<>()
                    , null)
                    .addCurrentTime(new CurrentTime(new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addTimeWithDst(new TimeWithDst(new byte[]{1, 2, 3, 4, 5, 6, 7, 8}))
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
                    , new CurrentTimeServiceMockCallback.Builder<>()
                    , null
                    , null)
                    .addCurrentTime(new CurrentTime(new byte[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

}
