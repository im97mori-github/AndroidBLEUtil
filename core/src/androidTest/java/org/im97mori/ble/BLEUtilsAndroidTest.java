package org.im97mori.ble;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BLEUtilsAndroidTest {

    @Test
    public void test_isBluetoothEnabled_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        final AtomicReference<Boolean> result = new AtomicReference<>(null);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
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
                        result.set(BLEUtilsAndroid.isBluetoothEnabled());
                        countDownLatch.countDown();
                    }
                }

            };
            context.registerReceiver(broadcastReceiver, intentFilter);
            assertTrue(bluetoothAdapter.disable());

            try {
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
                    result.set(BLEUtilsAndroid.isBluetoothEnabled());
                    countDownLatch.countDown();
                }
            }

        };
        context.registerReceiver(broadcastReceiver, intentFilter);
        assertTrue(bluetoothAdapter.enable());

        try {
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
    public void test_isBluetoothEnabled_00002() {
        Context context = ApplicationProvider.getApplicationContext();
        final AtomicReference<Boolean> result = new AtomicReference<>(null);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
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
                        result.set(BLEUtilsAndroid.isBluetoothEnabled());
                        countDownLatch.countDown();
                    }
                }

            };
            context.registerReceiver(broadcastReceiver, intentFilter);
            assertTrue(bluetoothAdapter.enable());

            try {
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
                    result.set(BLEUtilsAndroid.isBluetoothEnabled());
                    countDownLatch.countDown();
                }
            }

        };
        context.registerReceiver(broadcastReceiver, intentFilter);
        assertTrue(bluetoothAdapter.disable());

        try {
            countDownLatch.await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        context.unregisterReceiver(broadcastReceiver);

        Boolean value = result.get();
        assertNotNull(value);
        assertFalse(value);
    }

    @Test
    public void test_bluetoothEnable_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        final AtomicReference<Boolean> result = new AtomicReference<>(null);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
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
                        result.set(BLEUtilsAndroid.isBluetoothEnabled());
                        countDownLatch.countDown();
                    }
                }

            };
            context.registerReceiver(broadcastReceiver, intentFilter);
            assertTrue(BLEUtilsAndroid.bluetoothDisable());

            try {
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
                    result.set(BLEUtilsAndroid.isBluetoothEnabled());
                    countDownLatch.countDown();
                }
            }

        };
        context.registerReceiver(broadcastReceiver, intentFilter);
        assertTrue(BLEUtilsAndroid.bluetoothEnable());

        try {
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
    public void test_bluetoothDisable_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        final AtomicReference<Boolean> result = new AtomicReference<>(null);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
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
                        result.set(BLEUtilsAndroid.isBluetoothEnabled());
                        countDownLatch.countDown();
                    }
                }

            };
            context.registerReceiver(broadcastReceiver, intentFilter);
            assertTrue(BLEUtilsAndroid.bluetoothEnable());

            try {
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
                    result.set(BLEUtilsAndroid.isBluetoothEnabled());
                    countDownLatch.countDown();
                }
            }

        };
        context.registerReceiver(broadcastReceiver, intentFilter);
        assertTrue(BLEUtilsAndroid.bluetoothDisable());

        try {
            countDownLatch.await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        context.unregisterReceiver(broadcastReceiver);

        Boolean value = result.get();
        assertNotNull(value);
        assertFalse(value);
    }

}
