package org.im97mori.ble.profile.pasp.central;

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
import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.profile.pasp.central.db.PhoneAlertStatusProfileBondedDatabaseHelper;
import org.im97mori.ble.service.pass.central.PhoneAlertStatusService;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PhoneAlertStatusProfileTest {

    @Test
    public void test_findPhoneAlertStatusProfileDevices_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.findPhoneAlertStatusProfileDevices(null));
    }

    @Test
    public void test_findPhoneAlertStatusProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        phoneAlertStatusProfile.start();
        assertNotNull(phoneAlertStatusProfile.findPhoneAlertStatusProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        phoneAlertStatusProfile.quit();
    }

    @Test
    public void test_getAlertStatus_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getAlertStatus());
    }

    @Test
    public void test_getAlertStatus_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.getAlertStatus());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_getAlertStatusClientCharacteristicConfiguration_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getAlertStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getAlertStatusClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.getAlertStatusClientCharacteristicConfiguration());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_startAlertStatusNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.startAlertStatusNotification());
    }

    @Test
    public void test_startAlertStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.startAlertStatusNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_stopAlertStatusNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.stopAlertStatusNotification());
    }

    @Test
    public void test_stopAlertStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.stopAlertStatusNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_getRingerSetting_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getRingerSetting());
    }

    @Test
    public void test_getRingerSetting_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.getRingerSetting());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_getRingerSettingClientCharacteristicConfiguration_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.getRingerSettingClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRingerSettingClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.getRingerSettingClientCharacteristicConfiguration());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_startRingerSettingNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.startRingerSettingNotification());
    }

    @Test
    public void test_startRingerSettingNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.startRingerSettingNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_stopRingerSettingNotification_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.stopRingerSettingNotification());
    }

    @Test
    public void test_stopRingerSettingNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.stopRingerSettingNotification());
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_setRingerControlPoint_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertNull(phoneAlertStatusProfile.setRingerControlPoint(new RingerControlPoint(1)));
    }

    @Test
    public void test_setRingerControlPoint_00002() {
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

        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mPhoneAlertStatusService == null) {
                    mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null) {
                        @Override
                        public synchronized boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.setRingerControlPoint(new RingerControlPoint(1)));
        phoneAlertStatusProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        assertTrue(phoneAlertStatusProfile.getDatabaseHelper() instanceof PhoneAlertStatusProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        assertNotNull(phoneAlertStatusProfile.mPhoneAlertStatusService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        PhoneAlertStatusProfile phoneAlertStatusProfile = new PhoneAlertStatusProfile(ApplicationProvider.getApplicationContext(), new BasePhoneAlertStatusProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        phoneAlertStatusProfile.connect(MOCK_DEVICE);
        phoneAlertStatusProfile.quit();
        assertNull(phoneAlertStatusProfile.mPhoneAlertStatusService);
    }

}
