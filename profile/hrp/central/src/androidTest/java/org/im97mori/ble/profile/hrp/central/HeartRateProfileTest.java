package org.im97mori.ble.profile.hrp.central;

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
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.profile.hrp.central.db.HeartRateProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.hrs.central.HeartRateService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HeartRateProfileTest extends AbstractCentralTest {

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
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertTrue(heartRateProfile.createFilteredScanCallback() instanceof HeartRateProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertTrue(heartRateProfile.createFilteredLeScanCallback() instanceof HeartRateProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        heartRateProfile.start();
        assertNotNull(heartRateProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        heartRateProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.hasDeviceInformationService());
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.hasDeviceInformationService());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00003() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = heartRateProfile.hasDeviceInformationService();
        heartRateProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);

        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        heartRateProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = heartRateProfile.hasDeviceInformationService();
        heartRateProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.hasManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        heartRateProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(heartRateProfile.hasManufacturerNameString());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.getManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.getManufacturerNameString());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isBodySensorLocationCharacteristicSupported_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.isBodySensorLocationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isBodySensorLocationCharacteristicSupported_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.isBodySensorLocationCharacteristicSupported());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isHeartRateControlPointCharacteristicSupported_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.isHeartRateControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isHeartRateControlPointCharacteristicSupported_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.isHeartRateControlPointCharacteristicSupported());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getHeartRateMeasurementClientCharacteristicConfiguration_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.getHeartRateMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getHeartRateMeasurementClientCharacteristicConfiguration_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {
                        @Override
                        public synchronized Integer getHeartRateMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.getHeartRateMeasurementClientCharacteristicConfiguration());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startHeartRateMeasurementNotification_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.startHeartRateMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startHeartRateMeasurementNotification_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {
                        @Override
                        public synchronized Integer startHeartRateMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.startHeartRateMeasurementNotification());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopHeartRateMeasurementNotification_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.stopHeartRateMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopHeartRateMeasurementNotification_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {
                        @Override
                        public synchronized Integer stopHeartRateMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.stopHeartRateMeasurementNotification());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBodySensorLocation_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.getBodySensorLocation());
    }

    @Test
    @RequiresDevice
    public void test_getBodySensorLocation_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {
                        @Override
                        public synchronized Integer getBodySensorLocation() {
                            return 1;
                        }
                    };
                }
            }
        };
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.getBodySensorLocation());
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setHeartRateControlPoint_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertNull(heartRateProfile.setHeartRateControlPoint(new HeartRateControlPoint(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED)));
    }

    @Test
    @RequiresDevice
    public void test_setHeartRateControlPoint_00002() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mHeartRateService == null) {
                    mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null) {
                        @Override
                        public synchronized Integer setHeartRateControlPoint(@NonNull HeartRateControlPoint heartRateControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.setHeartRateControlPoint(new HeartRateControlPoint(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED)));
        heartRateProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        assertTrue(heartRateProfile.getDatabaseHelper() instanceof HeartRateProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(heartRateProfile.mDeviceInformationService);
        assertNotNull(heartRateProfile.mHeartRateService);
        assertTrue(atomicBoolean.get());
        heartRateProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        HeartRateProfile heartRateProfile = new HeartRateProfile(ApplicationProvider.getApplicationContext(), new BaseHeartRateProfileCallback());
        heartRateProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        heartRateProfile.quit();
        assertNull(heartRateProfile.mDeviceInformationService);
        assertNull(heartRateProfile.mHeartRateService);
    }

}
