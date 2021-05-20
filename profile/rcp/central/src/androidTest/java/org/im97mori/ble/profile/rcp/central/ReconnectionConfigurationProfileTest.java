package org.im97mori.ble.profile.rcp.central;

import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPoint;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.profile.rcp.central.db.ReconnectionConfigurationProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bms.central.BondManagementService;
import org.im97mori.ble.service.rcs.central.ReconnectionConfigurationService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.ServiceUUID.BOND_MANAGEMENT_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ReconnectionConfigurationProfileTest extends AbstractCentralTest {

    @Override
    public void setup() {
        super.setup();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
    }

    @Override
    public void tearDown() {
        super.tearDown();
        BLEConnection bleConnection = BLEConnectionHolder.getInstance(BLETestUtilsAndroid.MOCK_DEVICE_0);
        if (bleConnection instanceof MockBLEConnection) {
            ((MockBLEConnection) bleConnection).quitTaskHandler();
        }
        BLEConnectionHolder.clearInstance();
    }

    @Test
    public void test_findReconnectionConfigurationProfileDevices_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.findReconnectionConfigurationProfileDevices(null));
    }

    @Test
    public void test_findReconnectionConfigurationProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        reconnectionConfigurationProfile.start();
        assertNotNull(reconnectionConfigurationProfile.findReconnectionConfigurationProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        reconnectionConfigurationProfile.quit();
    }

    @Test
    public void test_hasBondManagementService_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.hasBondManagementService());
    }

    @Test
    public void test_hasBondManagementService_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.hasBondManagementService());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_hasBondManagementService_00003() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = reconnectionConfigurationProfile.hasBondManagementService();
        reconnectionConfigurationProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void test_hasBondManagementService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BOND_MANAGEMENT_SERVICE, 0);

        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        reconnectionConfigurationProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = reconnectionConfigurationProfile.hasBondManagementService();
        reconnectionConfigurationProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void test_isRCSettingsCharacteristicSupported_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.isRCSettingsCharacteristicSupported());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.isRCSettingsCharacteristicSupported());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_isRCSettingsCharacteristicNotifySupported_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.isRCSettingsCharacteristicNotifySupported());
    }

    @Test
    public void test_isRCSettingsCharacteristicNotifySupported_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.isRCSettingsCharacteristicNotifySupported());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_isReconnectionConfigurationControlPointCharacteristicSupported_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.isReconnectionConfigurationControlPointCharacteristicSupported());
    }

    @Test
    public void test_isReconnectionConfigurationControlPointCharacteristicSupported_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.isReconnectionConfigurationControlPointCharacteristicSupported());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_getRCFeature_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.getRCFeature());
    }

    @Test
    public void test_getRCFeature_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer getRCFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.getRCFeature());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_getRCSettings_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.getRCSettings());
    }

    @Test
    public void test_getRCSettings_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer getRCSettings() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.getRCSettings());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_getRCSettingsClientCharacteristicConfiguration_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.getRCSettingsClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRCSettingsClientCharacteristicConfiguration_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer getRCSettingsClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.getRCSettingsClientCharacteristicConfiguration());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_startRCSettingsNotification_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.startRCSettingsNotification());
    }

    @Test
    public void test_startRCSettingsNotification_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer startRCSettingsNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.startRCSettingsNotification());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_stopRCSettingsNotification_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.stopRCSettingsNotification());
    }

    @Test
    public void test_stopRCSettingsNotification_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopRCSettingsNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.stopRCSettingsNotification());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_setReconnectionConfigurationControlPoint_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.setReconnectionConfigurationControlPoint(new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0])));
    }

    @Test
    public void test_setReconnectionConfigurationControlPoint_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer setReconnectionConfigurationControlPoint(@NonNull ReconnectionConfigurationControlPoint reconnectionConfigurationControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.setReconnectionConfigurationControlPoint(new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT, new byte[0], null, 0, 0, new byte[0])));
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_getReconnectionConfigurationControlPointClientCharacteristicConfiguration_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.getReconnectionConfigurationControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getReconnectionConfigurationControlPointClientCharacteristicConfiguration_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer getReconnectionConfigurationControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.getReconnectionConfigurationControlPointClientCharacteristicConfiguration());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_startReconnectionConfigurationControlPointIndication_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.startReconnectionConfigurationControlPointIndication());
    }

    @Test
    public void test_startReconnectionConfigurationControlPointIndication_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer startReconnectionConfigurationControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.startReconnectionConfigurationControlPointIndication());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_stopReconnectionConfigurationControlPointIndication_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.stopReconnectionConfigurationControlPointIndication());
    }

    @Test
    public void test_stopReconnectionConfigurationControlPointIndication_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mReconnectionConfigurationService == null) {
                    mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopReconnectionConfigurationControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.stopReconnectionConfigurationControlPointIndication());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_getBondManagementFeatures_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.getBondManagementFeatures());
    }

    @Test
    public void test_getBondManagementFeatures_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mBondManagementService == null) {
                    mBondManagementService = new BondManagementService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBondManagementFeatures() {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.getBondManagementFeatures());
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_setBondManagementControlPoint_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertNull(reconnectionConfigurationProfile.setBondManagementControlPoint(new BondManagementControlPoint(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, "a")));
    }

    @Test
    public void test_setBondManagementControlPoint_00002() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mBondManagementService == null) {
                    mBondManagementService = new BondManagementService(mBLEConnection, mReconnectionConfigurationProfileCallback, null) {
                        @Override
                        public synchronized Integer setBondManagementControlPoint(@NonNull BondManagementControlPoint bondManagementControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.setBondManagementControlPoint(new BondManagementControlPoint(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, "a")));
        reconnectionConfigurationProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        assertTrue(reconnectionConfigurationProfile.getDatabaseHelper() instanceof ReconnectionConfigurationProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(reconnectionConfigurationProfile.mReconnectionConfigurationService);
        assertNotNull(reconnectionConfigurationProfile.mBondManagementService);
        assertTrue(atomicBoolean.get());
        reconnectionConfigurationProfile.quit();
    }

    @Test
    public void test_quit_00001() {
        ReconnectionConfigurationProfile reconnectionConfigurationProfile = new ReconnectionConfigurationProfile(ApplicationProvider.getApplicationContext(), new BaseReconnectionConfigurationProfileCallback());
        reconnectionConfigurationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        reconnectionConfigurationProfile.quit();
        assertNull(reconnectionConfigurationProfile.mReconnectionConfigurationService);
        assertNull(reconnectionConfigurationProfile.mBondManagementService);
    }

}
