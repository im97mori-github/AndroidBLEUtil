package org.im97mori.ble.profile.esp.central;

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
import org.im97mori.ble.profile.esp.central.db.EnvironmentalSensingProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.ess.central.EnvironmentalSensingService;
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

public class EnvironmentalSensingProfileTest extends AbstractCentralTest {

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
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertTrue(environmentalSensingProfile.createFilteredScanCallback() instanceof EnvironmentalSensingProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertTrue(environmentalSensingProfile.createFilteredLeScanCallback() instanceof EnvironmentalSensingProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        environmentalSensingProfile.start();
        assertNotNull(environmentalSensingProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        environmentalSensingProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasDeviceInformationService());
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasDeviceInformationService());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00003() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = environmentalSensingProfile.hasDeviceInformationService();
        environmentalSensingProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        environmentalSensingProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = environmentalSensingProfile.hasDeviceInformationService();
        environmentalSensingProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasBatteryService());
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasBatteryService());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00003() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = environmentalSensingProfile.hasBatteryService();
        environmentalSensingProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);

        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        environmentalSensingProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = environmentalSensingProfile.hasBatteryService();
        environmentalSensingProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_isDescriptorValueChangedCharacteristicSupported_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.isDescriptorValueChangedCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isDescriptorValueChangedCharacteristicSupported_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.isDescriptorValueChangedCharacteristicSupported());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startDescriptorValueChangedIndication_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startDescriptorValueChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_startDescriptorValueChangedIndication_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startDescriptorValueChangedIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startDescriptorValueChangedIndication());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopDescriptorValueChangedIndication_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopDescriptorValueChangedIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopDescriptorValueChangedIndication_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mEnvironmentalSensingService == null) {
                    mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopDescriptorValueChangedIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopDescriptorValueChangedIndication());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasManufacturerNameString());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.hasModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.hasModelNumberString());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getManufacturerNameString());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getModelNumberString());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCount_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getBatteryLevelCount());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCount_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCount() {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getBatteryLevelCount());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getBatteryLevel());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getBatteryLevel());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getBatteryLevel(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getBatteryLevel(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.isBatteryLevelNotificatable());
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.isBatteryLevelNotificatable());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.isBatteryLevelNotificatable(0));
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.isBatteryLevelNotificatable(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getBatteryLevelCharacteristicPresentationFormat());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getBatteryLevelCharacteristicPresentationFormat(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getBatteryLevelClientCharacteristicConfiguration());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.getBatteryLevelClientCharacteristicConfiguration(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startBatteryLevelNotification());
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startBatteryLevelNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.startBatteryLevelNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.startBatteryLevelNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopBatteryLevelNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00002() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopBatteryLevelNotification());
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00101() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertNull(environmentalSensingProfile.stopBatteryLevelNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00102() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.stopBatteryLevelNotification(0));
        environmentalSensingProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        assertTrue(environmentalSensingProfile.getDatabaseHelper() instanceof EnvironmentalSensingProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(environmentalSensingProfile.mEnvironmentalSensingService);
        assertNotNull(environmentalSensingProfile.mDeviceInformationService);
        assertNotNull(environmentalSensingProfile.mBatteryService);
        assertTrue(atomicBoolean.get());
        environmentalSensingProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        EnvironmentalSensingProfile environmentalSensingProfile = new EnvironmentalSensingProfile(ApplicationProvider.getApplicationContext(), new BaseEnvironmentalSensingProfileCallback());
        environmentalSensingProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        environmentalSensingProfile.quit();
        assertNull(environmentalSensingProfile.mEnvironmentalSensingService);
        assertNull(environmentalSensingProfile.mDeviceInformationService);
        assertNull(environmentalSensingProfile.mBatteryService);
    }

}
