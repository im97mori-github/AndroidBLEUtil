package org.im97mori.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.ParcelUuid;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertEquals;
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

    @Test
    public void test_getDescriptorInstanceId_00001() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        if (Build.VERSION_CODES.N <= Build.VERSION.SDK_INT) {
            assertEquals(0, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
        }
    }

    @Test
    public void test_getDescriptorInstanceId_00002() {
        if (Build.VERSION_CODES.N <= Build.VERSION.SDK_INT) {
            int originalInstanceId = 1;
            Parcel parcel = Parcel.obtain();
            parcel.writeParcelable(new ParcelUuid(BASE_UUID), 0);
            parcel.writeInt(originalInstanceId);
            parcel.writeInt(0);
            parcel.setDataPosition(0);
            BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);
            parcel.recycle();
            assertEquals(originalInstanceId, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
        }
    }

    @Test
    public void test_getDescriptorInstanceId_00101() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        if (Build.VERSION_CODES.N > Build.VERSION.SDK_INT) {
            assertEquals(0, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
        }
    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    @Test
    public void test_getDescriptorInstanceId_00102() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (Build.VERSION_CODES.N > Build.VERSION.SDK_INT) {
            int originalInstanceId = 1;

            Constructor<BluetoothGattDescriptor> clazz = BluetoothGattDescriptor.class.getDeclaredConstructor(BluetoothGattCharacteristic.class, UUID.class, int.class, int.class);
            clazz.setAccessible(true);
            BluetoothGattDescriptor bluetoothGattDescriptor = clazz.newInstance(null, BASE_UUID, originalInstanceId, 2);
            assertEquals(originalInstanceId, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
        }
    }

}
