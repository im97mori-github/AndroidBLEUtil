package org.im97mori.ble.profile.cpp.central;

import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.profile.cpp.central.db.CyclingPowerProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.cps.central.CyclingPowerService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
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

public class CyclingPowerProfileTest extends AbstractCentralTest {

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
    public void test_findCyclingPowerProfileDevices_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.findCyclingPowerProfileDevices(null));
    }

    @Test
    public void test_findCyclingPowerProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        cyclingPowerProfile.start();
        assertNotNull(cyclingPowerProfile.findCyclingPowerProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        cyclingPowerProfile.quit();
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.hasDeviceInformationService());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00003() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = cyclingPowerProfile.hasDeviceInformationService();
        cyclingPowerProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = cyclingPowerProfile.hasDeviceInformationService();
        cyclingPowerProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void test_hasBatteryService_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasBatteryService());
    }

    @Test
    public void test_hasBatteryService_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.hasBatteryService());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_hasBatteryService_00003() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = cyclingPowerProfile.hasBatteryService();
        cyclingPowerProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void test_hasBatteryService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingPowerProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = cyclingPowerProfile.hasBatteryService();
        cyclingPowerProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void test_isCyclingPowerControlPointCharacteristicSupported_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    public void test_isCyclingPowerControlPointCharacteristicSupported_00002() {

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.isCyclingPowerControlPointCharacteristicSupported());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_isCyclingPowerVectorCharacteristicSupported_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    public void test_isCyclingPowerVectorCharacteristicSupported_00002() {

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.isCyclingPowerVectorCharacteristicSupported());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerFeature_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerFeature());
    }

    @Test
    public void test_getCyclingPowerFeature_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getCyclingPowerFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getCyclingPowerFeature());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerMeasurementClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCyclingPowerMeasurementClientCharacteristicConfiguration_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getCyclingPowerMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getCyclingPowerMeasurementClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startCyclingPowerMeasurementNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startCyclingPowerMeasurementNotification());
    }

    @Test
    public void test_startCyclingPowerMeasurementNotification_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer startCyclingPowerMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.startCyclingPowerMeasurementNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopCyclingPowerMeasurementNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopCyclingPowerMeasurementNotification());
    }

    @Test
    public void test_stopCyclingPowerMeasurementNotification_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopCyclingPowerMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.stopCyclingPowerMeasurementNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getSensorLocation_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getSensorLocation() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getSensorLocation());
        cyclingPowerProfile.disconnect();
    }


    @Test
    public void test_setCyclingPowerControlPoint_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0})));
    }

    @Test
    public void test_setCyclingPowerControlPoint_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {

                        @Override
                        public synchronized Integer setCyclingPowerControlPoint(@NonNull CyclingPowerControlPoint cyclingPowerControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(cyclingPowerProfile.setCyclingPowerControlPoint(new CyclingPowerControlPoint(new byte[]{
                CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0})));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getCyclingPowerControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(cyclingPowerProfile.getCyclingPowerControlPointClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startCyclingPowerControlPointIndication_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startCyclingPowerControlPointIndication());
    }

    @Test
    public void test_startCyclingPowerControlPointIndication_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer startCyclingPowerControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(cyclingPowerProfile.startCyclingPowerControlPointIndication());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopCyclingPowerControlPointIndication_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopCyclingPowerControlPointIndication());
    }

    @Test
    public void test_stopCyclingPowerControlPointIndication_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopCyclingPowerControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(cyclingPowerProfile.stopCyclingPowerControlPointIndication());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getCyclingPowerVectorClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getCyclingPowerVectorClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(cyclingPowerProfile.getCyclingPowerVectorClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startCyclingPowerVectorNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startCyclingPowerVectorNotification());
    }

    @Test
    public void test_startCyclingPowerVectorNotification_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer startCyclingPowerVectorNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(cyclingPowerProfile.startCyclingPowerVectorNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopCyclingPowerVectorNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopCyclingPowerVectorNotification());
    }

    @Test
    public void test_stopCyclingPowerVectorNotification_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingPowerService == null) {
                    mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopCyclingPowerVectorNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(cyclingPowerProfile.stopCyclingPowerVectorNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.hasManufacturerNameString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_hasModelNumberString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {

        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.hasModelNumberString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getManufacturerNameString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getModelNumberString());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCount_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelCount());
    }

    @Test
    public void test_getBatteryLevelCount_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCount() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getBatteryLevelCount());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevel());
    }

    @Test
    public void test_getBatteryLevel_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getBatteryLevel());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevel(0));
    }

    @Test
    public void test_getBatteryLevel_00102() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getBatteryLevel(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isBatteryLevelNotificatable());
    }

    @Test
    public void test_isBatteryLevelNotificatable_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized boolean isBatteryLevelNotificatable(int index) {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.isBatteryLevelNotificatable());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00102() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized boolean isBatteryLevelNotificatable(int index) {
                            return true;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.isBatteryLevelNotificatable(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getBatteryLevelCharacteristicPresentationFormat(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.getBatteryLevelClientCharacteristicConfiguration(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startBatteryLevelNotification());
    }

    @Test
    public void test_startBatteryLevelNotification_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.startBatteryLevelNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.startBatteryLevelNotification(0));
    }

    @Test
    public void test_startBatteryLevelNotification_00102() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.startBatteryLevelNotification(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopBatteryLevelNotification());
    }

    @Test
    public void test_stopBatteryLevelNotification_00002() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.stopBatteryLevelNotification());
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00101() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertNull(cyclingPowerProfile.stopBatteryLevelNotification(0));
    }

    @Test
    public void test_stopBatteryLevelNotification_00102() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.stopBatteryLevelNotification(0));
        cyclingPowerProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        assertTrue(cyclingPowerProfile.getDatabaseHelper() instanceof CyclingPowerProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingPowerProfile.mCyclingPowerService);
        assertNotNull(cyclingPowerProfile.mDeviceInformationService);
        assertNotNull(cyclingPowerProfile.mBatteryService);
        assertTrue(atomicBoolean.get());
        cyclingPowerProfile.quit();
    }

    @Test
    public void test_quit_00001() {
        CyclingPowerProfile cyclingPowerProfile = new CyclingPowerProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingPowerProfileCallback());
        cyclingPowerProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingPowerProfile.quit();
        assertNull(cyclingPowerProfile.mCyclingPowerService);
        assertNull(cyclingPowerProfile.mDeviceInformationService);
        assertNull(cyclingPowerProfile.mBatteryService);
    }

}
