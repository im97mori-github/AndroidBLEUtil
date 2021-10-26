package org.im97mori.ble.profile.wsp.central;

import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.BODY_COMPOSITION_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.CURRENT_TIME_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.USER_DATA_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.WEIGHT_SCALE_SERVICE;
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
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.profile.wsp.central.db.WeightScaleProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.bcs.central.BodyCompositionService;
import org.im97mori.ble.service.cts.central.CurrentTimeService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.uds.central.UserDataService;
import org.im97mori.ble.service.wss.central.WeightScaleService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class WeightScaleProfileTest extends AbstractCentralTest {

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
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertTrue(weightScaleProfile.createFilteredScanCallback() instanceof WeightScaleProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertTrue(weightScaleProfile.createFilteredLeScanCallback() instanceof WeightScaleProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.findDevices(null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        weightScaleProfile.start();
        assertNotNull(weightScaleProfile.findDevices(bundle));
        assertTrue(atomicBoolean.get());
        weightScaleProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasBodyCompositionService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasBodyCompositionService());
    }

    @Test
    @RequiresDevice
    public void test_hasBodyCompositionService_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.hasBodyCompositionService());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasBodyCompositionService_00003() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = weightScaleProfile.hasBodyCompositionService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasBodyCompositionService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(WEIGHT_SCALE_SERVICE, 0);
        bluetoothGattService.addService(new BluetoothGattService(BODY_COMPOSITION_SERVICE, 0));

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        weightScaleProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = weightScaleProfile.hasBodyCompositionService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasUserDataService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasUserDataService());
    }

    @Test
    @RequiresDevice
    public void test_hasUserDataService_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.hasUserDataService());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasUserDataService_00003() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = weightScaleProfile.hasUserDataService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasUserDataService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        weightScaleProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = weightScaleProfile.hasUserDataService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasBatteryService());
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.hasBatteryService());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00003() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = weightScaleProfile.hasBatteryService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasBatteryService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(BATTERY_SERVICE, 0);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        weightScaleProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = weightScaleProfile.hasBatteryService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasCurrentTimeService_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasCurrentTimeService());
    }

    @Test
    @RequiresDevice
    public void test_hasCurrentTimeService_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.hasCurrentTimeService());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasCurrentTimeService_00003() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = weightScaleProfile.hasCurrentTimeService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasCurrentTimeService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);

        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        weightScaleProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = weightScaleProfile.hasCurrentTimeService();
        weightScaleProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_getWeightScaleFeature_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getWeightScaleFeature());
    }

    @Test
    @RequiresDevice
    public void test_getWeightScaleFeature_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getWeightScaleFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getWeightScaleFeature());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getWeightMeasurementClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getWeightMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getWeightMeasurementClientCharacteristicConfiguration_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getWeightMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getWeightMeasurementClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startWeightMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startWeightMeasurementIndication());
    }

    @Test
    @RequiresDevice
    public void test_startWeightMeasurementIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startWeightMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startWeightMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopWeightMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopWeightMeasurementIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopWeightMeasurementIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mWeightScaleService == null) {
                    mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopWeightMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopWeightMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasSystemId_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.hasSystemId());
    }

    @Test
    @RequiresDevice
    public void test_hasSystemId_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.hasSystemId());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getManufacturerNameString());
    }

    @Test
    @RequiresDevice
    public void test_getManufacturerNameString_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getManufacturerNameString());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getModelNumberString());
    }

    @Test
    @RequiresDevice
    public void test_getModelNumberString_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getModelNumberString());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getSystemId_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getSystemId());
    }

    @Test
    @RequiresDevice
    public void test_getSystemId_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getSystemId() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getSystemId());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBodyCompositionFeature_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBodyCompositionFeature());
    }

    @Test
    @RequiresDevice
    public void test_getBodyCompositionFeature_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBodyCompositionFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBodyCompositionFeature());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isAgeCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isAgeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isAgeCharacteristicSupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isAgeCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isDateOfBirthCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isDateOfBirthCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isDateOfBirthCharacteristicSupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isDateOfBirthCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isFirstNameCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isFirstNameCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isFirstNameCharacteristicSupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isFirstNameCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isHeightCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isHeightCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isHeightCharacteristicSupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isHeightCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isGenderCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isGenderCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isGenderCharacteristicSupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isGenderCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    @RequiresDevice
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isDatabaseChangeIncrementCharacteristicNotifySupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getAge_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getAge());
    }

    @Test
    @RequiresDevice
    public void test_getAge_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getAge() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getAge());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setAge_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setAge(new Age(1)));
    }

    @Test
    @RequiresDevice
    public void test_setAge_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setAge(@NonNull Age age) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setAge(new Age(1)));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDateOfBirth_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getDateOfBirth());
    }

    @Test
    @RequiresDevice
    public void test_getDateOfBirth_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getDateOfBirth() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getDateOfBirth());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setDateOfBirth_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setDateOfBirth(new DateOfBirth(0, 0, 0)));
    }

    @Test
    @RequiresDevice
    public void test_setDateOfBirth_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setDateOfBirth(@NonNull DateOfBirth dateOfBirth) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setDateOfBirth(new DateOfBirth(0, 0, 0)));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getFirstName_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getFirstName());
    }

    @Test
    @RequiresDevice
    public void test_getFirstName_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getFirstName() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getFirstName());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setFirstName_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setFirstName(new FirstName("")));
    }

    @Test
    @RequiresDevice
    public void test_setFirstName_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setFirstName(@NonNull FirstName firstName) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setFirstName(new FirstName("")));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getHeight_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getHeight());
    }

    @Test
    @RequiresDevice
    public void test_getHeight_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getHeight() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getHeight());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setHeight_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setHeight(new Height(0)));
    }

    @Test
    @RequiresDevice
    public void test_setHeight_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setHeight(@NonNull Height height) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setHeight(new Height(0)));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getGender_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getGender());
    }

    @Test
    @RequiresDevice
    public void test_getGender_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getGender() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getGender());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setGender_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setGender(new Gender(0)));
    }

    @Test
    @RequiresDevice
    public void test_setGender_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setGender(@NonNull Gender gender) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setGender(new Gender(0)));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrement_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getDatabaseChangeIncrement());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrement_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getDatabaseChangeIncrement() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getDatabaseChangeIncrement());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setDatabaseChangeIncrement_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(0)));
    }

    @Test
    @RequiresDevice
    public void test_setDatabaseChangeIncrement_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setDatabaseChangeIncrement(@NonNull DatabaseChangeIncrement databaseChangeIncrement) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(0)));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getDatabaseChangeIncrementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getDatabaseChangeIncrementClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startDatabaseChangeIncrementNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startDatabaseChangeIncrementNotification_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startDatabaseChangeIncrementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startDatabaseChangeIncrementNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopDatabaseChangeIncrementNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopDatabaseChangeIncrementNotification_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopDatabaseChangeIncrementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopDatabaseChangeIncrementNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getUserIndex_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getUserIndex());
    }

    @Test
    @RequiresDevice
    public void test_getUserIndex_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getUserIndex() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getUserIndex());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getRegisteredUserClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getRegisteredUserClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRegisteredUserClientCharacteristicConfiguration_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getRegisteredUserClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getRegisteredUserClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }


    @Test
    @RequiresDevice
    public void test_startRegisteredUserIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startRegisteredUserIndication());
    }

    @Test
    @RequiresDevice
    public void test_startRegisteredUserIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startRegisteredUserIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startRegisteredUserIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopRegisteredUserIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopRegisteredUserIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopRegisteredUserIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopRegisteredUserIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopRegisteredUserIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setUserControlPoint_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setUserControlPoint(new UserControlPoint(0, 0, 0, 0, 0, 0)));
    }

    @Test
    @RequiresDevice
    public void test_setUserControlPoint_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setUserControlPoint(@NonNull UserControlPoint userControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setUserControlPoint(new UserControlPoint(0, 0, 0, 0, 0, 0)));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getUserControlPointClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getUserControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getUserControlPointClientCharacteristicConfiguration_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getUserControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getUserControlPointClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startUserControlPointIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startUserControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startUserControlPointIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startUserControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startUserControlPointIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopUserControlPointIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopUserControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopUserControlPointIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopUserControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopUserControlPointIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBodyCompositionMeasurementClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBodyCompositionMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getBodyCompositionMeasurementClientCharacteristicConfiguration_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBodyCompositionMeasurementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBodyCompositionMeasurementClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBodyCompositionMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startBodyCompositionMeasurementIndication());
    }

    @Test
    @RequiresDevice
    public void test_startBodyCompositionMeasurementIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startBodyCompositionMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startBodyCompositionMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBodyCompositionMeasurementIndication_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopBodyCompositionMeasurementIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopBodyCompositionMeasurementIndication_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBodyCompositionService == null) {
                    mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBodyCompositionMeasurementIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopBodyCompositionMeasurementIndication());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCount_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelCount());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCount_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCount() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBatteryLevelCount());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevel());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBatteryLevel());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevel(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevel_00102() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevel(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBatteryLevel(0));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isBatteryLevelNotificatable());
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isBatteryLevelNotificatable());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isBatteryLevelNotificatable(0));
    }

    @Test
    @RequiresDevice
    public void test_isBatteryLevelNotificatable_00102() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isBatteryLevelNotificatable(0));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelCharacteristicPresentationFormat_00102() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBatteryLevelCharacteristicPresentationFormat(0));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration(0));
    }

    @Test
    @RequiresDevice
    public void test_getBatteryLevelClientCharacteristicConfiguration_00102() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getBatteryLevelClientCharacteristicConfiguration(0));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startBatteryLevelNotification());
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startBatteryLevelNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startBatteryLevelNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_startBatteryLevelNotification_00102() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startBatteryLevelNotification(0));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopBatteryLevelNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopBatteryLevelNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00101() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopBatteryLevelNotification(0));
    }

    @Test
    @RequiresDevice
    public void test_stopBatteryLevelNotification_00102() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mBatteryService == null) {
                    mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopBatteryLevelNotification(int index) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopBatteryLevelNotification(0));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isCurrentTimeCharacteristicWritable_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_isCurrentTimeCharacteristicWritable_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isCurrentTimeCharacteristicWritable());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicSupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isLocalTimeInformationCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicWritable_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicWritable_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isLocalTimeInformationCharacteristicWritable());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isReferenceTimeInformationCharacteristicSupported_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isReferenceTimeInformationCharacteristicSupported_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.isReferenceTimeInformationCharacteristicSupported());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTime_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getCurrentTime());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTime_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getCurrentTime() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getCurrentTime());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setCurrentTime(new CurrentTime(new byte[10])));
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setCurrentTime(@NonNull CurrentTime currentTime) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setCurrentTime(new CurrentTime(new byte[10])));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTimeClientCharacteristicConfiguration_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTimeClientCharacteristicConfiguration_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getCurrentTimeClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getCurrentTimeClientCharacteristicConfiguration());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startCurrentTimeNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.startCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCurrentTimeNotification_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer startCurrentTimeNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.startCurrentTimeNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopCurrentTimeNotification_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.stopCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCurrentTimeNotification_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer stopCurrentTimeNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.stopCurrentTimeNotification());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getLocalTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getLocalTimeInformation() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getLocalTimeInformation());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer setLocalTimeInformation(@NonNull LocalTimeInformation localTimeInformation) {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertNull(weightScaleProfile.getReferenceTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_00002() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null) {
                        @Override
                        public synchronized Integer getReferenceTimeInformation() {
                            return 1;
                        }
                    };
                }
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.getReferenceTimeInformation());
        weightScaleProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        assertTrue(weightScaleProfile.getDatabaseHelper() instanceof WeightScaleProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(weightScaleProfile.mWeightScaleService);
        assertNotNull(weightScaleProfile.mDeviceInformationService);
        assertNotNull(weightScaleProfile.mUserDataService);
        assertNotNull(weightScaleProfile.mBodyCompositionService);
        assertNotNull(weightScaleProfile.mBatteryService);
        assertNotNull(weightScaleProfile.mCurrentTimeService);
        assertTrue(atomicBoolean.get());
        weightScaleProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        WeightScaleProfile weightScaleProfile = new WeightScaleProfile(ApplicationProvider.getApplicationContext(), new BaseWeightScaleProfileCallback());
        weightScaleProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        weightScaleProfile.quit();
        assertNull(weightScaleProfile.mWeightScaleService);
        assertNull(weightScaleProfile.mDeviceInformationService);
        assertNull(weightScaleProfile.mUserDataService);
        assertNull(weightScaleProfile.mBodyCompositionService);
        assertNull(weightScaleProfile.mBatteryService);
        assertNull(weightScaleProfile.mCurrentTimeService);
    }

}
