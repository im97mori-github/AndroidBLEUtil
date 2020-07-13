package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.profile.central.db.BaseBondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BondStateReceiverTest {

    @Test
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

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED + "1");
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
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

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
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

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress1 = "00:11:22:33:AA:BB";
        String macAddress2 = "00:11:22:33:AA:CC";
        BluetoothDevice bluetoothDevice1 = bluetoothAdapter.getRemoteDevice(macAddress1);
        BluetoothDevice bluetoothDevice2 = bluetoothAdapter.getRemoteDevice(macAddress2);

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice1);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, bluetoothDevice2);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
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

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
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

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        intent.putExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_NONE);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertFalse(baseAbstractCentralProfile.result.get());
    }

    @Test
    public void test_onReceive_00203() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        final AtomicReference<BluetoothDevice> atomicReference = new AtomicReference<>(null);
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                atomicReference.set(bluetoothDevice);
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        intent.putExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_BONDING);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(bluetoothDevice, atomicReference.get());
    }

    @Test
    public void test_onReceive_00204() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        final AtomicReference<BluetoothDevice> atomicReference = new AtomicReference<>(null);
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {

            @Override
            public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
                atomicReference.set(bluetoothDevice);
                result.set(true);
            }
        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE);
        intent.putExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_BONDED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(bluetoothDevice, atomicReference.get());
    }

    @Test
    public void test_onReceive_00301() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        final AtomicReference<BluetoothDevice> atomicReference = new AtomicReference<>(null);
        BaseProfileCallback baseProfileCallback = new BaseProfileCallback();
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), baseProfileCallback) {

            @Override
            public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
                atomicReference.set(bluetoothDevice);
                result.set(true);
            }

        };

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_BONDED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(bluetoothDevice, atomicReference.get());
    }

    @Test
    public void test_onReceive_00302() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
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

        BondStateReceiver bondStateReceiver = new BondStateReceiver(baseAbstractCentralProfile, bluetoothDevice);

        Intent intent = new Intent(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_BONDED);
        bondStateReceiver.onReceive(ApplicationProvider.getApplicationContext(), intent);
        assertTrue(baseAbstractCentralProfile.result.get());
        assertEquals(bluetoothDevice, atomicReference1.get());
        assertEquals(bluetoothDevice, atomicReference2.get());
    }

}
