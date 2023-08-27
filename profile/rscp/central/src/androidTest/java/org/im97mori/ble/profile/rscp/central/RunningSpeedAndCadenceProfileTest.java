package org.im97mori.ble.profile.rscp.central;

import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.profile.rscp.central.db.RunningSpeedAndCadenceProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.rscs.central.RunningSpeedAndCadenceService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class RunningSpeedAndCadenceProfileTest extends AbstractCentralTest {

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
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertTrue(runningSpeedAndCadenceProfile.createFilteredScanCallback() instanceof RunningSpeedAndCadenceProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertTrue(runningSpeedAndCadenceProfile.createFilteredLeScanCallback() instanceof RunningSpeedAndCadenceProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        runningSpeedAndCadenceProfile.start();
        assertNotNull(runningSpeedAndCadenceProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        runningSpeedAndCadenceProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.hasDeviceInformationService());
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.hasDeviceInformationService());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00003() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = runningSpeedAndCadenceProfile.hasDeviceInformationService();
        runningSpeedAndCadenceProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);

        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        runningSpeedAndCadenceProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = runningSpeedAndCadenceProfile.hasDeviceInformationService();
        runningSpeedAndCadenceProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_isSensorLocationCharacteristicSupported_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSensorLocationCharacteristicSupported_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isSCControlPointCharacteristicSupported_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSCControlPointCharacteristicSupported_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getRSCFeature_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getRSCFeature());
    }

    @Test
    @RequiresDevice
    public void test_getRSCFeature_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getRSCFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.getRSCFeature());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getRSCMeasurementClientCharacteristicConfiguration_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getRSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRSCMeasurementClientCharacteristicConfiguration_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getRSCMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.getRSCMeasurementClientCharacteristicConfiguration());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startRSCMeasurementNotification_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.startRSCMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startRSCMeasurementNotification_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer startRSCMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.startRSCMeasurementNotification());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopRSCMeasurementNotification_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.stopRSCMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopRSCMeasurementNotification_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer stopRSCMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.stopRSCMeasurementNotification());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getSensorLocation_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getSensorLocation());
    }

    @Test
    @RequiresDevice
    public void test_getSensorLocation_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getSensorLocation() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.getSensorLocation());
        runningSpeedAndCadenceProfile.disconnect();
    }


    @Test
    @RequiresDevice
    public void test_setSCControlPoint_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
    }

    @Test
    @RequiresDevice
    public void test_setSCControlPoint_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer setSCControlPoint(@NonNull SCControlPoint scControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getSCControlPointClientCharacteristicConfiguration_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getSCControlPointClientCharacteristicConfiguration_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getSCControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startSCControlPointIndication_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.startSCControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startSCControlPointIndication_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer startSCControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.startSCControlPointIndication());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopSCControlPointIndication_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.stopSCControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopSCControlPointIndication_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mRunningSpeedAndCadenceService == null) {
                    mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer stopSCControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.stopSCControlPointIndication());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.hasManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.hasManufacturerNameString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.hasModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.hasModelNumberString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.getManufacturerNameString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertNull(runningSpeedAndCadenceProfile.getModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00002() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.getModelNumberString());
        runningSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        assertTrue(runningSpeedAndCadenceProfile.getDatabaseHelper() instanceof RunningSpeedAndCadenceProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService);
        assertNotNull(runningSpeedAndCadenceProfile.mDeviceInformationService);
        assertTrue(atomicBoolean.get());
        runningSpeedAndCadenceProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        RunningSpeedAndCadenceProfile runningSpeedAndCadenceProfile = new RunningSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseRunningSpeedAndCadenceProfileCallback());
        runningSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        runningSpeedAndCadenceProfile.quit();
        assertNull(runningSpeedAndCadenceProfile.mRunningSpeedAndCadenceService);
        assertNull(runningSpeedAndCadenceProfile.mDeviceInformationService);
    }

}
