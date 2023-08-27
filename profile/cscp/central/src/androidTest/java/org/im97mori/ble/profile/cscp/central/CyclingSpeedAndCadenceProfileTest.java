package org.im97mori.ble.profile.cscp.central;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
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
import org.im97mori.ble.profile.cscp.central.db.CyclingSpeedAndCadenceProfileBondedDatabaseHelper;
import org.im97mori.ble.service.cscs.central.CyclingSpeedAndCadenceService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CyclingSpeedAndCadenceProfileTest extends AbstractCentralTest {

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
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertTrue(cyclingSpeedAndCadenceProfile.createFilteredScanCallback() instanceof CyclingSpeedAndCadenceProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertTrue(cyclingSpeedAndCadenceProfile.createFilteredLeScanCallback() instanceof CyclingSpeedAndCadenceProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        cyclingSpeedAndCadenceProfile.start();
        assertNotNull(cyclingSpeedAndCadenceProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        cyclingSpeedAndCadenceProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.hasDeviceInformationService());
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.hasDeviceInformationService());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00003() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = cyclingSpeedAndCadenceProfile.hasDeviceInformationService();
        cyclingSpeedAndCadenceProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingSpeedAndCadenceProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = cyclingSpeedAndCadenceProfile.hasDeviceInformationService();
        cyclingSpeedAndCadenceProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_isSensorLocationCharacteristicSupported_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSensorLocationCharacteristicSupported_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.isSensorLocationCharacteristicSupported());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isSCControlPointCharacteristicSupported_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSCControlPointCharacteristicSupported_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.isSCControlPointCharacteristicSupported());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getCSCFeature_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getCSCFeature());
    }

    @Test
    @RequiresDevice
    public void test_getCSCFeature_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getCSCFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.getCSCFeature());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getCSCMeasurementClientCharacteristicConfiguration_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getCSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCSCMeasurementClientCharacteristicConfiguration_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getCSCMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.getCSCMeasurementClientCharacteristicConfiguration());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startCSCMeasurementNotification_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.startCSCMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCSCMeasurementNotification_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer startCSCMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.startCSCMeasurementNotification());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopCSCMeasurementNotification_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.stopCSCMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCSCMeasurementNotification_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer stopCSCMeasurementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.stopCSCMeasurementNotification());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getSensorLocation_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getSensorLocation());
    }

    @Test
    @RequiresDevice
    public void test_getSensorLocation_00002() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getSensorLocation() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.getSensorLocation());
        cyclingSpeedAndCadenceProfile.disconnect();
    }


    @Test
    @RequiresDevice
    public void test_setSCControlPoint_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
    }

    @Test
    @RequiresDevice
    public void test_setSCControlPoint_00002() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer setSCControlPoint(@NonNull SCControlPoint scControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.setSCControlPoint(new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS})));
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getSCControlPointClientCharacteristicConfiguration_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getSCControlPointClientCharacteristicConfiguration_00002() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getSCControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.getSCControlPointClientCharacteristicConfiguration());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startSCControlPointIndication_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.startSCControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startSCControlPointIndication_00002() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer startSCControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.startSCControlPointIndication());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopSCControlPointIndication_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.stopSCControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopSCControlPointIndication_00002() {

        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCyclingSpeedAndCadenceService == null) {
                    mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer stopSCControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(cyclingSpeedAndCadenceProfile.stopSCControlPointIndication());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.hasManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_hasManufacturerNameString_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.hasManufacturerNameString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.hasModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_hasModelNumberString_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.hasModelNumberString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.getManufacturerNameString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertNull(cyclingSpeedAndCadenceProfile.getModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00002() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.getModelNumberString());
        cyclingSpeedAndCadenceProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        assertTrue(cyclingSpeedAndCadenceProfile.getDatabaseHelper() instanceof CyclingSpeedAndCadenceProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService);
        assertNotNull(cyclingSpeedAndCadenceProfile.mDeviceInformationService);
        assertTrue(atomicBoolean.get());
        cyclingSpeedAndCadenceProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        CyclingSpeedAndCadenceProfile cyclingSpeedAndCadenceProfile = new CyclingSpeedAndCadenceProfile(ApplicationProvider.getApplicationContext(), new BaseCyclingSpeedAndCadenceProfileCallback());
        cyclingSpeedAndCadenceProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        cyclingSpeedAndCadenceProfile.quit();
        assertNull(cyclingSpeedAndCadenceProfile.mCyclingSpeedAndCadenceService);
        assertNull(cyclingSpeedAndCadenceProfile.mDeviceInformationService);
    }

}
