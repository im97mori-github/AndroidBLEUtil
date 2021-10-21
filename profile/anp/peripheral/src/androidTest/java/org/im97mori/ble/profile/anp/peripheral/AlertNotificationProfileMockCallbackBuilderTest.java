package org.im97mori.ble.profile.anp.peripheral;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a47.SupportedNewAlertCategory;
import org.im97mori.ble.characteristic.u2a48.SupportedUnreadAlertCategory;
import org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class AlertNotificationProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(alertNotificationServiceMockCallbackBuilder, baseBuilder.mAlertNotificationServiceMockCallbackBuilder);
    }

    @Test
    public void test_addSupportedNewAlertCategory_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SupportedNewAlertCategory supportedNewAlertCategory = new SupportedNewAlertCategory(0, false, 0);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addSupportedNewAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedNewAlertCategory.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedNewAlertCategory(responseCode, delay, value);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedNewAlertCategory(supportedNewAlertCategory));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedNewAlertCategory_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SupportedNewAlertCategory supportedNewAlertCategory = new SupportedNewAlertCategory(0, false, 0);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addSupportedNewAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedNewAlertCategory.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedNewAlertCategory(responseCode, delay, value);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedNewAlertCategory(supportedNewAlertCategory.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedNewAlertCategory_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final SupportedNewAlertCategory supportedNewAlertCategory = new SupportedNewAlertCategory(0, false, 0);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addSupportedNewAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(supportedNewAlertCategory.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedNewAlertCategory(responseCode, delay, value);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedNewAlertCategory(originalResponseCode, originalDelay, supportedNewAlertCategory.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSupportedNewAlertCategory_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> removeSupportedNewAlertCategory() {
                atomicBoolean.set(true);
                return super.removeSupportedNewAlertCategory();
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSupportedNewAlertCategory());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addNewAlert_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalSimpleAlertNumberOfNewAlert = 1;
        final String originalSimpleAlertTextStringInformation = "a";
        final int originalEmailNumberOfNewAlert = 2;
        final String originalEmailTextStringInformation = "b";
        final int originalNewsNumberOfNewAlert = 3;
        final String originalNewsTextStringInformation = "c";
        final int originalCallNumberOfNewAlert = 4;
        final String originalCallTextStringInformation = "d";
        final int originalMissedCallNumberOfNewAlert = 5;
        final String originalMissedCallTextStringInformation = "e";
        final int originalSmsMmsNumberOfNewAlert = 6;
        final String originalSmsMmsTextStringInformation = "f";
        final int originalVoiceMailNumberOfNewAlert = 7;
        final String originalVoiceMailTextStringInformation = "g";
        final int originalScheduleNumberOfNewAlert = 8;
        final String originalScheduleTextStringInformation = "h";
        final int originalHighPrioritizedAlertNumberOfNewAlert = 9;
        final String originalHighPrioritizedAlertTextStringInformation = "i";
        final int originalInstantMessageAlertNumberOfNewAlert = 10;
        final String originalInstantMessageTextStringInformation = "j";
        final int originalDescriptorResponseCode = 11;
        final int originalDescriptorDelay = 12;
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addNewAlert(int simpleAlertNumberOfNewAlert
                    , @Nullable String simpleAlertTextStringInformation
                    , int emailNumberOfNewAlert
                    , @Nullable String emailTextStringInformation
                    , int newsNumberOfNewAlert
                    , @Nullable String newsTextStringInformation
                    , int callNumberOfNewAlert
                    , @Nullable String callTextStringInformation
                    , int missedCallNumberOfNewAlert
                    , @Nullable String missedCallTextStringInformation
                    , int smsMmsNumberOfNewAlert
                    , @Nullable String smsMmsTextStringInformation
                    , int voiceMailNumberOfNewAlert
                    , @Nullable String voiceMailTextStringInformation
                    , int scheduleNumberOfNewAlert
                    , @Nullable String scheduleTextStringInformation
                    , int highPrioritizedAlertNumberOfNewAlert
                    , @Nullable String highPrioritizedAlertTextStringInformation
                    , int instantMessageAlertNumberOfNewAlert
                    , @Nullable String instantMessageTextStringInformation
                    , int descriptorResponseCode
                    , long descriptorDelay
                    , @NonNull byte[] descriptorValue) {
                assertEquals(originalSimpleAlertNumberOfNewAlert, simpleAlertNumberOfNewAlert);
                assertEquals(originalSimpleAlertTextStringInformation, simpleAlertTextStringInformation);
                assertEquals(originalEmailNumberOfNewAlert, emailNumberOfNewAlert);
                assertEquals(originalEmailTextStringInformation, emailTextStringInformation);
                assertEquals(originalNewsNumberOfNewAlert, newsNumberOfNewAlert);
                assertEquals(originalNewsTextStringInformation, newsTextStringInformation);
                assertEquals(originalCallNumberOfNewAlert, callNumberOfNewAlert);
                assertEquals(originalCallTextStringInformation, callTextStringInformation);
                assertEquals(originalMissedCallNumberOfNewAlert, missedCallNumberOfNewAlert);
                assertEquals(originalMissedCallTextStringInformation, missedCallTextStringInformation);
                assertEquals(originalSmsMmsNumberOfNewAlert, smsMmsNumberOfNewAlert);
                assertEquals(originalSmsMmsTextStringInformation, smsMmsTextStringInformation);
                assertEquals(originalVoiceMailNumberOfNewAlert, voiceMailNumberOfNewAlert);
                assertEquals(originalVoiceMailTextStringInformation, voiceMailTextStringInformation);
                assertEquals(originalScheduleNumberOfNewAlert, scheduleNumberOfNewAlert);
                assertEquals(originalScheduleTextStringInformation, scheduleTextStringInformation);
                assertEquals(originalHighPrioritizedAlertNumberOfNewAlert, highPrioritizedAlertNumberOfNewAlert);
                assertEquals(originalHighPrioritizedAlertTextStringInformation, highPrioritizedAlertTextStringInformation);
                assertEquals(originalInstantMessageAlertNumberOfNewAlert, instantMessageAlertNumberOfNewAlert);
                assertEquals(originalInstantMessageTextStringInformation, instantMessageTextStringInformation);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addNewAlert(simpleAlertNumberOfNewAlert, simpleAlertTextStringInformation, emailNumberOfNewAlert, emailTextStringInformation, newsNumberOfNewAlert, newsTextStringInformation, callNumberOfNewAlert, callTextStringInformation, missedCallNumberOfNewAlert, missedCallTextStringInformation, smsMmsNumberOfNewAlert, smsMmsTextStringInformation, voiceMailNumberOfNewAlert, voiceMailTextStringInformation, scheduleNumberOfNewAlert, scheduleTextStringInformation, highPrioritizedAlertNumberOfNewAlert, highPrioritizedAlertTextStringInformation, instantMessageAlertNumberOfNewAlert, instantMessageTextStringInformation, descriptorResponseCode, descriptorDelay, descriptorValue);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addNewAlert(originalSimpleAlertNumberOfNewAlert
                , originalSimpleAlertTextStringInformation
                , originalEmailNumberOfNewAlert
                , originalEmailTextStringInformation
                , originalNewsNumberOfNewAlert
                , originalNewsTextStringInformation
                , originalCallNumberOfNewAlert
                , originalCallTextStringInformation
                , originalMissedCallNumberOfNewAlert
                , originalMissedCallTextStringInformation
                , originalSmsMmsNumberOfNewAlert
                , originalSmsMmsTextStringInformation
                , originalVoiceMailNumberOfNewAlert
                , originalVoiceMailTextStringInformation
                , originalScheduleNumberOfNewAlert
                , originalScheduleTextStringInformation
                , originalHighPrioritizedAlertNumberOfNewAlert
                , originalHighPrioritizedAlertTextStringInformation
                , originalInstantMessageAlertNumberOfNewAlert
                , originalInstantMessageTextStringInformation
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeNewAlert_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> removeNewAlert() {
                atomicBoolean.set(true);
                return super.removeNewAlert();
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeNewAlert());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedUnreadAlertCategory_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SupportedUnreadAlertCategory supportedUnreadAlertCategory = new SupportedUnreadAlertCategory(0, false, 0);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addSupportedUnreadAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedUnreadAlertCategory.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedNewAlertCategory(responseCode, delay, value);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedUnreadAlertCategory(supportedUnreadAlertCategory));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedUnreadAlertCategory_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SupportedUnreadAlertCategory supportedUnreadAlertCategory = new SupportedUnreadAlertCategory(0, false, 0);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addSupportedUnreadAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(supportedUnreadAlertCategory.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedNewAlertCategory(responseCode, delay, value);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedUnreadAlertCategory(supportedUnreadAlertCategory.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addSupportedUnreadAlertCategory_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final SupportedUnreadAlertCategory supportedUnreadAlertCategory = new SupportedUnreadAlertCategory(0, false, 0);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addSupportedUnreadAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(supportedUnreadAlertCategory.getBytes(), value);
                atomicBoolean.set(true);
                return super.addSupportedNewAlertCategory(responseCode, delay, value);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addSupportedUnreadAlertCategory(originalResponseCode, originalDelay, supportedUnreadAlertCategory.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeSupportedUnreadAlertCategory_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> removeSupportedUnreadAlertCategory() {
                atomicBoolean.set(true);
                return super.removeNewAlert();
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeSupportedUnreadAlertCategory());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addUnreadAlertStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalSimpleAlertUnreadCount = 1;
        final int originalEmailUnreadCount = 2;
        final int originalNewsUnreadCount = 3;
        final int originalCallUnreadCount = 4;
        final int originalMissedCallUnreadCount = 5;
        final int originalSmsMmsUnreadCount = 6;
        final int originalVoiceMailUnreadCount = 7;
        final int originalScheduleUnreadCount = 8;
        final int originalHighPrioritizedAlertUnreadCount = 9;
        final int originalInstantMessageAlertUnreadCount = 10;
        final int originalDescriptorResponseCode = 11;
        final int originalDescriptorDelay = 12;
        final byte[] originalDescriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addUnreadAlertStatus(int simpleAlertUnreadCount
                    , int emailUnreadCount
                    , int newsUnreadCount
                    , int callUnreadCount
                    , int missedCallUnreadCount
                    , int smsMmsUnreadCount
                    , int voiceMailUnreadCount
                    , int scheduleUnreadCount
                    , int highPrioritizedAlertUnreadCount
                    , int instantMessageAlertUnreadCount
                    , int descriptorResponseCode
                    , long descriptorDelay
                    , @NonNull byte[] descriptorValue) {
                assertEquals(originalSimpleAlertUnreadCount, simpleAlertUnreadCount);
                assertEquals(originalEmailUnreadCount, emailUnreadCount);
                assertEquals(originalNewsUnreadCount, newsUnreadCount);
                assertEquals(originalCallUnreadCount, callUnreadCount);
                assertEquals(originalMissedCallUnreadCount, missedCallUnreadCount);
                assertEquals(originalSmsMmsUnreadCount, smsMmsUnreadCount);
                assertEquals(originalVoiceMailUnreadCount, voiceMailUnreadCount);
                assertEquals(originalScheduleUnreadCount, scheduleUnreadCount);
                assertEquals(originalHighPrioritizedAlertUnreadCount, highPrioritizedAlertUnreadCount);
                assertEquals(originalInstantMessageAlertUnreadCount, instantMessageAlertUnreadCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                atomicBoolean.set(true);
                return super.addUnreadAlertStatus(simpleAlertUnreadCount, emailUnreadCount, newsUnreadCount, callUnreadCount, missedCallUnreadCount, smsMmsUnreadCount, voiceMailUnreadCount, scheduleUnreadCount, highPrioritizedAlertUnreadCount, instantMessageAlertUnreadCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addUnreadAlertStatus(originalSimpleAlertUnreadCount
                , originalEmailUnreadCount
                , originalNewsUnreadCount
                , originalCallUnreadCount
                , originalMissedCallUnreadCount
                , originalSmsMmsUnreadCount
                , originalVoiceMailUnreadCount
                , originalScheduleUnreadCount
                , originalHighPrioritizedAlertUnreadCount
                , originalInstantMessageAlertUnreadCount
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , originalDescriptorValue));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeUnreadAlertStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> removeUnreadAlertStatus() {
                atomicBoolean.set(true);
                return super.removeNewAlert();
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeUnreadAlertStatus());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAlertNotificationControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalEnableNewAlertNotificationResponseValue = 1;
        final int originalEnableUnreadAlertStatusNotificationResponseValue = 2;
        final int originalDisableNewAlertNotificationResponseValue = 3;
        final int originalDisableUnreadAlertStatusNotificationResponseValue = 4;
        final int originalNotifyNewAlertImmediatelyResponseValue = 5;
        final int originalNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        final long originalDelay = 7;

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> addAlertNotificationControlPoint(int enableNewAlertNotificationResponseValue, int enableUnreadAlertStatusNotificationResponseValue, int disableNewAlertNotificationResponseValue, int disableUnreadAlertStatusNotificationResponseValue, int notifyNewAlertImmediatelyResponseValue, int notifyUnreadAlertStatusImmediatelyResponseValue, long delay) {
                assertEquals(originalEnableNewAlertNotificationResponseValue, enableNewAlertNotificationResponseValue);
                assertEquals(originalEnableUnreadAlertStatusNotificationResponseValue, enableUnreadAlertStatusNotificationResponseValue);
                assertEquals(originalDisableNewAlertNotificationResponseValue, disableNewAlertNotificationResponseValue);
                assertEquals(originalDisableUnreadAlertStatusNotificationResponseValue, disableUnreadAlertStatusNotificationResponseValue);
                assertEquals(originalNotifyNewAlertImmediatelyResponseValue, notifyNewAlertImmediatelyResponseValue);
                assertEquals(originalNotifyUnreadAlertStatusImmediatelyResponseValue, notifyUnreadAlertStatusImmediatelyResponseValue);
                assertEquals(originalDelay, delay);
                atomicBoolean.set(true);
                return super.addAlertNotificationControlPoint(enableNewAlertNotificationResponseValue, enableUnreadAlertStatusNotificationResponseValue, disableNewAlertNotificationResponseValue, disableUnreadAlertStatusNotificationResponseValue, notifyNewAlertImmediatelyResponseValue, notifyUnreadAlertStatusImmediatelyResponseValue, delay);
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAlertNotificationControlPoint(originalEnableNewAlertNotificationResponseValue
                , originalEnableUnreadAlertStatusNotificationResponseValue
                , originalDisableNewAlertNotificationResponseValue
                , originalDisableUnreadAlertStatusNotificationResponseValue
                , originalNotifyNewAlertImmediatelyResponseValue
                , originalNotifyUnreadAlertStatusImmediatelyResponseValue
                , originalDelay
        ));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeAlertNotificationControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder = new AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback>() {

            @NonNull
            @Override
            public AlertNotificationServiceMockCallback.Builder<AlertNotificationServiceMockCallback> removeAlertNotificationControlPoint() {
                atomicBoolean.set(true);
                return super.removeNewAlert();
            }


        };
        BaseBuilder baseBuilder = new BaseBuilder(context, alertNotificationServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAlertNotificationControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new AlertNotificationServiceMockCallback.Builder<>())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported New Alert Category data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new AlertNotificationServiceMockCallback.Builder<>())
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no New Alert data", exception.getMessage());
    }

    @Test
    public void test_build_00003() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new AlertNotificationServiceMockCallback.Builder<>())
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Unread Alert Category data", exception.getMessage());
    }

    @Test
    public void test_build_00004() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new AlertNotificationServiceMockCallback.Builder<>())
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Unread Alert Status data", exception.getMessage());
    }

    @Test
    public void test_build_00005() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new AlertNotificationServiceMockCallback.Builder<>())
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Notification Control Point data", exception.getMessage());
    }

    @Test
    public void test_build_00006() {
        AlertNotificationProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext()
                , new AlertNotificationServiceMockCallback.Builder<>())
                .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0))
                .addNewAlert(0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , ""
                        , 0
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0))
                .addUnreadAlertStatus(0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                .addAlertNotificationControlPoint(0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0)
                .build();

        assertNotNull(callback);
    }

}
