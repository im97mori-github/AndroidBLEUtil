package org.im97mori.ble.service.rcs.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.RC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RC_SETTINGS_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class ReconnectionConfigurationServiceDataTest extends TestBase {

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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        Gson gson = new Gson();
        ReconnectionConfigurationServiceData result2 = gson.fromJson(gson.toJson(result1), ReconnectionConfigurationServiceData.class);

        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rcFeature, result2.rcFeature);
        assertEquals(result1.rcSettings, result2.rcSettings);
        assertEquals(result1.reconnectionConfigurationControlPoint, result2.reconnectionConfigurationControlPoint);
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , null
                , reconnectionConfigurationControlPoint);

        Gson gson = new Gson();
        ReconnectionConfigurationServiceData result2 = gson.fromJson(gson.toJson(result1), ReconnectionConfigurationServiceData.class);

        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rcFeature, result2.rcFeature);
        assertEquals(result1.rcSettings, result2.rcSettings);
        assertEquals(result1.reconnectionConfigurationControlPoint, result2.reconnectionConfigurationControlPoint);
    }

    @Test
    public void test_constructor_00003() {
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , null);

        Gson gson = new Gson();
        ReconnectionConfigurationServiceData result2 = gson.fromJson(gson.toJson(result1), ReconnectionConfigurationServiceData.class);

        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rcFeature, result2.rcFeature);
        assertEquals(result1.rcSettings, result2.rcSettings);
        assertEquals(result1.reconnectionConfigurationControlPoint, result2.reconnectionConfigurationControlPoint);
    }

    @Test
    public void test_constructor_00101() {
        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData();

        assertNull(result1.rcFeature);
        assertNull(result1.rcSettings);
        assertNull(result1.reconnectionConfigurationControlPoint);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        assertArrayEquals(Arrays.asList(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
        CharacteristicData rcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , null
                , reconnectionConfigurationControlPoint);

        assertArrayEquals(Arrays.asList(rcFeatureData
                , reconnectionConfigurationControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , null);

        assertArrayEquals(Arrays.asList(rcFeatureData
                , rcSettingsData).toArray(), result1.getCharacteristicDataList().toArray());
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationServiceData result2 = ReconnectionConfigurationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rcFeature, result2.rcFeature);
        assertEquals(result1.rcSettings, result2.rcSettings);
        assertEquals(result1.reconnectionConfigurationControlPoint, result2.reconnectionConfigurationControlPoint);
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , null
                , reconnectionConfigurationControlPoint);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationServiceData result2 = ReconnectionConfigurationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rcFeature, result2.rcFeature);
        assertEquals(result1.rcSettings, result2.rcSettings);
        assertEquals(result1.reconnectionConfigurationControlPoint, result2.reconnectionConfigurationControlPoint);
    }

    @Test
    public void test_parcelable_00003() {
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , null);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReconnectionConfigurationServiceData result2 = ReconnectionConfigurationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rcFeature, result2.rcFeature);
        assertEquals(result1.rcSettings, result2.rcSettings);
        assertEquals(result1.reconnectionConfigurationControlPoint, result2.reconnectionConfigurationControlPoint);
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , reconnectionConfigurationControlPoint);

        assertEquals(Objects.hashCode(RECONNECTION_CONFIGURATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(rcFeatureData)
                        ^ Objects.hashCode(rcSettingsData)
                        ^ Objects.hashCode(reconnectionConfigurationControlPoint)
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , null
                , reconnectionConfigurationControlPoint);

        assertEquals(Objects.hashCode(RECONNECTION_CONFIGURATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(rcFeatureData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(reconnectionConfigurationControlPoint)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(rcFeatureData
                , rcSettingsData
                , null);

        assertEquals(Objects.hashCode(RECONNECTION_CONFIGURATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(rcFeatureData)
                        ^ Objects.hashCode(rcSettingsData)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData firstReconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , firstReconnectionConfigurationControlPoint);

        ReconnectionConfigurationServiceData result2 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , firstReconnectionConfigurationControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData firstReconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        CharacteristicData secondRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , firstReconnectionConfigurationControlPoint);

        ReconnectionConfigurationServiceData result2 = new ReconnectionConfigurationServiceData(secondRcFeatureData
                , firstRcSettingsData
                , firstReconnectionConfigurationControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData firstReconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        CharacteristicData secondRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , firstReconnectionConfigurationControlPoint);

        ReconnectionConfigurationServiceData result2 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , secondRcFeatureData
                , firstReconnectionConfigurationControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData firstReconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationControlPointCharacteristicData secondReconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
                , 11
                , 22
                , 33
                , 44
                , 55
                , 66
                , 77
                , 88
                , new byte[]{99}
                , 110
                , new byte[]{111}
                , 112
                , new byte[]{113}
                , 114
                , 115
                , new byte[]{116}
                , 117
                , 118
                , 119
                , 120
                , new byte[]{121}
                , false);

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , firstReconnectionConfigurationControlPoint);

        ReconnectionConfigurationServiceData result2 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , secondReconnectionConfigurationControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData firstRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReconnectionConfigurationControlPointCharacteristicData firstReconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPointCharacteristicData(new ArrayList<>()
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

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , null
                , firstReconnectionConfigurationControlPoint);

        ReconnectionConfigurationServiceData result2 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , null
                , firstReconnectionConfigurationControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData firstRcFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRcSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        ReconnectionConfigurationServiceData result1 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , null);

        ReconnectionConfigurationServiceData result2 = new ReconnectionConfigurationServiceData(firstRcFeatureData
                , firstRcSettingsData
                , null);
        assertEquals(result1, result2);
    }

}
