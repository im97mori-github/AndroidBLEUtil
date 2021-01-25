package org.im97mori.ble.profile.ftmp.central;

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
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.profile.ftmp.central.db.FitnessMachineProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.ftms.central.FitnessMachineService;
import org.im97mori.ble.service.uds.central.UserDataService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.USER_DATA_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FitnessMachineProfileTest {

    @Test
    public void test_findBloodPressureProfileDevices_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.findFitnessMachineProfileDevices(null));
    }

    @Test
    public void test_findBloodPressureProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        fitnessMachineProfile.start();
        assertNotNull(fitnessMachineProfile.findFitnessMachineProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        fitnessMachineProfile.quit();
    }

    @Test
    public void test_hasUserDataService_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.hasUserDataService());
    }

    @Test
    public void test_hasUserDataService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        fitnessMachineProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(USER_DATA_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(fitnessMachineProfile.hasUserDataService());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        fitnessMachineProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(fitnessMachineProfile.hasDeviceInformationService());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isTreadmillDataCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_isTreadmillDataCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isTreadmillDataCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isCrossTrainerDataCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isCrossTrainerDataCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isCrossTrainerDataCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isStepClimberDataCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStepClimberDataCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isStepClimberDataCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isStairClimberDataCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStairClimberDataCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isStairClimberDataCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isRowerDataCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isRowerDataCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isRowerDataCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isIndoorBikeDataCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_isIndoorBikeDataCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isIndoorBikeDataCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isTrainingStatusCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_isTrainingStatusCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isTrainingStatusCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedSpeedRangeCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedSpeedRangeCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isSupportedSpeedRangeCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedInclinationRangeCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedInclinationRangeCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isSupportedInclinationRangeCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedResistanceLevelRangeCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedResistanceLevelRangeCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isSupportedResistanceLevelRangeCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedPowerRangeCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedPowerRangeCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isSupportedPowerRangeCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedHeartRateRangeCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedHeartRateRangeCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isSupportedHeartRateRangeCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFitnessMachineControlPointCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineControlPointCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isFitnessMachineControlPointCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFitnessMachineStatusCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineStatusCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isFitnessMachineStatusCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFirstNameCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFirstNameCharacteristicSupporeted());
    }

    @Test
    public void test_isFirstNameCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isFirstNameCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isWeightCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isWeightCharacteristicSupporeted());
    }

    @Test
    public void test_isWeightCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isWeightCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isGenderCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isGenderCharacteristicSupporeted());
    }

    @Test
    public void test_isGenderCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isGenderCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isHeightCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isHeightCharacteristicSupporeted());
    }

    @Test
    public void test_isHeightCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isHeightCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isAgeCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isAgeCharacteristicSupporeted());
    }

    @Test
    public void test_isAgeCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isAgeCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isDateOfBirthCharacteristicSupporeted());
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isDateOfBirthCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isHeartRateMaxCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isHeartRateMaxCharacteristicSupporeted());
    }

    @Test
    public void test_isHeartRateMaxCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isHeartRateMaxCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isRestingHeartRateCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isRestingHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isRestingHeartRateCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isRestingHeartRateCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isMaximumRecommendedHeartRateCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isMaximumRecommendedHeartRateCharacteristicSupporeted());
    }

    @Test
    public void test_isMaximumRecommendedHeartRateCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isMaximumRecommendedHeartRateCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isVO2MaxCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isVO2MaxCharacteristicSupporeted());
    }

    @Test
    public void test_isVO2MaxCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isVO2MaxCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isLanguageCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isLanguageCharacteristicSupporeted());
    }

    @Test
    public void test_isLanguageCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isLanguageCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isTwoZoneHeartRateLimitCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isTwoZoneHeartRateLimitCharacteristicSupporeted());
    }

    @Test
    public void test_isTwoZoneHeartRateLimitCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isTwoZoneHeartRateLimitCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isThreeZoneHeartRateLimitsCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isThreeZoneHeartRateLimitsCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isThreeZoneHeartRateLimitsCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFiveZoneHeartRateLimitsCharacteristicSupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
    }

    @Test
    public void test_isFiveZoneHeartRateLimitsCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isFiveZoneHeartRateLimitsCharacteristicSupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupporeted_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.isDatabaseChangeIncrementCharacteristicNotifySupporeted());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.hasManufacturerNameString());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_hasModelNumberString_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.hasModelNumberString());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getFitnessMachineFeature_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getFitnessMachineFeature());
    }

    @Test
    public void test_getFitnessMachineFeature_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getFitnessMachineFeature());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getTreadmillDataClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getTreadmillDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTreadmillDataClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isTreadmillDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getTreadmillDataClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startTreadmillDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startTreadmillDataNotification());
    }

    @Test
    public void test_startTreadmillDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isTreadmillDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startTreadmillDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopTreadmillDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopTreadmillDataNotification());
    }

    @Test
    public void test_stopTreadmillDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isTreadmillDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopTreadmillDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getCrossTrainerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isCrossTrainerDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getCrossTrainerDataClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startCrossTrainerDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startCrossTrainerDataNotification());
    }

    @Test
    public void test_startCrossTrainerDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isCrossTrainerDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startCrossTrainerDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopCrossTrainerDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopCrossTrainerDataNotification());
    }

    @Test
    public void test_stopCrossTrainerDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isCrossTrainerDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopCrossTrainerDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getStepClimberDataClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getStepClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStepClimberDataClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isStepClimberDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getStepClimberDataClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startStepClimberDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startStepClimberDataNotification());
    }

    @Test
    public void test_startStepClimberDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isStepClimberDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startStepClimberDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopStepClimberDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopStepClimberDataNotification());
    }

    @Test
    public void test_stopStepClimberDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isStepClimberDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopStepClimberDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getStairClimberDataClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getStairClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStairClimberDataClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isStairClimberDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getStairClimberDataClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startStairClimberDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startStairClimberDataNotification());
    }

    @Test
    public void test_startStairClimberDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isStairClimberDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startStairClimberDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopStairClimberDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopStairClimberDataNotification());
    }

    @Test
    public void test_stopStairClimberDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isStairClimberDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopStairClimberDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getRowerDataClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getRowerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRowerDataClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isRowerDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getRowerDataClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startRowerDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startRowerDataNotification());
    }

    @Test
    public void test_startRowerDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isRowerDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startRowerDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopRowerDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopRowerDataNotification());
    }

    @Test
    public void test_stopRowerDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isRowerDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopRowerDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getIndoorBikeDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isIndoorBikeDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getIndoorBikeDataClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startIndoorBikeDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startIndoorBikeDataNotification());
    }

    @Test
    public void test_startIndoorBikeDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isIndoorBikeDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startIndoorBikeDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopIndoorBikeDataNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopIndoorBikeDataNotification());
    }

    @Test
    public void test_stopIndoorBikeDataNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isIndoorBikeDataCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopIndoorBikeDataNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getTrainingStatus_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getTrainingStatus());
    }

    @Test
    public void test_getTrainingStatus_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isTrainingStatusCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getTrainingStatus());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getTrainingStatusClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getTrainingStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTrainingStatusClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isTrainingStatusCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getTrainingStatusClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startTrainingStatusNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startTrainingStatusNotification());
    }

    @Test
    public void test_startTrainingStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isTrainingStatusCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startTrainingStatusNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopTrainingStatusNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopTrainingStatusNotification());
    }

    @Test
    public void test_stopTrainingStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isTrainingStatusCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopTrainingStatusNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getSupportedSpeedRange_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getSupportedSpeedRange());
    }

    @Test
    public void test_getSupportedSpeedRange_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isSupportedSpeedRangeCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getSupportedSpeedRange());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getSupportedInclinationRange_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getSupportedInclinationRange());
    }

    @Test
    public void test_getSupportedInclinationRange_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isSupportedInclinationRangeCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getSupportedInclinationRange());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getSupportedResistanceLevelRange_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getSupportedResistanceLevelRange());
    }

    @Test
    public void test_getSupportedResistanceLevelRange_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isSupportedResistanceLevelRangeCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getSupportedResistanceLevelRange());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getSupportedPowerRange_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getSupportedPowerRange());
    }

    @Test
    public void test_getSupportedPowerRange_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isSupportedPowerRangeCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getSupportedPowerRange());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getSupportedHeartRateRange_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getSupportedHeartRateRange());
    }

    @Test
    public void test_getSupportedHeartRateRange_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isSupportedHeartRateRangeCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getSupportedHeartRateRange());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setFitnessMachineControlPoint_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0])));
    }

    @Test
    public void test_setFitnessMachineControlPoint_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0])));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getFitnessMachineControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getFitnessMachineControlPointClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startFitnessMachineControlPointIndication_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startFitnessMachineControlPointIndication());
    }

    @Test
    public void test_startFitnessMachineControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startFitnessMachineControlPointIndication());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopFitnessMachineControlPointIndication_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopFitnessMachineControlPointIndication());
    }

    @Test
    public void test_stopFitnessMachineControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopFitnessMachineControlPointIndication());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getFitnessMachineStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getFitnessMachineStatusClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startFitnessMachineStatusNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startFitnessMachineStatusNotification());
    }

    @Test
    public void test_startFitnessMachineStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startFitnessMachineStatusNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopFitnessMachineStatusNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopFitnessMachineStatusNotification());
    }

    @Test
    public void test_stopFitnessMachineStatusNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                        @Override
                        public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                            return true;
                        }
                    };
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopFitnessMachineStatusNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getDatabaseChangeIncrement_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getDatabaseChangeIncrement());
    }

    @Test
    public void test_getDatabaseChangeIncrement_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getDatabaseChangeIncrement());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setDatabaseChangeIncrement_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(1)));
    }

    @Test
    public void test_setDatabaseChangeIncrement_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setDatabaseChangeIncrement(new DatabaseChangeIncrement(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getDatabaseChangeIncrementClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_startDatabaseChangeIncrementNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startDatabaseChangeIncrementNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopDatabaseChangeIncrementNotification());
    }

    @Test
    public void test_stopDatabaseChangeIncrementNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isDatabaseChangeIncrementCharacteristicNotifySupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopDatabaseChangeIncrementNotification());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setUserControlPoint_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setUserControlPoint(new UserControlPoint(0, 0, 0, 0, 0, 0)));
    }

    @Test
    public void test_setUserControlPoint_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setUserControlPoint(new UserControlPoint(0, 0, 0, 0, 0, 0)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getUserControlPointClientCharacteristicConfiguration_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getUserControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUserControlPointClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getUserControlPointClientCharacteristicConfiguration());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_startUserControlPointIndication_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.startUserControlPointIndication());
    }

    @Test
    public void test_startUserControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.startUserControlPointIndication());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_stopUserControlPointIndication_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.stopUserControlPointIndication());
    }

    @Test
    public void test_stopUserControlPointIndication_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.stopUserControlPointIndication());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getUserIndex_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getUserIndex());
    }

    @Test
    public void test_getUserIndex_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getUserIndex());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getFirstName_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getFirstName());
    }

    @Test
    public void test_getFirstName_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isFirstNameCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getFirstName());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setFirstName_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setFirstName(new FirstName("firstName")));
    }

    @Test
    public void test_setFirstName_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isFirstNameCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setFirstName(new FirstName("firstName")));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getWeight_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getWeight());
    }

    @Test
    public void test_getWeight_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isWeightCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getWeight());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setWeight_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setWeight(new Weight(1)));
    }

    @Test
    public void test_setWeight_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isWeightCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setWeight(new Weight(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getGender_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getGender());
    }

    @Test
    public void test_getGender_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isGenderCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getGender());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setGender_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setGender(new Gender(1)));
    }

    @Test
    public void test_setGender_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isGenderCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setGender(new Gender(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getHeight_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getHeight());
    }

    @Test
    public void test_getHeight_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isHeightCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getHeight());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setHeight_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setHeight(new Height(1)));
    }

    @Test
    public void test_setHeight_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isHeightCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setHeight(new Height(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getAge_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getAge());
    }

    @Test
    public void test_getAge_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isAgeCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getAge());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setAge_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setAge(new Age(1)));
    }

    @Test
    public void test_setAge_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isAgeCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setAge(new Age(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getDateOfBirth_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getDateOfBirth());
    }

    @Test
    public void test_getDateOfBirth_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isDateOfBirthCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getDateOfBirth());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setDateOfBirth_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setDateOfBirth(new DateOfBirth(1, 2, 3)));
    }

    @Test
    public void test_setDateOfBirth_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isDateOfBirthCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setDateOfBirth(new DateOfBirth(1, 2, 3)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getHeartRateMax_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getHeartRateMax());
    }

    @Test
    public void test_getHeartRateMax_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isHeartRateMaxCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getHeartRateMax());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setHeartRateMax_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setHeartRateMax(new HeartRateMax(1)));
    }

    @Test
    public void test_setHeartRateMax_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isHeartRateMaxCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setHeartRateMax(new HeartRateMax(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getRestingHeartRate_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getRestingHeartRate());
    }

    @Test
    public void test_getRestingHeartRate_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isRestingHeartRateCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getRestingHeartRate());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setRestingHeartRate_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setRestingHeartRate(new RestingHeartRate(1)));
    }

    @Test
    public void test_setRestingHeartRate_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isRestingHeartRateCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setRestingHeartRate(new RestingHeartRate(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getMaximumRecommendedHeartRate_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_getMaximumRecommendedHeartRate_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isMaximumRecommendedHeartRateCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getMaximumRecommendedHeartRate());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setMaximumRecommendedHeartRate_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setMaximumRecommendedHeartRate(new MaximumRecommendedHeartRate(1)));
    }

    @Test
    public void test_setMaximumRecommendedHeartRate_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isMaximumRecommendedHeartRateCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setMaximumRecommendedHeartRate(new MaximumRecommendedHeartRate(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getVO2Max_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getVO2Max());
    }

    @Test
    public void test_getVO2Max_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isVO2MaxCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getVO2Max());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setVO2Max_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setVO2Max(new VO2Max(1)));
    }

    @Test
    public void test_setVO2Max_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isVO2MaxCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setVO2Max(new VO2Max(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getLanguage_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getLanguage());
    }

    @Test
    public void test_getLanguage_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isLanguageCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getLanguage());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setLanguage_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setLanguage(new Language("language")));
    }

    @Test
    public void test_setLanguage_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isLanguageCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setLanguage(new Language("language")));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getTwoZoneHeartRateLimit_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getTwoZoneHeartRateLimit());
    }

    @Test
    public void test_getTwoZoneHeartRateLimit_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isTwoZoneHeartRateLimitCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getTwoZoneHeartRateLimit());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setTwoZoneHeartRateLimit_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setTwoZoneHeartRateLimit(new TwoZoneHeartRateLimit(1)));
    }

    @Test
    public void test_setTwoZoneHeartRateLimit_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isTwoZoneHeartRateLimitCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setTwoZoneHeartRateLimit(new TwoZoneHeartRateLimit(1)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getThreeZoneHeartRateLimits_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getThreeZoneHeartRateLimits());
    }

    @Test
    public void test_getThreeZoneHeartRateLimits_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isThreeZoneHeartRateLimitsCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getThreeZoneHeartRateLimits());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setThreeZoneHeartRateLimits_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setThreeZoneHeartRateLimits(new ThreeZoneHeartRateLimits(1, 2)));
    }

    @Test
    public void test_setThreeZoneHeartRateLimits_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isThreeZoneHeartRateLimitsCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setThreeZoneHeartRateLimits(new ThreeZoneHeartRateLimits(1, 2)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getFiveZoneHeartRateLimits_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getFiveZoneHeartRateLimits());
    }

    @Test
    public void test_getFiveZoneHeartRateLimits_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isFiveZoneHeartRateLimitsCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getFiveZoneHeartRateLimits());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_setFiveZoneHeartRateLimits_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.setFiveZoneHeartRateLimits(new FiveZoneHeartRateLimits(1, 2, 3, 4)));
    }

    @Test
    public void test_setFiveZoneHeartRateLimits_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {

                        @Override
                        public boolean isFiveZoneHeartRateLimitsCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.setFiveZoneHeartRateLimits(new FiveZoneHeartRateLimits(1, 2, 3, 4)));
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null) {

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
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getManufacturerNameString());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getModelNumberString_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public boolean isConnected() {
                return true;
            }

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null) {

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
                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
                }
            }
        };
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.getModelNumberString());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertTrue(fitnessMachineProfile.getDatabaseHelper() instanceof FitnessMachineProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        fitnessMachineProfile.connect(MOCK_DEVICE);
        assertNotNull(fitnessMachineProfile.mFitnessMachineService);
        assertNotNull(fitnessMachineProfile.mDeviceInformationService);
        assertNotNull(fitnessMachineProfile.mUserDataService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        fitnessMachineProfile.connect(MOCK_DEVICE);
        fitnessMachineProfile.quit();
        assertNull(fitnessMachineProfile.mFitnessMachineService);
        assertNull(fitnessMachineProfile.mDeviceInformationService);
        assertNull(fitnessMachineProfile.mUserDataService);
    }

}
