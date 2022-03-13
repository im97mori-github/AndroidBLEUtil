package org.im97mori.ble.service.lns.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.LN_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCATION_AND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.POSITION_QUALITY_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;
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
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class LocationAndNavigationServiceDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        Gson gson = new Gson();
        LocationAndNavigationServiceData result2 = gson.fromJson(gson.toJson(result1), LocationAndNavigationServiceData.class);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , null
                , lnControlPoint
                , navigation);

        Gson gson = new Gson();
        LocationAndNavigationServiceData result2 = gson.fromJson(gson.toJson(result1), LocationAndNavigationServiceData.class);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_constructor_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , null
                , navigation);

        Gson gson = new Gson();
        LocationAndNavigationServiceData result2 = gson.fromJson(gson.toJson(result1), LocationAndNavigationServiceData.class);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_constructor_00004() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , null);

        Gson gson = new Gson();
        LocationAndNavigationServiceData result2 = gson.fromJson(gson.toJson(result1), LocationAndNavigationServiceData.class);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_constructor_00101() {
        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData();

        assertNull(result1.lnFeature);
        assertNull(result1.locationAndSpeed);
        assertNull(result1.positionQuality);
        assertNull(result1.lnControlPoint);
        assertNull(result1.navigation);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        assertArrayEquals(Arrays.asList(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , null
                , lnControlPoint
                , navigation);

        assertArrayEquals(Arrays.asList(lnFeature
                , locationAndSpeed
                , lnControlPoint
                , navigation).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , null
                , navigation);

        assertArrayEquals(Arrays.asList(lnFeature
                , locationAndSpeed
                , positionQuality
                , navigation).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00004() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , null);

        assertArrayEquals(Arrays.asList(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndNavigationServiceData result2 = LocationAndNavigationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , null
                , lnControlPoint
                , navigation);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndNavigationServiceData result2 = LocationAndNavigationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_parcelable_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , null
                , navigation);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndNavigationServiceData result2 = LocationAndNavigationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_parcelable_00004() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , null);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndNavigationServiceData result2 = LocationAndNavigationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.lnFeature, result2.lnFeature);
        assertEquals(result1.locationAndSpeed, result2.locationAndSpeed);
        assertEquals(result1.positionQuality, result2.positionQuality);
        assertEquals(result1.lnControlPoint, result2.lnControlPoint);
        assertEquals(result1.navigation, result2.navigation);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        assertEquals(Objects.hashCode(LOCATION_AND_NAVIGATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(lnFeature)
                        ^ Objects.hashCode(locationAndSpeed)
                        ^ Objects.hashCode(positionQuality)
                        ^ Objects.hashCode(lnControlPoint)
                        ^ Objects.hashCode(navigation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , null
                , lnControlPoint
                , navigation);

        assertEquals(Objects.hashCode(LOCATION_AND_NAVIGATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(lnFeature)
                        ^ Objects.hashCode(locationAndSpeed)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(lnControlPoint)
                        ^ Objects.hashCode(navigation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , null
                , navigation);

        assertEquals(Objects.hashCode(LOCATION_AND_NAVIGATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(lnFeature)
                        ^ Objects.hashCode(locationAndSpeed)
                        ^ Objects.hashCode(positionQuality)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(navigation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00004() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , null);

        assertEquals(Objects.hashCode(LOCATION_AND_NAVIGATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(lnFeature)
                        ^ Objects.hashCode(locationAndSpeed)
                        ^ Objects.hashCode(positionQuality)
                        ^ Objects.hashCode(lnControlPoint)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData firstLnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData firstNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , firstNavigation);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , firstNavigation);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData firstLnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData firstNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CharacteristicData secondLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , firstNavigation);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(secondLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , firstNavigation);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData firstLnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData firstNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CharacteristicData secondPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , firstNavigation);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , secondPositionQuality
                , firstLnControlPoint
                , firstNavigation);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData firstLnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData firstNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LNControlPointCharacteristicData secondLnControlPoint = new LNControlPointCharacteristicData(11
                , 22
                , new ArrayList<>()
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
                , 113
                , 114);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , firstNavigation);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , secondLnControlPoint
                , firstNavigation);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData firstLnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData firstNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CharacteristicData secondNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , firstNavigation);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , secondNavigation);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData firstLnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);
        CharacteristicData firstNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , null
                , firstLnControlPoint
                , firstNavigation);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , null
                , firstLnControlPoint
                , firstNavigation);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstNavigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , null
                , firstNavigation);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , null
                , firstNavigation);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00103() {
        CharacteristicData firstLnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstPositionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData firstLnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
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
                , 13
                , 14);

        LocationAndNavigationServiceData result1 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , null);

        LocationAndNavigationServiceData result2 = new LocationAndNavigationServiceData(firstLnFeature
                , firstLocationAndSpeed
                , firstPositionQuality
                , firstLnControlPoint
                , null);
        assertEquals(result1, result2);
    }

}
