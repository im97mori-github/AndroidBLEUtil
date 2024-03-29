package org.im97mori.ble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.ParcelUuid;

import androidx.test.core.app.ApplicationProvider;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

abstract class BaseBLEUtilsAndroidTest {

    /** @noinspection DeprecatedIsStillUsed*/
    @Deprecated
    void test_isBluetoothEnabled_00001() {
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
            assertTrue(bluetoothAdapter.disable());

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
        assertTrue(bluetoothAdapter.enable());

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

    /** @noinspection DeprecatedIsStillUsed*/
    @Deprecated
    void test_isBluetoothEnabled_00002() {
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
            assertTrue(bluetoothAdapter.enable());

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
        assertTrue(bluetoothAdapter.disable());

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

    void test_getDescriptorInstanceId_00001() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BLEUtils.BASE_UUID, 0);
        assertEquals(0, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
    }

    void test_getDescriptorInstanceId_00002() {
        int originalInstanceId = 1;
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BLEUtils.BASE_UUID), 0);
        parcel.writeInt(originalInstanceId);
        parcel.writeInt(0);
        parcel.setDataPosition(0);
        BluetoothGattDescriptor bluetoothGattDescriptor = BluetoothGattDescriptor.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        assertEquals(originalInstanceId, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
    }

    void test_getDescriptorInstanceId_00101() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BLEUtils.BASE_UUID, 0);
        assertEquals(0, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    void test_getDescriptorInstanceId_00102() throws IllegalAccessException, NoSuchFieldException {
        int originalInstanceId = 1;

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BLEUtils.BASE_UUID, 2);
        Field field = BluetoothGattDescriptor.class.getDeclaredField("mInstance");
        field.setAccessible(true);
        field.set(bluetoothGattDescriptor, originalInstanceId);
        assertEquals(originalInstanceId, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
    }

    void test_getDescriptorInstanceId_00201() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BLEUtils.BASE_UUID, 0);
        assertEquals(0, BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor));
    }

}
