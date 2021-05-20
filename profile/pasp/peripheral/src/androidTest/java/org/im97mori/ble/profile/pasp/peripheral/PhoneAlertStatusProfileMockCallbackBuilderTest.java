package org.im97mori.ble.profile.pasp.peripheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2a3f.AlertStatus;
import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.characteristic.u2a41.RingerSetting;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PhoneAlertStatusProfileMockCallbackBuilderTest {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(phoneAlertStatusServiceMockCallbackBuilder, baseBuilder.mPhoneAlertStatusServiceMockCallback);
    }

    @Test
    public void test_addAlertStatus_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AlertStatus alertStatus = new AlertStatus(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> addAlertStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(alertStatus.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addAlertStatus(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAlertStatus(alertStatus, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addAlertStatus_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalNotificationCount = 40;
        final int originalDescriptorResponseCode = 41;
        final long originalDescriptorDelay = 42;
        final AlertStatus alertStatus = new AlertStatus(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);


        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> addAlertStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(alertStatus.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addAlertStatus(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addAlertStatus(originalCharacteristicResponseCode, originalCharacteristicDelay, alertStatus.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeRSCMeasurement_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> removeAlertStatus() {
                atomicBoolean.set(true);
                return super.removeAlertStatus();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeAlertStatus());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRingerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RingerSetting ringerSetting = new RingerSetting(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> addRingerSetting(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(ringerSetting.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addRingerSetting(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRingerSetting(ringerSetting, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRingerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalNotificationCount = 40;
        final int originalDescriptorResponseCode = 41;
        final long originalDescriptorDelay = 42;
        final RingerSetting ringerSetting = new RingerSetting(new byte[1]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);


        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> addRingerSetting(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(ringerSetting.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                atomicBoolean.set(true);
                return super.addRingerSetting(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRingerSetting(originalCharacteristicResponseCode, originalCharacteristicDelay, ringerSetting.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeRingerSetting_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> removeRingerSetting() {
                atomicBoolean.set(true);
                return super.removeRingerSetting();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeRingerSetting());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRingerControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RingerControlPoint ringerControlPoint = new RingerControlPoint(new byte[1]);

        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> addRingerControlPoint(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(ringerControlPoint.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRingerControlPoint(responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRingerControlPoint(ringerControlPoint));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRingerControlPoint_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final RingerControlPoint ringerControlPoint = new RingerControlPoint(new byte[1]);

        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> addRingerControlPoint(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(ringerControlPoint.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRingerControlPoint(responseCode, delay, value);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRingerControlPoint(originalResponseCode, originalDelay, ringerControlPoint.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeRingerControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallbackBuilder = new PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback>() {

            @NonNull
            @Override
            public PhoneAlertStatusServiceMockCallback.Builder<PhoneAlertStatusServiceMockCallback> removeRingerControlPoint() {
                atomicBoolean.set(true);
                return super.removeRingerControlPoint();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, phoneAlertStatusServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeRingerControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new PhoneAlertStatusServiceMockCallback.Builder<>())
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Status data", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new PhoneAlertStatusServiceMockCallback.Builder<>())
                    .addAlertStatus(new AlertStatus(AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_ACTIVE), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Ringer Setting data", exception.getMessage());
    }

    @Test
    public void test_build_00003() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext()
                    , new PhoneAlertStatusServiceMockCallback.Builder<>())
                    .addAlertStatus(new AlertStatus(AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_ACTIVE), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addRingerSetting(new RingerSetting(RingerSetting.RINGER_SETTING_NORMAL), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Ringer Control point data", exception.getMessage());
    }

    @Test
    public void test_build_00004() {
        PhoneAlertStatusProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext()
                , new PhoneAlertStatusServiceMockCallback.Builder<>())
                .addAlertStatus(new AlertStatus(AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_ACTIVE), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addRingerSetting(new RingerSetting(RingerSetting.RINGER_SETTING_NORMAL), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addRingerControlPoint(new RingerControlPoint(RingerControlPoint.RINGER_CONTROL_POINT_CANCEL_SILENT_MODE))
                .build();

        assertNotNull(callback);
    }

}
