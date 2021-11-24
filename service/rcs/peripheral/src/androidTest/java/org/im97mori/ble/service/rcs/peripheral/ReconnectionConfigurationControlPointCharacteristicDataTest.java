package org.im97mori.ble.service.rcs.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("ConstantConditions")
public class ReconnectionConfigurationControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        Gson gson = new Gson();
        ReconnectionConfigurationControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), ReconnectionConfigurationControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.enableDisconnectResultCodes, result2.enableDisconnectResultCodes);
        assertEquals(result1.getActualCommunicationParametersResultCodes, result2.getActualCommunicationParametersResultCodes);
        assertEquals(result1.proposeSettingsResultCodes, result2.proposeSettingsResultCodes);
        assertEquals(result1.proposeSettingsError, result2.proposeSettingsError);
        assertEquals(result1.activateStoredSettingsResultCodes, result2.activateStoredSettingsResultCodes);
        assertEquals(result1.getMaxValuesResultCodes, result2.getMaxValuesResultCodes);
        assertArrayEquals(result1.maxValues, result2.maxValues);
        assertEquals(result1.getMinValuesResultCodes, result2.getMinValuesResultCodes);
        assertArrayEquals(result1.minValues, result2.minValues);
        assertEquals(result1.getStoredValuesResultCodes, result2.getStoredValuesResultCodes);
        assertArrayEquals(result1.getStoredValuesOperand, result2.getStoredValuesOperand);
        assertEquals(result1.setWhiteListTimerResultCodes, result2.setWhiteListTimerResultCodes);
        assertArrayEquals(result1.getWhiteListTimerOperand, result2.getWhiteListTimerOperand);
        assertEquals(result1.setAdvertisementConfigurationResultCodes, result2.setAdvertisementConfigurationResultCodes);
        assertEquals(result1.upgradeToLescOnlyResultCodes, result2.upgradeToLescOnlyResultCodes);
        assertEquals(result1.switchOobPairingResultCodes, result2.switchOobPairingResultCodes);
        assertEquals(result1.limitedAccessResultCodes, result2.limitedAccessResultCodes);
        assertArrayEquals(result1.currentSetting, result2.currentSetting);
        assertEquals(result1.isRcFeaturesE2eCrcSupported, result2.isRcFeaturesE2eCrcSupported);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        Gson gson = new Gson();
        ReconnectionConfigurationControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), ReconnectionConfigurationControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.enableDisconnectResultCodes, result2.enableDisconnectResultCodes);
        assertEquals(result1.getActualCommunicationParametersResultCodes, result2.getActualCommunicationParametersResultCodes);
        assertEquals(result1.proposeSettingsResultCodes, result2.proposeSettingsResultCodes);
        assertEquals(result1.proposeSettingsError, result2.proposeSettingsError);
        assertEquals(result1.activateStoredSettingsResultCodes, result2.activateStoredSettingsResultCodes);
        assertEquals(result1.getMaxValuesResultCodes, result2.getMaxValuesResultCodes);
        assertArrayEquals(result1.maxValues, result2.maxValues);
        assertEquals(result1.getMinValuesResultCodes, result2.getMinValuesResultCodes);
        assertArrayEquals(result1.minValues, result2.minValues);
        assertEquals(result1.getStoredValuesResultCodes, result2.getStoredValuesResultCodes);
        assertArrayEquals(result1.getStoredValuesOperand, result2.getStoredValuesOperand);
        assertEquals(result1.setWhiteListTimerResultCodes, result2.setWhiteListTimerResultCodes);
        assertArrayEquals(result1.getWhiteListTimerOperand, result2.getWhiteListTimerOperand);
        assertEquals(result1.setAdvertisementConfigurationResultCodes, result2.setAdvertisementConfigurationResultCodes);
        assertEquals(result1.upgradeToLescOnlyResultCodes, result2.upgradeToLescOnlyResultCodes);
        assertEquals(result1.switchOobPairingResultCodes, result2.switchOobPairingResultCodes);
        assertEquals(result1.limitedAccessResultCodes, result2.limitedAccessResultCodes);
        assertArrayEquals(result1.currentSetting, result2.currentSetting);
        assertEquals(result1.isRcFeaturesE2eCrcSupported, result2.isRcFeaturesE2eCrcSupported);
    }

    @Test
    public void test_setEnableDisconnectResultCodes_00001() {
        int firstEnableDisconnectResultCodes = 3;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstEnableDisconnectResultCodes, result1.enableDisconnectResultCodes);

        int secondEnableDisconnectResultCodes = 33;
        result1.enableDisconnectResultCodes = secondEnableDisconnectResultCodes;
        assertEquals(secondEnableDisconnectResultCodes, result1.enableDisconnectResultCodes);
    }

    @Test
    public void test_setGetActualCommunicationParametersResultCodes_00001() {
        int firstGetActualCommunicationParametersResultCodes = 4;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , firstGetActualCommunicationParametersResultCodes
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstGetActualCommunicationParametersResultCodes, result1.getActualCommunicationParametersResultCodes);

        int secondGetActualCommunicationParametersResultCodes = 44;
        result1.getActualCommunicationParametersResultCodes = secondGetActualCommunicationParametersResultCodes;
        assertEquals(secondGetActualCommunicationParametersResultCodes, result1.getActualCommunicationParametersResultCodes);
    }

    @Test
    public void test_setProposeSettingsResultCodes_00001() {
        int firstProposeSettingsResultCodes = 5;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstProposeSettingsResultCodes, result1.proposeSettingsResultCodes);

        int secondProposeSettingsResultCodes = 55;
        result1.proposeSettingsResultCodes = secondProposeSettingsResultCodes;
        assertEquals(secondProposeSettingsResultCodes, result1.proposeSettingsResultCodes);
    }

    @Test
    public void test_setProposeSettingsError_00001() {
        int firstProposeSettingsError = 6;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , firstProposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstProposeSettingsError, result1.proposeSettingsError);

        int secondProposeSettingsError = 66;
        result1.proposeSettingsError = secondProposeSettingsError;
        assertEquals(secondProposeSettingsError, result1.proposeSettingsError);
    }

    @Test
    public void test_setActivateStoredSettingsResultCodes_00001() {
        int firstActivateStoredSettingsResultCodes = 7;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstActivateStoredSettingsResultCodes, result1.activateStoredSettingsResultCodes);

        int secondActivateStoredSettingsResultCodes = 77;
        result1.activateStoredSettingsResultCodes = secondActivateStoredSettingsResultCodes;
        assertEquals(secondActivateStoredSettingsResultCodes, result1.activateStoredSettingsResultCodes);
    }

    @Test
    public void test_setGetMaxValuesResultCodes_00001() {
        int firstGetMaxValuesResultCodes = 8;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstGetMaxValuesResultCodes
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstGetMaxValuesResultCodes, result1.getMaxValuesResultCodes);

        int secondGetMaxValuesResultCodes = 88;
        result1.getMaxValuesResultCodes = secondGetMaxValuesResultCodes;
        assertEquals(secondGetMaxValuesResultCodes, result1.getMaxValuesResultCodes);
    }

    @Test
    public void test_setMaxValues_00001() {
        byte[] firstMaxValues = new byte[]{9};
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , firstMaxValues
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertArrayEquals(firstMaxValues, result1.maxValues);

        byte[] secondMaxValues = new byte[]{99};
        result1.maxValues = secondMaxValues;
        assertArrayEquals(secondMaxValues, result1.maxValues);
    }

    @Test
    public void test_setGetMinValuesResultCodes_00001() {
        int firstGetMinValuesResultCodes = 10;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , firstGetMinValuesResultCodes
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstGetMinValuesResultCodes, result1.getMinValuesResultCodes);

        int secondGetMinValuesResultCodes = 110;
        result1.getMinValuesResultCodes = secondGetMinValuesResultCodes;
        assertEquals(secondGetMinValuesResultCodes, result1.getMinValuesResultCodes);
    }

    @Test
    public void test_setMinValues_00001() {
        byte[] firstMinValues = new byte[]{11};
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , firstMinValues
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertArrayEquals(firstMinValues, result1.minValues);

        byte[] secondMinValues = new byte[]{111};
        result1.minValues = secondMinValues;
        assertArrayEquals(secondMinValues, result1.minValues);
    }

    @Test
    public void test_setGetStoredValuesResultCodes_00001() {
        int firstGetStoredValuesResultCodes = 12;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstGetStoredValuesResultCodes, result1.getStoredValuesResultCodes);

        int secondGetStoredValuesResultCodes = 112;
        result1.getStoredValuesResultCodes = secondGetStoredValuesResultCodes;
        assertEquals(secondGetStoredValuesResultCodes, result1.getStoredValuesResultCodes);
    }

    @Test
    public void test_setGetStoredValuesOperand_00001() {
        byte[] firstGetStoredValuesOperand = new byte[]{13};
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , firstGetStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertArrayEquals(firstGetStoredValuesOperand, result1.getStoredValuesOperand);

        byte[] secondGetStoredValuesOperand = new byte[]{113};
        result1.getStoredValuesOperand = secondGetStoredValuesOperand;
        assertArrayEquals(secondGetStoredValuesOperand, result1.getStoredValuesOperand);
    }

    @Test
    public void test_setSetWhiteListTimerResultCodes_00001() {
        int firstSetWhiteListTimerResultCodes = 14;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstSetWhiteListTimerResultCodes, result1.setWhiteListTimerResultCodes);

        int secondSetWhiteListTimerResultCodes = 114;
        result1.setWhiteListTimerResultCodes = secondSetWhiteListTimerResultCodes;
        assertEquals(secondSetWhiteListTimerResultCodes, result1.setWhiteListTimerResultCodes);
    }

    @Test
    public void test_setGetWhiteListTimerResultCodes_00001() {
        int firstGetWhiteListTimerResultCodes = 15;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , firstGetWhiteListTimerResultCodes
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstGetWhiteListTimerResultCodes, result1.getWhiteListTimerResultCodes);

        int secondGetWhiteListTimerResultCodes = 116;
        result1.getWhiteListTimerResultCodes = secondGetWhiteListTimerResultCodes;
        assertEquals(secondGetWhiteListTimerResultCodes, result1.getWhiteListTimerResultCodes);
    }

    @Test
    public void test_setGetWhiteListTimerOperand_00001() {
        byte[] firstGetWhiteListTimerOperand = new byte[]{16};
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , firstGetWhiteListTimerOperand
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertArrayEquals(firstGetWhiteListTimerOperand, result1.getWhiteListTimerOperand);

        byte[] secondGetWhiteListTimerOperand = new byte[]{117};
        result1.getWhiteListTimerOperand = secondGetWhiteListTimerOperand;
        assertArrayEquals(secondGetWhiteListTimerOperand, result1.getWhiteListTimerOperand);
    }

    @Test
    public void test_setSetAdvertisementConfigurationResultCodes_00001() {
        int firstSetAdvertisementConfigurationResultCodes = 17;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstSetAdvertisementConfigurationResultCodes, result1.setAdvertisementConfigurationResultCodes);

        int secondSetAdvertisementConfigurationResultCodes = 118;
        result1.setAdvertisementConfigurationResultCodes = secondSetAdvertisementConfigurationResultCodes;
        assertEquals(secondSetAdvertisementConfigurationResultCodes, result1.setAdvertisementConfigurationResultCodes);
    }

    @Test
    public void test_setUpgradeToLescOnlyResultCodes_00001() {
        int firstUpgradeToLescOnlyResultCodes = 18;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstUpgradeToLescOnlyResultCodes, result1.upgradeToLescOnlyResultCodes);

        int secondUpgradeToLescOnlyResultCodes = 119;
        result1.upgradeToLescOnlyResultCodes = secondUpgradeToLescOnlyResultCodes;
        assertEquals(secondUpgradeToLescOnlyResultCodes, result1.upgradeToLescOnlyResultCodes);
    }

    @Test
    public void test_setSwitchOobPairingResultCodes_00001() {
        int firstSwitchOobPairingResultCodes = 19;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , new byte[]{21}
                , true);

        assertEquals(firstSwitchOobPairingResultCodes, result1.switchOobPairingResultCodes);

        int secondSwitchOobPairingResultCodes = 120;
        result1.switchOobPairingResultCodes = secondSwitchOobPairingResultCodes;
        assertEquals(secondSwitchOobPairingResultCodes, result1.switchOobPairingResultCodes);
    }

    @Test
    public void test_setLimitedAccessResultCodes_00001() {
        int firstLimitedAccessResultCodes = 20;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , new byte[]{21}
                , true);

        assertEquals(firstLimitedAccessResultCodes, result1.limitedAccessResultCodes);

        int secondLimitedAccessResultCodes = 121;
        result1.limitedAccessResultCodes = secondLimitedAccessResultCodes;
        assertEquals(secondLimitedAccessResultCodes, result1.limitedAccessResultCodes);
    }

    @Test
    public void test_setCurrentSetting_00001() {
        byte[] firstCurrentSetting = new byte[]{21};
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , firstCurrentSetting
                , true);

        assertArrayEquals(firstCurrentSetting, result1.currentSetting);

        byte[] secondCurrentSetting = new byte[]{122};
        result1.currentSetting = secondCurrentSetting;
        assertArrayEquals(secondCurrentSetting, result1.currentSetting);
    }

    @Test
    public void test_setIsRcFeaturesE2eCrcSupported_00001() {
        boolean firstIsRcFeaturesE2eCrcSupported = false;
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , firstIsRcFeaturesE2eCrcSupported);

        assertEquals(firstIsRcFeaturesE2eCrcSupported, result1.isRcFeaturesE2eCrcSupported);

        boolean secondIsRcFeaturesE2eCrcSupported = true;
        result1.isRcFeaturesE2eCrcSupported = secondIsRcFeaturesE2eCrcSupported;
        assertEquals(secondIsRcFeaturesE2eCrcSupported, result1.isRcFeaturesE2eCrcSupported);
    }

    @Test
    public void test_getBytes_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstEnableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , firstEnableDisconnectResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstEnableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , firstEnableDisconnectResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstEnableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , firstEnableDisconnectResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00101() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstGetActualCommunicationParametersResultCodes
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , firstGetActualCommunicationParametersResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00102() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstGetActualCommunicationParametersResultCodes
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , firstGetActualCommunicationParametersResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00103() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstGetActualCommunicationParametersResultCodes
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00201() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00202() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00203() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00204() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00205() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00206() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00207() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00208() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00301() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00302() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00303() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00304() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00305() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00306() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00401() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] maxValues = new byte[]{9};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstGetMaxValuesResultCodes
                , maxValues
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , firstGetMaxValuesResultCodes
                , maxValues).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00402() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] maxValues = new byte[]{9};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstGetMaxValuesResultCodes
                , maxValues
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , firstGetMaxValuesResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00403() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] maxValues = new byte[]{9};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstGetMaxValuesResultCodes
                , maxValues
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , firstGetMaxValuesResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00501() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] minValues = new byte[]{11};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , firstGetMinValuesResultCodes
                , minValues
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , firstGetMinValuesResultCodes
                , minValues).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00502() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] minValues = new byte[]{11};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , firstGetMinValuesResultCodes
                , minValues
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , firstGetMinValuesResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00503() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] minValues = new byte[]{11};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , firstGetMinValuesResultCodes
                , minValues
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , firstGetMinValuesResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00601() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00602() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00603() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00604() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00701() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00702() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00703() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00704() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00801() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getWhiteListTimerOperand = new byte[]{16};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00802() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getWhiteListTimerOperand = new byte[]{16};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , firstGetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0,
                currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00803() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getWhiteListTimerOperand = new byte[]{16};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstGetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , firstGetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0,
                currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00901() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00902() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00903() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00904() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01004() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01101() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01102() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01103() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01104() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01201() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01202() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01203() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_01204() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstEnableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , firstEnableDisconnectResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstEnableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , firstEnableDisconnectResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstEnableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , firstEnableDisconnectResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10101() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstGetActualCommunicationParametersResultCodes
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , firstGetActualCommunicationParametersResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10102() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstGetActualCommunicationParametersResultCodes
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , firstGetActualCommunicationParametersResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10103() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstGetActualCommunicationParametersResultCodes
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10201() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10202() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10203() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10204() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10205() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10206() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10207() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10208() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        int proposeSettingsError = 6;
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstProposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , firstProposeSettingsResultCodes
                , new byte[]{(byte) proposeSettingsError}).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10301() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10302() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10303() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10304() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10305() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10306() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstActivateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETERS_REJECTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstActivateStoredSettingsResultCodes
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , firstActivateStoredSettingsResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10401() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] maxValues = new byte[]{9};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstGetMaxValuesResultCodes
                , maxValues
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , firstGetMaxValuesResultCodes
                , maxValues).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10402() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] maxValues = new byte[]{9};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstGetMaxValuesResultCodes
                , maxValues
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , firstGetMaxValuesResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10403() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] maxValues = new byte[]{9};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstGetMaxValuesResultCodes
                , maxValues
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , firstGetMaxValuesResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10501() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] minValues = new byte[]{11};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , firstGetMinValuesResultCodes
                , minValues
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , firstGetMinValuesResultCodes
                , minValues).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10502() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] minValues = new byte[]{11};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , firstGetMinValuesResultCodes
                , minValues
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , firstGetMinValuesResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10503() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] minValues = new byte[]{11};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , firstGetMinValuesResultCodes
                , minValues
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , firstGetMinValuesResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10601() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10602() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10603() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10604() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getStoredValuesOperand = new byte[]{13};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , firstGetStoredValuesResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10701() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10702() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10703() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10704() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , firstSetWhiteListTimerResultCodes
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , firstSetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10801() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getWhiteListTimerOperand = new byte[]{16};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10802() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getWhiteListTimerOperand = new byte[]{16};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , firstGetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0,
                currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10803() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] getWhiteListTimerOperand = new byte[]{16};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstGetWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , firstGetWhiteListTimerResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                , new byte[0]
                , null
                , 0
                , 0,
                currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10901() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10902() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10903() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_10904() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSetAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , firstSetAdvertisementConfigurationResultCodes
                , 18
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , firstSetAdvertisementConfigurationResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11004() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstUpgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , firstUpgradeToLescOnlyResultCodes
                , 19
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , firstUpgradeToLescOnlyResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11101() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11102() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11103() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11104() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstSwitchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , firstSwitchOobPairingResultCodes
                , 20
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , firstSwitchOobPairingResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11201() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11202() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11203() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_11204() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(firstData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(firstData);
        byteBuffer.putShort((short) BLEUtils.createCrc(firstData, 0, firstData.length));
        firstData = byteBuffer.array();
        int firstLimitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , firstLimitedAccessResultCodes
                , currentSetting
                , true);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , new byte[0]
                , null
                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , firstLimitedAccessResultCodes
                , new byte[0]).getBytes();
        byteBuffer = ByteBuffer.allocate(secondData.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(secondData);
        byteBuffer.putShort((short) BLEUtils.createCrc(secondData, 0, secondData.length));
        secondData = byteBuffer.array();
        reconnectionConfigurationControlPointCharacteristicData.currentData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_20001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        byte[] currentSetting = new byte[]{21};
        byte[] firstData = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                , new byte[0]
                , null
                , 0
                , 0
                , currentSetting).getBytes();
        int firstEnableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED;
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstEnableDisconnectResultCodes
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , currentSetting
                , false);
        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        byte[] secondData = new byte[]{26};
        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = secondData;
        assertArrayEquals(secondData, reconnectionConfigurationControlPointCharacteristicData.getBytes());

        assertArrayEquals(firstData, reconnectionConfigurationControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_parcelable_00001() {
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointCharacteristicData result2 = ReconnectionConfigurationControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.enableDisconnectResultCodes, result2.enableDisconnectResultCodes);
        assertEquals(result1.getActualCommunicationParametersResultCodes, result2.getActualCommunicationParametersResultCodes);
        assertEquals(result1.proposeSettingsResultCodes, result2.proposeSettingsResultCodes);
        assertEquals(result1.proposeSettingsError, result2.proposeSettingsError);
        assertEquals(result1.activateStoredSettingsResultCodes, result2.activateStoredSettingsResultCodes);
        assertEquals(result1.getMaxValuesResultCodes, result2.getMaxValuesResultCodes);
        assertArrayEquals(result1.maxValues, result2.maxValues);
        assertEquals(result1.getMinValuesResultCodes, result2.getMinValuesResultCodes);
        assertArrayEquals(result1.minValues, result2.minValues);
        assertEquals(result1.getStoredValuesResultCodes, result2.getStoredValuesResultCodes);
        assertArrayEquals(result1.getStoredValuesOperand, result2.getStoredValuesOperand);
        assertEquals(result1.setWhiteListTimerResultCodes, result2.setWhiteListTimerResultCodes);
        assertArrayEquals(result1.getWhiteListTimerOperand, result2.getWhiteListTimerOperand);
        assertEquals(result1.setAdvertisementConfigurationResultCodes, result2.setAdvertisementConfigurationResultCodes);
        assertEquals(result1.upgradeToLescOnlyResultCodes, result2.upgradeToLescOnlyResultCodes);
        assertEquals(result1.switchOobPairingResultCodes, result2.switchOobPairingResultCodes);
        assertEquals(result1.limitedAccessResultCodes, result2.limitedAccessResultCodes);
        assertArrayEquals(result1.currentSetting, result2.currentSetting);
        assertEquals(result1.isRcFeaturesE2eCrcSupported, result2.isRcFeaturesE2eCrcSupported);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , new byte[]{13}
                , 14
                , 15
                , new byte[]{16}
                , 17
                , 18
                , 19
                , 20
                , new byte[]{21}
                , true);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationControlPointCharacteristicData result2 = ReconnectionConfigurationControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.enableDisconnectResultCodes, result2.enableDisconnectResultCodes);
        assertEquals(result1.getActualCommunicationParametersResultCodes, result2.getActualCommunicationParametersResultCodes);
        assertEquals(result1.proposeSettingsResultCodes, result2.proposeSettingsResultCodes);
        assertEquals(result1.proposeSettingsError, result2.proposeSettingsError);
        assertEquals(result1.activateStoredSettingsResultCodes, result2.activateStoredSettingsResultCodes);
        assertEquals(result1.getMaxValuesResultCodes, result2.getMaxValuesResultCodes);
        assertArrayEquals(result1.maxValues, result2.maxValues);
        assertEquals(result1.getMinValuesResultCodes, result2.getMinValuesResultCodes);
        assertArrayEquals(result1.minValues, result2.minValues);
        assertEquals(result1.getStoredValuesResultCodes, result2.getStoredValuesResultCodes);
        assertArrayEquals(result1.getStoredValuesOperand, result2.getStoredValuesOperand);
        assertEquals(result1.setWhiteListTimerResultCodes, result2.setWhiteListTimerResultCodes);
        assertArrayEquals(result1.getWhiteListTimerOperand, result2.getWhiteListTimerOperand);
        assertEquals(result1.setAdvertisementConfigurationResultCodes, result2.setAdvertisementConfigurationResultCodes);
        assertEquals(result1.upgradeToLescOnlyResultCodes, result2.upgradeToLescOnlyResultCodes);
        assertEquals(result1.switchOobPairingResultCodes, result2.switchOobPairingResultCodes);
        assertEquals(result1.limitedAccessResultCodes, result2.limitedAccessResultCodes);
        assertArrayEquals(result1.currentSetting, result2.currentSetting);
        assertEquals(result1.isRcFeaturesE2eCrcSupported, result2.isRcFeaturesE2eCrcSupported);
    }

    @Test
    public void test_hashCode_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertEquals(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(enableDisconnectResultCodes).hashCode()
                        ^ Integer.valueOf(getActualCommunicationParametersResultCodes).hashCode()
                        ^ Integer.valueOf(proposeSettingsResultCodes).hashCode()
                        ^ Integer.valueOf(proposeSettingsError).hashCode()
                        ^ Integer.valueOf(activateStoredSettingsResultCodes).hashCode()
                        ^ Integer.valueOf(getMaxValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(maxValues)
                        ^ Integer.valueOf(getMinValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(minValues)
                        ^ Integer.valueOf(getStoredValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(getStoredValuesOperand)
                        ^ Integer.valueOf(setWhiteListTimerResultCodes).hashCode()
                        ^ Integer.valueOf(getWhiteListTimerResultCodes).hashCode()
                        ^ Arrays.hashCode(getWhiteListTimerOperand)
                        ^ Integer.valueOf(setAdvertisementConfigurationResultCodes).hashCode()
                        ^ Integer.valueOf(upgradeToLescOnlyResultCodes).hashCode()
                        ^ Integer.valueOf(switchOobPairingResultCodes).hashCode()
                        ^ Integer.valueOf(limitedAccessResultCodes).hashCode()
                        ^ Arrays.hashCode(currentSetting)
                        ^ Boolean.valueOf(isRcFeaturesE2eCrcSupported).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;
        byte[] currentData = new byte[]{26};
        Map<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(27, new byte[]{28});

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);

        assertNotEquals(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ temporaryData.hashCode()
                        ^ Integer.valueOf(enableDisconnectResultCodes).hashCode()
                        ^ Integer.valueOf(getActualCommunicationParametersResultCodes).hashCode()
                        ^ Integer.valueOf(proposeSettingsResultCodes).hashCode()
                        ^ Integer.valueOf(proposeSettingsError).hashCode()
                        ^ Integer.valueOf(activateStoredSettingsResultCodes).hashCode()
                        ^ Integer.valueOf(getMaxValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(maxValues)
                        ^ Integer.valueOf(getMinValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(minValues)
                        ^ Integer.valueOf(getStoredValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(getStoredValuesOperand)
                        ^ Integer.valueOf(setWhiteListTimerResultCodes).hashCode()
                        ^ Integer.valueOf(getWhiteListTimerResultCodes).hashCode()
                        ^ Arrays.hashCode(getWhiteListTimerOperand)
                        ^ Integer.valueOf(setAdvertisementConfigurationResultCodes).hashCode()
                        ^ Integer.valueOf(upgradeToLescOnlyResultCodes).hashCode()
                        ^ Integer.valueOf(switchOobPairingResultCodes).hashCode()
                        ^ Integer.valueOf(limitedAccessResultCodes).hashCode()
                        ^ Arrays.hashCode(currentSetting)
                        ^ Boolean.valueOf(isRcFeaturesE2eCrcSupported).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;
        byte[] currentData = new byte[]{26};
        Map<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(27, new byte[]{28});

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);

        int hashCode = 0;
        for (Map.Entry<Integer, byte[]> entry : temporaryData.entrySet()) {
            hashCode ^= entry.getKey().hashCode();
            hashCode ^= Arrays.hashCode(entry.getValue());
        }
        assertEquals(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ hashCode
                        ^ Integer.valueOf(enableDisconnectResultCodes).hashCode()
                        ^ Integer.valueOf(getActualCommunicationParametersResultCodes).hashCode()
                        ^ Integer.valueOf(proposeSettingsResultCodes).hashCode()
                        ^ Integer.valueOf(proposeSettingsError).hashCode()
                        ^ Integer.valueOf(activateStoredSettingsResultCodes).hashCode()
                        ^ Integer.valueOf(getMaxValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(maxValues)
                        ^ Integer.valueOf(getMinValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(minValues)
                        ^ Integer.valueOf(getStoredValuesResultCodes).hashCode()
                        ^ Arrays.hashCode(getStoredValuesOperand)
                        ^ Integer.valueOf(setWhiteListTimerResultCodes).hashCode()
                        ^ Integer.valueOf(getWhiteListTimerResultCodes).hashCode()
                        ^ Arrays.hashCode(getWhiteListTimerOperand)
                        ^ Integer.valueOf(setAdvertisementConfigurationResultCodes).hashCode()
                        ^ Integer.valueOf(upgradeToLescOnlyResultCodes).hashCode()
                        ^ Integer.valueOf(switchOobPairingResultCodes).hashCode()
                        ^ Integer.valueOf(limitedAccessResultCodes).hashCode()
                        ^ Arrays.hashCode(currentSetting)
                        ^ Boolean.valueOf(isRcFeaturesE2eCrcSupported).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(firstDescriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);


        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 122, 123, 124, new byte[]{125}));

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(secondDescriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int firstResponseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , firstResponseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondResponseCode = 101;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , secondResponseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long firstDelay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , firstDelay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        long secondDelay = 102;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , secondDelay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int firstEnableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , firstEnableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondEnableDisconnectResultCodes = 103;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , secondEnableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int firstGetActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , firstGetActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondGetActualCommunicationParametersResultCodes = 104;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , secondGetActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int firstProposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , firstProposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondProposeSettingsResultCodes = 105;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , secondProposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int firstProposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , firstProposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondProposeSettingsError = 106;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , secondProposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int firstActivateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , firstActivateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondActivateStoredSettingsResultCodes = 107;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , secondActivateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int firstGetMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , firstGetMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondGetMaxValuesResultCodes = 108;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , secondGetMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] firstMaxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , firstMaxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        byte[] secondMaxValues = new byte[]{109};

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , secondMaxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int firstGetMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , firstGetMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondGetMinValuesResultCodes = 110;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , secondGetMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] firstMinValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , firstMinValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        byte[] secondFirstMinValues = new byte[]{111};

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , secondFirstMinValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int firstGetStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , firstGetStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondGetStoredValuesResultCodes = 112;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , secondGetStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] firstGetStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , firstGetStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        byte[] secondGetStoredValuesOperand = new byte[]{113};

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , secondGetStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int firstSetWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , firstSetWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondSetWhiteListTimerResultCodes = 114;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , secondSetWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int firstGetWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , firstGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondGetWhiteListTimerResultCodes = 115;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , secondGetWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00018() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] firstGetWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , firstGetWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        byte[] secondGetWhiteListTimerOperand = new byte[]{116};

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , secondGetWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00019() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int firstSetAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , firstSetAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondSetAdvertisementConfigurationResultCodes = 117;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , secondSetAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00020() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int firstUpgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , firstUpgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondUpgradeToLescOnlyResultCodes = 118;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , secondUpgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00021() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int firstSwitchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , firstSwitchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondSwitchOobPairingResultCodes = 119;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , secondSwitchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00022() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int firstLimitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , firstLimitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        int secondLimitedAccessResultCodes = 120;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , secondLimitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00023() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] firstCurrentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , firstCurrentSetting
                , isRcFeaturesE2eCrcSupported);

        byte[] secondCurrentSetting = new byte[]{121};

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , secondCurrentSetting
                , isRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00024() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean firstIsRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , firstIsRcFeaturesE2eCrcSupported);

        boolean secondIsRcFeaturesE2eCrcSupported = false;

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , secondIsRcFeaturesE2eCrcSupported);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00025() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        result2.currentData = new byte[]{26};

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00026() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 22, 23, 24, new byte[]{25}));
        int responseCode = 1;
        long delay = 2;
        int enableDisconnectResultCodes = 3;
        int getActualCommunicationParametersResultCodes = 4;
        int proposeSettingsResultCodes = 5;
        int proposeSettingsError = 6;
        int activateStoredSettingsResultCodes = 7;
        int getMaxValuesResultCodes = 8;
        byte[] maxValues = new byte[]{9};
        int getMinValuesResultCodes = 10;
        byte[] minValues = new byte[]{11};
        int getStoredValuesResultCodes = 12;
        byte[] getStoredValuesOperand = new byte[]{13};
        int setWhiteListTimerResultCodes = 14;
        int getWhiteListTimerResultCodes = 15;
        byte[] getWhiteListTimerOperand = new byte[]{16};
        int setAdvertisementConfigurationResultCodes = 17;
        int upgradeToLescOnlyResultCodes = 18;
        int switchOobPairingResultCodes = 19;
        int limitedAccessResultCodes = 20;
        byte[] currentSetting = new byte[]{21};
        boolean isRcFeaturesE2eCrcSupported = true;

        ReconnectionConfigurationControlPointCharacteristicData result1 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        ReconnectionConfigurationControlPointCharacteristicData result2 = new ReconnectionConfigurationControlPointCharacteristicData(descriptorDataList
                , responseCode
                , delay
                , enableDisconnectResultCodes
                , getActualCommunicationParametersResultCodes
                , proposeSettingsResultCodes
                , proposeSettingsError
                , activateStoredSettingsResultCodes
                , getMaxValuesResultCodes
                , maxValues
                , getMinValuesResultCodes
                , minValues
                , getStoredValuesResultCodes
                , getStoredValuesOperand
                , setWhiteListTimerResultCodes
                , getWhiteListTimerResultCodes
                , getWhiteListTimerOperand
                , setAdvertisementConfigurationResultCodes
                , upgradeToLescOnlyResultCodes
                , switchOobPairingResultCodes
                , limitedAccessResultCodes
                , currentSetting
                , isRcFeaturesE2eCrcSupported);

        result2.temporaryData.put(27, new byte[]{28});

        assertNotEquals(result1, result2);
    }

}
