package org.im97mori.ble.profile.ftmp.central;

import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
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
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.USER_DATA_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FitnessMachineProfileTest extends AbstractCentralTest {

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
    public void test_findFitnessMachineProfileDevices_00001() {
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.hasUserDataService());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_hasUserDataService_00003() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = fitnessMachineProfile.hasUserDataService();
        fitnessMachineProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void test_hasUserDataService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(USER_DATA_SERVICE, 0);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        fitnessMachineProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = fitnessMachineProfile.hasUserDataService();
        fitnessMachineProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void test_hasDeviceInformationService_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.hasDeviceInformationService());
    }

    @Test
    public void test_hasDeviceInformationService_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.hasDeviceInformationService());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_hasDeviceInformationService_00003() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = fitnessMachineProfile.hasDeviceInformationService();
        fitnessMachineProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void test_hasDeviceInformationService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);

        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        fitnessMachineProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = fitnessMachineProfile.hasDeviceInformationService();
        fitnessMachineProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void test_isTreadmillDataCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isTreadmillDataCharacteristicSupported());
    }

    @Test
    public void test_isTreadmillDataCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isTreadmillDataCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isCrossTrainerDataCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    public void test_isCrossTrainerDataCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isCrossTrainerDataCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isStepClimberDataCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isStepClimberDataCharacteristicSupported());
    }

    @Test
    public void test_isStepClimberDataCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isStepClimberDataCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isStairClimberDataCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isStairClimberDataCharacteristicSupported());
    }

    @Test
    public void test_isStairClimberDataCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isStairClimberDataCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isRowerDataCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isRowerDataCharacteristicSupported());
    }

    @Test
    public void test_isRowerDataCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isRowerDataCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isIndoorBikeDataCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    public void test_isIndoorBikeDataCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isIndoorBikeDataCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isTrainingStatusCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isTrainingStatusCharacteristicSupported());
    }

    @Test
    public void test_isTrainingStatusCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isTrainingStatusCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedSpeedRangeCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    public void test_isSupportedSpeedRangeCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isSupportedSpeedRangeCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedInclinationRangeCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    public void test_isSupportedInclinationRangeCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isSupportedInclinationRangeCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedResistanceLevelRangeCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    public void test_isSupportedResistanceLevelRangeCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isSupportedResistanceLevelRangeCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedPowerRangeCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    public void test_isSupportedPowerRangeCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isSupportedPowerRangeCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isSupportedHeartRateRangeCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    public void test_isSupportedHeartRateRangeCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isSupportedHeartRateRangeCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFitnessMachineControlPointCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    public void test_isFitnessMachineControlPointCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isFitnessMachineControlPointCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFitnessMachineStatusCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    public void test_isFitnessMachineStatusCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isFitnessMachineStatusCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFirstNameCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFirstNameCharacteristicSupported());
    }

    @Test
    public void test_isFirstNameCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isFirstNameCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isWeightCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isWeightCharacteristicSupported());
    }

    @Test
    public void test_isWeightCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isWeightCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isGenderCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isGenderCharacteristicSupported());
    }

    @Test
    public void test_isGenderCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isGenderCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isHeightCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isHeightCharacteristicSupported());
    }

    @Test
    public void test_isHeightCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isHeightCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isAgeCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isAgeCharacteristicSupported());
    }

    @Test
    public void test_isAgeCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isAgeCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isDateOfBirthCharacteristicSupported());
    }

    @Test
    public void test_isDateOfBirthCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isDateOfBirthCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isHeartRateMaxCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isHeartRateMaxCharacteristicSupported());
    }

    @Test
    public void test_isHeartRateMaxCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isHeartRateMaxCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isRestingHeartRateCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isRestingHeartRateCharacteristicSupported());
    }

    @Test
    public void test_isRestingHeartRateCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isRestingHeartRateCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isMaximumRecommendedHeartRateCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isMaximumRecommendedHeartRateCharacteristicSupported());
    }

    @Test
    public void test_isMaximumRecommendedHeartRateCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isMaximumRecommendedHeartRateCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isVO2MaxCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isVO2MaxCharacteristicSupported());
    }

    @Test
    public void test_isVO2MaxCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isVO2MaxCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isLanguageCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isLanguageCharacteristicSupported());
    }

    @Test
    public void test_isLanguageCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isLanguageCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isTwoZoneHeartRateLimitCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isTwoZoneHeartRateLimitCharacteristicSupported());
    }

    @Test
    public void test_isTwoZoneHeartRateLimitCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isTwoZoneHeartRateLimitCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isThreeZoneHeartRateLimitsCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isThreeZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    public void test_isThreeZoneHeartRateLimitsCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isThreeZoneHeartRateLimitsCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isFiveZoneHeartRateLimitsCharacteristicSupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isFiveZoneHeartRateLimitsCharacteristicSupported());
    }

    @Test
    public void test_isFiveZoneHeartRateLimitsCharacteristicSupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isFiveZoneHeartRateLimitsCharacteristicSupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupported_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.isDatabaseChangeIncrementCharacteristicNotifySupported());
    }

    @Test
    public void test_isDatabaseChangeIncrementCharacteristicNotifySupported_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.isDatabaseChangeIncrementCharacteristicNotifySupported());
        fitnessMachineProfile.disconnect();
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        assertNull(fitnessMachineProfile.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getFitnessMachineFeature() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getTreadmillDataClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startTreadmillDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopTreadmillDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getCrossTrainerDataClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startCrossTrainerDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopCrossTrainerDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getStepClimberDataClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startStepClimberDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopStepClimberDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getStairClimberDataClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startStairClimberDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopStairClimberDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getRowerDataClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startRowerDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopRowerDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getIndoorBikeDataClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startIndoorBikeDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopIndoorBikeDataNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrainingStatus() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getTrainingStatusClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startTrainingStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopTrainingStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getSupportedSpeedRange() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getSupportedInclinationRange() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getSupportedResistanceLevelRange() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getSupportedPowerRange() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getSupportedHeartRateRange() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setFitnessMachineControlPoint(@NonNull FitnessMachineControlPoint fitnessMachineControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getFitnessMachineControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startFitnessMachineControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopFitnessMachineControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getFitnessMachineStatusClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startFitnessMachineStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mFitnessMachineService == null) {
                    mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopFitnessMachineStatusNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getDatabaseChangeIncrement() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setDatabaseChangeIncrement(@NonNull DatabaseChangeIncrement databaseChangeIncrement) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getDatabaseChangeIncrementClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startDatabaseChangeIncrementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopDatabaseChangeIncrementNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setUserControlPoint(@NonNull UserControlPoint userControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getUserControlPointClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer startUserControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer stopUserControlPointIndication() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getUserIndex() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getFirstName() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setFirstName(@NonNull FirstName firstName) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getWeight() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setWeight(@NonNull Weight weight) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getGender() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setGender(@NonNull Gender gender) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getHeight() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setHeight(@NonNull Height height) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getAge() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setAge(@NonNull Age age) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getDateOfBirth() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setDateOfBirth(@NonNull DateOfBirth dateOfBirth) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getHeartRateMax() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setHeartRateMax(@NonNull HeartRateMax heartRateMax) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getRestingHeartRate() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setRestingHeartRate(@NonNull RestingHeartRate restingHeartRate) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getMaximumRecommendedHeartRate() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setMaximumRecommendedHeartRate(@NonNull MaximumRecommendedHeartRate maximumRecommendedHeartRate) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getVO2Max() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setVO2Max(@NonNull VO2Max vo2Max) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getLanguage() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setLanguage(@NonNull Language language) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getTwoZoneHeartRateLimit() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setTwoZoneHeartRateLimit(@NonNull TwoZoneHeartRateLimit twoZoneHeartRateLimit) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getThreeZoneHeartRateLimits() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setThreeZoneHeartRateLimits(@NonNull ThreeZoneHeartRateLimits threeZoneHeartRateLimits) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getFiveZoneHeartRateLimits() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mUserDataService == null) {
                    mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer setFiveZoneHeartRateLimits(@NonNull FiveZoneHeartRateLimits fiveZoneHeartRateLimits) {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getManufacturerNameString() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback()) {
            @Override
            public synchronized void createServices() {

                if (mDeviceInformationService == null) {
                    mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null) {
                        @Override
                        public synchronized Integer getModelNumberString() {
                            return 1;
                        }
                    };
                }
            }
        };
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
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
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(fitnessMachineProfile.mFitnessMachineService);
        assertNotNull(fitnessMachineProfile.mDeviceInformationService);
        assertNotNull(fitnessMachineProfile.mUserDataService);
        assertTrue(atomicBoolean.get());
        fitnessMachineProfile.quit();
    }

    @Test
    public void test_quit_00001() {
        FitnessMachineProfile fitnessMachineProfile = new FitnessMachineProfile(ApplicationProvider.getApplicationContext(), new BaseFitnessMachineProfileCallback());
        fitnessMachineProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        fitnessMachineProfile.quit();
        assertNull(fitnessMachineProfile.mFitnessMachineService);
        assertNull(fitnessMachineProfile.mDeviceInformationService);
        assertNull(fitnessMachineProfile.mUserDataService);
    }

}
