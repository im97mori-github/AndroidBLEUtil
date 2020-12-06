package org.im97mori.ble.profile.peripheral;

import android.bluetooth.le.AdvertiseSettings;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEServerConnection;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractProfileMockCallbackTest {

    @Test
    public void test_constructor_00001() {
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void setup(@NonNull BLEServerConnection bleServerConnection) {
                result.set(true);
            }
        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        assertFalse(profileMockCallback.isStarted());
        assertFalse(baseBLEServerCallback1.result.get());
    }

    @Test
    public void test_constructor_00002() {
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void setup(@NonNull BLEServerConnection bleServerConnection) {
                result.set(true);
            }
        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        profileMockCallback.start();

        assertTrue(profileMockCallback.isStarted());
        assertTrue(baseBLEServerCallback1.result.get());

        profileMockCallback.quit();
    }

    @Test
    public void test_getServiceUUID_00001() {
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, new BaseBLEServerCallback());
        assertEquals(ProfileMockCallback.SERVICE_UUID, profileMockCallback.getServiceUUID());
    }

    @Test
    public void test_start_00001() {
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, new BaseBLEServerCallback());
        assertFalse(profileMockCallback.isStarted());
    }

    @Test
    public void test_start_00002() {
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, new BaseBLEServerCallback());
        profileMockCallback.start();
        assertTrue(profileMockCallback.isStarted());
        profileMockCallback.quit();
    }

    @Test
    public void test_startAdvertising_00001() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        assertFalse(profileMockCallback.startAdvertising());

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(baseBLEServerCallback1.result.get());
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00002() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        assertTrue(profileMockCallback.startAdvertising());

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertTrue(baseBLEServerCallback1.result.get());
        assertTrue(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00003() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        assertTrue(profileMockCallback.startAdvertising());

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising());
        assertTrue(baseBLEServerCallback1.result.get());
        assertTrue(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00004() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        profileMockCallback.start();

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising());
        assertTrue(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00005() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        profileMockCallback.start();

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising());
        assertFalse(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00101() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        assertFalse(profileMockCallback.startAdvertising(true));

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(baseBLEServerCallback1.result.get());
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00102() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        assertTrue(profileMockCallback.startAdvertising(true));

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertTrue(baseBLEServerCallback1.result.get());
        assertTrue(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00103() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        assertTrue(profileMockCallback.startAdvertising(true));

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising(true));
        assertTrue(baseBLEServerCallback1.result.get());
        assertTrue(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00104() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        profileMockCallback.start();

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising(true));
        assertTrue(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00105() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        profileMockCallback.start();

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising(true));
        assertFalse(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00201() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        assertFalse(profileMockCallback.startAdvertising(false));

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(baseBLEServerCallback1.result.get());
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00202() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        assertTrue(profileMockCallback.startAdvertising(false));

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertTrue(baseBLEServerCallback1.result.get());
        assertTrue(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00203() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        assertTrue(profileMockCallback.startAdvertising(false));

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising(false));
        assertTrue(baseBLEServerCallback1.result.get());
        assertTrue(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00204() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };

        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        profileMockCallback.start();

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising(false));
        assertTrue(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_startAdvertising_00205() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        profileMockCallback.start();

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertFalse(profileMockCallback.startAdvertising(false));
        assertFalse(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_quit_00001() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onServerStopped() {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        profileMockCallback.start();
        profileMockCallback.quit();

        countDownLatch.await(10, TimeUnit.SECONDS);

        assertTrue(baseBLEServerCallback1.result.get());
    }

    @Test
    public void test_stopAdvertising_00001() {
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, new BaseBLEServerCallback());
        assertFalse(profileMockCallback.stopAdvertising());
    }

    @Test
    public void test_stopAdvertising_00002() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingFinished() {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        assertFalse(profileMockCallback.stopAdvertising());
        assertFalse(baseBLEServerCallback1.result.get());
    }

    @Test
    public void test_stopAdvertising_00003() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingFinished() {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        profileMockCallback.start();
        assertFalse(profileMockCallback.stopAdvertising());
        countDownLatch.await(10, TimeUnit.SECONDS);
        assertFalse(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
    }

    @Test
    public void test_stopAdvertising_00004() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingFinished() {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, baseBLEServerCallback1);
        assertFalse(profileMockCallback.startAdvertising());
        assertFalse(profileMockCallback.stopAdvertising());
        countDownLatch.await(10, TimeUnit.SECONDS);
        assertFalse(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
    }

    @Test
    public void test_stopAdvertising_00005() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingFinished() {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        profileMockCallback.start();
        assertTrue(profileMockCallback.stopAdvertising());
        countDownLatch.await(10, TimeUnit.SECONDS);
        assertTrue(baseBLEServerCallback1.result.get());
        profileMockCallback.quit();
    }

    @Test
    public void test_stopAdvertising_00006() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        BaseBLEServerCallback baseBLEServerCallback1 = new BaseBLEServerCallback() {
            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                countDownLatch.countDown();
            }

            @Override
            public void onAdvertisingFinished() {
                result.set(true);
                countDownLatch.countDown();
            }

        };
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), true, baseBLEServerCallback1);
        assertTrue(profileMockCallback.startAdvertising());
        assertTrue(profileMockCallback.stopAdvertising());
        countDownLatch.await(10, TimeUnit.SECONDS);
        assertTrue(baseBLEServerCallback1.result.get());
    }

    @Test
    public void test_isStarted_00001() {
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, new BaseBLEServerCallback());
        assertFalse(profileMockCallback.isStarted());
    }

    @Test
    public void test_isStarted_00002() {
        ProfileMockCallback profileMockCallback = new ProfileMockCallback(ApplicationProvider.getApplicationContext(), false, new BaseBLEServerCallback());
        profileMockCallback.start();
        assertTrue(profileMockCallback.isStarted());
        profileMockCallback.quit();
    }
}
