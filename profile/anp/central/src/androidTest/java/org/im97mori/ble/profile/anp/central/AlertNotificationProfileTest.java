package org.im97mori.ble.profile.anp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPoint;
import org.im97mori.ble.profile.anp.central.db.AlertNotificationProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ans.AlertNotificationCategoryIdUtils;
import org.im97mori.ble.service.ans.central.AlertNotificationService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AlertNotificationProfileTest {

    @Test
    public void test_findAlertNotificationProfileDevices_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.findAlertNotificationProfileDevices(null));
    }

    @Test
    public void test_findLocationAndNavigationProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        alertNotificationProfile.start();
        assertNotNull(alertNotificationProfile.findAlertNotificationProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        alertNotificationProfile.quit();
    }

    @Test
    public void test_getSupportedNewAlertCategory_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getSupportedNewAlertCategory());
    }

    @Test
    public void test_getSupportedNewAlertCategory_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        alertNotificationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(ALERT_NOTIFICATION_SERVICE, 0)), null);
        assertNotNull(alertNotificationProfile.getSupportedNewAlertCategory());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getNewAlertClientCharacteristicConfiguration_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getNewAlertClientCharacteristicConfiguration());
    }

    @Test
    public void test_getNewAlertClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.getNewAlertClientCharacteristicConfiguration());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_startNewAlertNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.startNewAlertNotification());
    }

    @Test
    public void test_startNewAlertNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.startNewAlertNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_stopNewAlertNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.stopNewAlertNotification());
    }

    @Test
    public void test_stopNewAlertNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.stopNewAlertNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getSupportedUnreadAlertCategory_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getSupportedUnreadAlertCategory());
    }

    @Test
    public void test_getSupportedUnreadAlertCategory_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        alertNotificationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(ALERT_NOTIFICATION_SERVICE, 0)), null);
        assertNotNull(alertNotificationProfile.getSupportedUnreadAlertCategory());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getUnreadAlertStatusClientCharacteristicConfiguration_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.getUnreadAlertStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUnreadAlertStatusClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.getUnreadAlertStatusClientCharacteristicConfiguration());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_startUnreadAlertStatusNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.startUnreadAlertStatusNotification());
    }

    @Test
    public void test_startUnreadAlertStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.startUnreadAlertStatusNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_stopUnreadAlertStatusNotification_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertNull(alertNotificationProfile.stopUnreadAlertStatusNotification());
    }

    @Test
    public void test_stopUnreadAlertStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.stopUnreadAlertStatusNotification());
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_setAlertNotificationControlPoint_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL);
        assertNull(alertNotificationProfile.setAlertNotificationControlPoint(alertNotificationControlPoint));
    }

    @Test
    public void test_setAlertNotificationControlPoint_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }

        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAlertNotificationService == null) {
                    mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL);
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.setAlertNotificationControlPoint(alertNotificationControlPoint));
        alertNotificationProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        assertTrue(alertNotificationProfile.getDatabaseHelper() instanceof AlertNotificationProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        alertNotificationProfile.connect(MOCK_DEVICE);
        assertNotNull(alertNotificationProfile.mAlertNotificationService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        AlertNotificationProfile alertNotificationProfile = new AlertNotificationProfile(ApplicationProvider.getApplicationContext(), new BaseAlertNotificationProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        alertNotificationProfile.connect(MOCK_DEVICE);
        alertNotificationProfile.quit();
        assertNull(alertNotificationProfile.mAlertNotificationService);
    }

}
