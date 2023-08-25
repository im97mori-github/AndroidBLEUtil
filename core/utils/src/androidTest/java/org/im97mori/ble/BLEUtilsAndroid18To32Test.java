package org.im97mori.ble;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.junit.AfterClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @noinspection deprecation
 */
@SdkSuppress(minSdkVersion = Build.VERSION_CODES.JELLY_BEAN_MR2, maxSdkVersion = Build.VERSION_CODES.S_V2)
public class BLEUtilsAndroid18To32Test extends BaseBLEUtilsAndroidTest {

    @AfterClass
    public static void afterClass() {
        Context context = ApplicationProvider.getApplicationContext();
        BLEUtilsAndroid.isBluetoothEnabled(context);
    }

    @Test
    @RequiresDevice
    @SuppressWarnings("deprecation")
    public void test_isBluetoothEnabled_00001() {
        super.test_isBluetoothEnabled_00001();
    }

    @Test
    @RequiresDevice
    @SuppressWarnings("deprecation")
    public void test_isBluetoothEnabled_00002() {
        super.test_isBluetoothEnabled_00002();
    }

    @Test
    @RequiresDevice
    @Deprecated
    public void test_bluetoothEnable_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        final AtomicReference<Boolean> result = new AtomicReference<>(null);
        final BluetoothAdapter bluetoothAdapter = ((BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter();
        assertNotNull(bluetoothAdapter);

        if (bluetoothAdapter.isEnabled()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_ON);

                    if (BluetoothAdapter.STATE_OFF == state) {
                        assertFalse(bluetoothAdapter.isEnabled());
                        result.set(BLEUtilsAndroid.isBluetoothEnabled(context));
                        countDownLatch.countDown();
                    }
                }

            };
            context.registerReceiver(broadcastReceiver, intentFilter);
            assertTrue(BLEUtilsAndroid.bluetoothDisable(context));

            try {
                //noinspection ResultOfMethodCallIgnored
                countDownLatch.await(10000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            context.unregisterReceiver(broadcastReceiver);

            Boolean value = result.get();
            assertNotNull(value);
            assertFalse(value);
            result.set(null);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_OFF);

                if (BluetoothAdapter.STATE_ON == state) {
                    assertTrue(bluetoothAdapter.isEnabled());
                    result.set(BLEUtilsAndroid.isBluetoothEnabled(context));
                    countDownLatch.countDown();
                }
            }

        };
        context.registerReceiver(broadcastReceiver, intentFilter);
        assertTrue(BLEUtilsAndroid.bluetoothEnable(context));

        try {
            //noinspection ResultOfMethodCallIgnored
            countDownLatch.await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        context.unregisterReceiver(broadcastReceiver);

        Boolean value = result.get();
        assertNotNull(value);
        assertTrue(value);
    }

    @Test
    @RequiresDevice
    @Deprecated
    public void test_bluetoothDisable_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        final AtomicReference<Boolean> result = new AtomicReference<>(null);
        final BluetoothAdapter bluetoothAdapter = ((BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter();
        assertNotNull(bluetoothAdapter);

        if (!bluetoothAdapter.isEnabled()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_OFF);

                    if (BluetoothAdapter.STATE_ON == state) {
                        assertTrue(bluetoothAdapter.isEnabled());
                        result.set(BLEUtilsAndroid.isBluetoothEnabled(context));
                        countDownLatch.countDown();
                    }
                }

            };
            context.registerReceiver(broadcastReceiver, intentFilter);
            assertTrue(BLEUtilsAndroid.bluetoothEnable(context));

            try {
                //noinspection ResultOfMethodCallIgnored
                countDownLatch.await(10000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            context.unregisterReceiver(broadcastReceiver);

            Boolean value = result.get();
            assertNotNull(value);
            assertTrue(value);
            result.set(null);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_ON);

                if (BluetoothAdapter.STATE_OFF == state) {
                    assertFalse(bluetoothAdapter.isEnabled());
                    result.set(BLEUtilsAndroid.isBluetoothEnabled(context));
                    countDownLatch.countDown();
                }
            }

        };
        context.registerReceiver(broadcastReceiver, intentFilter);
        assertTrue(BLEUtilsAndroid.bluetoothDisable(context));

        try {
            //noinspection ResultOfMethodCallIgnored
            countDownLatch.await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        context.unregisterReceiver(broadcastReceiver);

        Boolean value = result.get();
        assertNotNull(value);
        assertFalse(value);
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.N, maxSdkVersion = Build.VERSION_CODES.S_V2)
    public void test_getDescriptorInstanceId_00001() {
        super.test_getDescriptorInstanceId_00001();
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.N, maxSdkVersion = Build.VERSION_CODES.S_V2)
    public void test_getDescriptorInstanceId_00002() {
        super.test_getDescriptorInstanceId_00002();
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT, maxSdkVersion = Build.VERSION_CODES.M)
    public void test_getDescriptorInstanceId_00101() {
        super.test_getDescriptorInstanceId_00101();
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT, maxSdkVersion = Build.VERSION_CODES.M)
    public void test_getDescriptorInstanceId_00102() throws IllegalAccessException, NoSuchFieldException {
        super.test_getDescriptorInstanceId_00102();
    }

    @Override
    @Test
    @SdkSuppress(maxSdkVersion = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void test_getDescriptorInstanceId_00201() {
        super.test_getDescriptorInstanceId_00201();
    }
}
