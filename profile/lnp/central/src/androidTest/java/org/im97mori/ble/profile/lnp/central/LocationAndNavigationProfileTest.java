package org.im97mori.ble.profile.lnp.central;

import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.im97mori.ble.profile.lnp.central.db.LocationAndNavigationProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.lns.central.LocationAndNavigationService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LocationAndNavigationProfileTest extends AbstractCentralTest {

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
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_createFilteredScanCallback_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertTrue(locationAndNavigationProfile.createFilteredScanCallback() instanceof LocationAndNavigationProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertTrue(locationAndNavigationProfile.createFilteredLeScanCallback() instanceof LocationAndNavigationProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        locationAndNavigationProfile.start();
        assertNotNull(locationAndNavigationProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        locationAndNavigationProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasDeviceInformationService());
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.hasDeviceInformationService());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00003() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = locationAndNavigationProfile.hasDeviceInformationService();
        locationAndNavigationProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = locationAndNavigationProfile.hasDeviceInformationService();
        locationAndNavigationProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasBatteryService());
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.hasBatteryService());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00003() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = locationAndNavigationProfile.hasBatteryService();
        locationAndNavigationProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = locationAndNavigationProfile.hasBatteryService();
        locationAndNavigationProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.hasManufacturerNameString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.hasModelNumberString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getManufacturerNameString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getModelNumberString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCount_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelCount());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCount_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCount() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelCount());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevel());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getBatteryLevel());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevel(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00102() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getBatteryLevel(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_canBatteryLevelNotify_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.canBatteryLevelNotify());
    }

    @Test
    @RequiresDevice
    public void test_canBatteryLevelNotify_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.canBatteryLevelNotify());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_canBatteryLevelNotify_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.canBatteryLevelNotify(0));
    }

    @Test
    @RequiresDevice
    public void test_canBatteryLevelNotify_00102() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.canBatteryLevelNotify(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startBatteryLevelNotification());
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.startBatteryLevelNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startBatteryLevelNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00102() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.startBatteryLevelNotification(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopBatteryLevelNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.stopBatteryLevelNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopBatteryLevelNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00102() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.stopBatteryLevelNotification(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isPositionQualityCharacteristicSupported_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isPositionQualityCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isPositionQualityCharacteristicSupported_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.isPositionQualityCharacteristicSupported());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isLNControlPointCharacteristicSupported_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isLNControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isLNControlPointCharacteristicSupported_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.isLNControlPointCharacteristicSupported());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isNavigationCharacteristicSupported_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isNavigationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isNavigationCharacteristicSupported_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.isNavigationCharacteristicSupported());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getLNFeature_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getLNFeature());
    }

    @Test
    @RequiresDevice
    public void test_getLNFeature_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getLNFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getLNFeature());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getLocationAndSpeedClientCharacteristicConfiguration_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getLocationAndSpeedClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getLocationAndSpeedClientCharacteristicConfiguration_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getLocationAndSpeedClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getLocationAndSpeedClientCharacteristicConfiguration());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startLocationAndSpeedNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startLocationAndSpeedNotification());
    }

    @Test
    @RequiresDevice
    public void test_startLocationAndSpeedNotification_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer startLocationAndSpeedNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.startLocationAndSpeedNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopLocationAndSpeedNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopLocationAndSpeedNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopLocationAndSpeedNotification_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopLocationAndSpeedNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.stopLocationAndSpeedNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getPositionQuality_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getPositionQuality());
    }

    @Test
    @RequiresDevice
    public void test_getPositionQuality_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getPositionQuality() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getPositionQuality());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setLNControlPoint_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.setLNControlPoint(new LNControlPoint(new byte[]{0})));
    }

    @Test
    @RequiresDevice
    public void test_setLNControlPoint_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer setLNControlPoint(@NonNull LNControlPoint lnControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.setLNControlPoint(new LNControlPoint(new byte[]{0})));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getLNControlPointClientCharacteristicConfiguration_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getLNControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getLNControlPointClientCharacteristicConfiguration_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer getLNControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.getLNControlPointClientCharacteristicConfiguration());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startLNControlPointIndication_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startLNControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startLNControlPointIndication_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer startLNControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.startLNControlPointIndication());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopLNControlPointIndication_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopLNControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopLNControlPointIndication_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopLNControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.stopLNControlPointIndication());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startNavigationNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startNavigationNotification());
    }

    @Test
    @RequiresDevice
    public void test_startNavigationNotification_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer startNavigationNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.startNavigationNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopNavigationNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopNavigationNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopNavigationNotification_00002() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public synchronized Integer stopNavigationNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.stopNavigationNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertTrue(locationAndNavigationProfile.getDatabaseHelper() instanceof LocationAndNavigationProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(locationAndNavigationProfile.mDeviceInformationService);
        assertNotNull(locationAndNavigationProfile.mBatteryService);
        assertNotNull(locationAndNavigationProfile.mLocationAndNavigationService);
        assertTrue(atomicBoolean.get());
        locationAndNavigationProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        locationAndNavigationProfile.quit();
        assertNull(locationAndNavigationProfile.mDeviceInformationService);
        assertNull(locationAndNavigationProfile.mBatteryService);
        assertNull(locationAndNavigationProfile.mLocationAndNavigationService);
    }


}
