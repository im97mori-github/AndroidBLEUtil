package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.profile.central.db.BaseBondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BondStateReceiverTest {

    @Test
    @RequiresDevice
    public void test_onReceive_00001() {
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {
            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED + "1");
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00101() {
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {
            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00102() {
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {
            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }
        };
        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, BLETestUtilsAndroid.MOCK_DEVICE_1);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00201() {
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {
            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, BLETestUtilsAndroid.MOCK_DEVICE_0);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00202() {
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {
            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, BLETestUtilsAndroid.MOCK_DEVICE_0);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        intent.putExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_NONE);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00203() {
        final AtomicReference<BluetoothDevice> atomicReference = new AtomicReference<>(null);
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                atomicReference.set(bluetoothDevice);
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, BLETestUtilsAndroid.MOCK_DEVICE_0);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        intent.putExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_BONDING);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, atomicReference.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00204() {
        final AtomicReference<BluetoothDevice> atomicReference = new AtomicReference<>(null);
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                atomicReference.set(bluetoothDevice);
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, BLETestUtilsAndroid.MOCK_DEVICE_0);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        intent.putExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_BONDED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, atomicReference.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00301() {
        final AtomicReference<BluetoothDevice> atomicReference = new AtomicReference<>(null);
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {

            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                atomicReference.set(bluetoothDevice);
                result.set(true);
            }

        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, BLETestUtilsAndroid.MOCK_DEVICE_0);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_BONDED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, atomicReference.get());
    }

    @Test
    @RequiresDevice
    public void test_onReceive_00302() {
        final AtomicReference<BluetoothDevice> atomicReference1 = new AtomicReference<>(null);
        final AtomicReference<BluetoothDevice> atomicReference2 = new AtomicReference<>(null);
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {

            @Override
            public BondedDeviceDatabaseHelper getDatabaseHelper() {
                return new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext()) {
                    @Override
                    public synchronized long addHistory(@NonNull BluetoothDevice bluetoothDevice) {
                        atomicReference2.set(bluetoothDevice);
                        return -1;
                    }
                };
            }

            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                atomicReference1.set(bluetoothDevice);
                result.set(true);
            }

        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, BLETestUtilsAndroid.MOCK_DEVICE_0);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, BLETestUtilsAndroid.MOCK_DEVICE_0);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_BONDED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, atomicReference1.get());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, atomicReference2.get());
    }

}
