package org.im97mori.ble.profile.rcp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RC_SETTINGS_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.bms.peripheral.BondManagementControlPointCharacteristicData;
import org.im97mori.ble.service.bms.peripheral.BondManagementServiceData;
import org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationControlPointCharacteristicData;
import org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceData;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ReconnectionConfigurationProfileMockDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        BondManagementServiceData bondManagement = new BondManagementServiceData(bondManagementFeature, bondManagementControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, bondManagement);

        Gson gson = new Gson();
        ReconnectionConfigurationProfileMockData result2 = gson.fromJson(gson.toJson(result1), ReconnectionConfigurationProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.reconnectionConfiguration, result2.reconnectionConfiguration);
        assertEquals(result1.bondManagement, result2.bondManagement);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, null);

        Gson gson = new Gson();
        ReconnectionConfigurationProfileMockData result2 = gson.fromJson(gson.toJson(result1), ReconnectionConfigurationProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.reconnectionConfiguration, result2.reconnectionConfiguration);
        assertEquals(result1.bondManagement, result2.bondManagement);
    }

    @Test
    public void test_constructor_00101() {
        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData();

        assertNull(result1.reconnectionConfiguration);
        assertNull(result1.bondManagement);
    }

    @Test
    public void test_getServiceDataList_00001() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        BondManagementServiceData bondManagement = new BondManagementServiceData(bondManagementFeature, bondManagementControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, bondManagement);

        List<ServiceData> list = new ArrayList<>();
        list.add(reconnectionConfiguration);
        list.add(bondManagement);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(reconnectionConfiguration);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        BondManagementServiceData bondManagement = new BondManagementServiceData(bondManagementFeature, bondManagementControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, bondManagement);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationProfileMockData result2 = ReconnectionConfigurationProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.reconnectionConfiguration, result2.reconnectionConfiguration);
        assertEquals(result1.bondManagement, result2.bondManagement);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationProfileMockData result2 = ReconnectionConfigurationProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.reconnectionConfiguration, result2.reconnectionConfiguration);
        assertEquals(result1.bondManagement, result2.bondManagement);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        BondManagementServiceData bondManagement = new BondManagementServiceData(bondManagementFeature, bondManagementControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, bondManagement);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(reconnectionConfiguration)
                        ^ Objects.hashCode(bondManagement)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData reconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(reconnectionConfiguration, null);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(reconnectionConfiguration)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData firstReconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        BondManagementServiceData firstBondManagement = new BondManagementServiceData(bondManagementFeature, bondManagementControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(firstReconnectionConfiguration, firstBondManagement);

        ReconnectionConfigurationProfileMockData result2 = new ReconnectionConfigurationProfileMockData(firstReconnectionConfiguration, firstBondManagement);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData firstReconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        BondManagementServiceData firstBondManagement = new BondManagementServiceData(bondManagementFeature, bondManagementControlPoint);

        ReconnectionConfigurationServiceData secondReconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , null);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(firstReconnectionConfiguration, firstBondManagement);

        ReconnectionConfigurationProfileMockData result2 = new ReconnectionConfigurationProfileMockData(secondReconnectionConfiguration, firstBondManagement);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData firstReconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        CharacteristicData firstBondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        BondManagementServiceData firstBondManagement = new BondManagementServiceData(firstBondManagementFeature, bondManagementControlPoint);

        CharacteristicData secondBondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        BondManagementServiceData secondBondManagement = new BondManagementServiceData(secondBondManagementFeature, bondManagementControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(firstReconnectionConfiguration, firstBondManagement);

        ReconnectionConfigurationProfileMockData result2 = new ReconnectionConfigurationProfileMockData(firstReconnectionConfiguration, secondBondManagement);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData firstReconnectionConfiguration = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        ReconnectionConfigurationProfileMockData result1 = new ReconnectionConfigurationProfileMockData(firstReconnectionConfiguration, null);

        ReconnectionConfigurationProfileMockData result2 = new ReconnectionConfigurationProfileMockData(firstReconnectionConfiguration, null);

        assertEquals(result1, result2);
    }

}
