package org.im97mori.ble.profile.lnp.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
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
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.im97mori.ble.profile.lnp.central.db.LocationAndNavigationProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.cental.BatteryService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.lns.central.LocationAndNavigationService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POSITION_QUALITY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LocationAndNavigationProfileTest {

    @Test
    public void test_findLocationAndNavigationProfileDevices_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.findLocationAndNavigationProfileDevices(null));
    }

    @Test
    public void test_findLocationAndNavigationProfileDevices_00002() {
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
        assertNotNull(locationAndNavigationProfile.findLocationAndNavigationProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        locationAndNavigationProfile.quit();
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.mDeviceInformationService = new DeviceInformationService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), locationAndNavigationProfile.mLocationAndNavigationProfileCallback, null);
        assertNotNull(locationAndNavigationProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasBatteryService_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasBatteryService());
    }

    @Test
    public void test_hasBatteryService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.mBatteryService = new BatteryService(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), locationAndNavigationProfile.mLocationAndNavigationProfileCallback, null);
        assertNotNull(locationAndNavigationProfile.hasBatteryService());
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasManufacturerNameString() {
                            return true;
                        }

                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(locationAndNavigationProfile.hasManufacturerNameString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_hasModelNumberString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasModelNumberString() {
                            return true;
                        }

                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(locationAndNavigationProfile.hasModelNumberString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00002() {
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

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasManufacturerNameString() {
                            return true;
                        }

                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(locationAndNavigationProfile.getManufacturerNameString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00002() {
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

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public synchronized boolean hasModelNumberString() {
                            return true;
                        }
                    };
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0)), null);
        assertNotNull(locationAndNavigationProfile.getModelNumberString());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCount_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelCount());
    }

    @Test
    public void test_getBatteryLevelCount_00002() {
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

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(BATTERY_SERVICE, 0)), null);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelCount());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevel());
    }

    @Test
    public void test_getBatteryLevel_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, 0, 0));

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getBatteryLevel());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevel_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevel(0));
    }

    @Test
    public void test_getBatteryLevel_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, 0, 0));

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getBatteryLevel(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isBatteryLevelNotificatable());
    }

    @Test
    public void test_isBatteryLevelNotificatable_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.isBatteryLevelNotificatable());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_isBatteryLevelNotificatable_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isBatteryLevelNotificatable(0));
    }

    @Test
    public void test_isBatteryLevelNotificatable_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.isBatteryLevelNotificatable(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelCharacteristicPresentationFormat(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getBatteryLevelClientCharacteristicConfiguration(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startBatteryLevelNotification());
    }

    @Test
    public void test_startBatteryLevelNotification_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.startBatteryLevelNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_startBatteryLevelNotification_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startBatteryLevelNotification(0));
    }

    @Test
    public void test_startBatteryLevelNotification_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.startBatteryLevelNotification(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopBatteryLevelNotification());
    }

    @Test
    public void test_stopBatteryLevelNotification_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.stopBatteryLevelNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_stopBatteryLevelNotification_00101() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopBatteryLevelNotification(0));
    }

    @Test
    public void test_stopBatteryLevelNotification_00102() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        locationAndNavigationProfile.mBatteryService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.stopBatteryLevelNotification(0));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_isPositionQualityCharacteristicSupporeted_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isPositionQualityCharacteristicSupporeted());
    }

    @Test
    public void test_isPositionQualityCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POSITION_QUALITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.isPositionQualityCharacteristicSupporeted());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_isLNControlPointCharacteristicSupporeted_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isLNControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_isLNControlPointCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.isLNControlPointCharacteristicSupporeted());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_isNavigationCharacteristicSupporeted_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.isNavigationCharacteristicSupporeted());
    }

    @Test
    public void test_isNavigationCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null), true);

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NAVIGATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.isNavigationCharacteristicSupporeted());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getLNFeature_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getLNFeature());
    }

    @Test
    public void test_getLNFeature_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getLNFeature());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getLocationAndSpeedClientCharacteristicConfiguration_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getLocationAndSpeedClientCharacteristicConfiguration());
    }

    @Test
    public void test_getLocationAndSpeedClientCharacteristicConfiguration_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getLocationAndSpeedClientCharacteristicConfiguration());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_startLocationAndSpeedNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startLocationAndSpeedNotification());
    }

    @Test
    public void test_startLocationAndSpeedNotification_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.startLocationAndSpeedNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_stopLocationAndSpeedNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopLocationAndSpeedNotification());
    }

    @Test
    public void test_stopLocationAndSpeedNotification_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.stopLocationAndSpeedNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getPositionQuality_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.getPositionQuality());
    }

    @Test
    public void test_getPositionQuality_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POSITION_QUALITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.getPositionQuality());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_setLNControlPoint_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.setLNControlPoint(new LNControlPoint(new byte[]{0})));
    }

    @Test
    public void test_setLNControlPoint_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.setLNControlPoint(new LNControlPoint(new byte[]{0})));
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_startLNControlPointIndication_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startLNControlPointIndication());
    }

    @Test
    public void test_startLNControlPointIndication_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.startLNControlPointIndication());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_stopLNControlPointIndication_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopLNControlPointIndication());
    }

    @Test
    public void test_stopLNControlPointIndication_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.stopLNControlPointIndication());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_startNavigationNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.startNavigationNotification());
    }

    @Test
    public void test_startNavigationNotification_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NAVIGATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.startNavigationNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_stopNavigationNotification_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertNull(locationAndNavigationProfile.stopNavigationNotification());
    }

    @Test
    public void test_stopNavigationNotification_00002() {
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

        BluetoothGattService bluetoothGattService = new BluetoothGattService(LOCATION_AND_NAVIGATION_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NAVIGATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
                }
                if (mLocationAndNavigationService == null) {
                    mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.mLocationAndNavigationService.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertNotNull(locationAndNavigationProfile.stopNavigationNotification());
        locationAndNavigationProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        assertTrue(locationAndNavigationProfile.getDatabaseHelper() instanceof LocationAndNavigationProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        assertNotNull(locationAndNavigationProfile.mDeviceInformationService);
        assertNotNull(locationAndNavigationProfile.mBatteryService);
        assertNotNull(locationAndNavigationProfile.mLocationAndNavigationService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        LocationAndNavigationProfile locationAndNavigationProfile = new LocationAndNavigationProfile(ApplicationProvider.getApplicationContext(), new BaseLocationAndNavigationProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        locationAndNavigationProfile.connect(MOCK_DEVICE);
        locationAndNavigationProfile.quit();
        assertNull(locationAndNavigationProfile.mDeviceInformationService);
        assertNull(locationAndNavigationProfile.mBatteryService);
        assertNull(locationAndNavigationProfile.mLocationAndNavigationService);
    }


}
