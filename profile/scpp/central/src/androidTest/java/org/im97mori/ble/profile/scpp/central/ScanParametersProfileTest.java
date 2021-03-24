package org.im97mori.ble.profile.scpp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.profile.scpp.central.db.ScanParametersProfileBondedDatabaseHelper;
import org.im97mori.ble.service.scps.central.ScanParametersService;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ScanParametersProfileTest {

    @Test
    public void test_findScanParametersProfileDevices_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        assertNull(scanParametersProfile.findScanParametersProfileDevices(BASE_UUID, null));
    }

    @Test
    public void test_findScanParametersProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        scanParametersProfile.start();
        assertNotNull(scanParametersProfile.findScanParametersProfileDevices(BASE_UUID, bundle));
        assertTrue(atomicBoolean.get());
        scanParametersProfile.quit();
    }

    @Test
    public void test_isScanRefreshCharacteristicSupported_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        assertNull(scanParametersProfile.isScanRefreshCharacteristicSupported());
    }

    @Test
    public void test_isScanRefreshCharacteristicSupported_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null);
                }
            }
        };
        scanParametersProfile.connect(MOCK_DEVICE);
        assertNotNull(scanParametersProfile.isScanRefreshCharacteristicSupported());
        scanParametersProfile.disconnect();
    }

    @Test
    public void test_setScanIntervalWindow_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        assertNull(scanParametersProfile.setScanIntervalWindow(new ScanIntervalWindow(new byte[4])));
    }

    @Test
    public void test_setScanIntervalWindow_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(MOCK_DEVICE);
        assertNotNull(scanParametersProfile.setScanIntervalWindow(new ScanIntervalWindow(new byte[4])));
        scanParametersProfile.disconnect();
    }

    @Test
    public void test_getScanRefreshClientCharacteristicConfiguration_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        assertNull(scanParametersProfile.getScanRefreshClientCharacteristicConfiguration());
    }

    @Test
    public void test_getScanRefreshClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {

                        @Override
                        public boolean isScanRefreshCharacteristicSupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(MOCK_DEVICE);
        assertNotNull(scanParametersProfile.getScanRefreshClientCharacteristicConfiguration());
        scanParametersProfile.disconnect();
    }

    @Test
    public void test_startScanRefreshNotification_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        assertNull(scanParametersProfile.startScanRefreshNotification());
    }

    @Test
    public void test_startScanRefreshNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {

                        @Override
                        public boolean isScanRefreshCharacteristicSupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(MOCK_DEVICE);
        assertNotNull(scanParametersProfile.startScanRefreshNotification());
        scanParametersProfile.disconnect();
    }

    @Test
    public void test_stopScanRefreshNotification_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        assertNull(scanParametersProfile.stopScanRefreshNotification());
    }

    @Test
    public void test_stopScanRefreshNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mScanParametersService == null) {
                    mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null) {

                        @Override
                        public boolean isScanRefreshCharacteristicSupported() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        scanParametersProfile.connect(MOCK_DEVICE);
        assertNotNull(scanParametersProfile.stopScanRefreshNotification());
        scanParametersProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        assertTrue(scanParametersProfile.getDatabaseHelper() instanceof ScanParametersProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        scanParametersProfile.connect(MOCK_DEVICE);
        assertNotNull(scanParametersProfile.mScanParametersService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        ScanParametersProfile scanParametersProfile = new ScanParametersProfile(ApplicationProvider.getApplicationContext(), new BaseScanParametersProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        scanParametersProfile.connect(MOCK_DEVICE);
        scanParametersProfile.quit();
        assertNull(scanParametersProfile.mScanParametersService);
    }

}
