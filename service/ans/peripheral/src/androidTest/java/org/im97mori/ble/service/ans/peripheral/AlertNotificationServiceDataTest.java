package org.im97mori.ble.service.ans.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;
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

public class AlertNotificationServiceDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        CharacteristicData supportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData newAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData supportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData unreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData alertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);

        Gson gson = new Gson();
        AlertNotificationServiceData result2 = gson.fromJson(gson.toJson(result1), AlertNotificationServiceData.class);

        assertEquals(ALERT_NOTIFICATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.supportedNewAlertCategory, result2.supportedNewAlertCategory);
        assertEquals(result1.newAlert, result2.newAlert);
        assertEquals(result1.supportedUnreadAlertCategory, result2.supportedUnreadAlertCategory);
        assertEquals(result1.unreadAlertStatus, result2.unreadAlertStatus);
        assertEquals(result1.alertNotificationControlPoint, result2.alertNotificationControlPoint);
    }

    @Test
    public void test_constructor_00101() {
        AlertNotificationServiceData result1 = new AlertNotificationServiceData();

        assertNull(result1.supportedNewAlertCategory);
        assertNull(result1.newAlert);
        assertNull(result1.supportedUnreadAlertCategory);
        assertNull(result1.unreadAlertStatus);
        assertNull(result1.alertNotificationControlPoint);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
        CharacteristicData supportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData newAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData supportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData unreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData alertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);

        assertArrayEquals(Arrays.asList(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData supportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData newAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData supportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData unreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData alertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertNotificationServiceData result2 = AlertNotificationServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(ALERT_NOTIFICATION_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.supportedNewAlertCategory, result2.supportedNewAlertCategory);
        assertEquals(result1.newAlert, result2.newAlert);
        assertEquals(result1.supportedUnreadAlertCategory, result2.supportedUnreadAlertCategory);
        assertEquals(result1.unreadAlertStatus, result2.unreadAlertStatus);
        assertEquals(result1.alertNotificationControlPoint, result2.alertNotificationControlPoint);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData supportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData newAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData supportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData unreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData alertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);

        assertEquals(Objects.hashCode(ALERT_NOTIFICATION_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(supportedNewAlertCategory)
                        ^ Objects.hashCode(newAlert)
                        ^ Objects.hashCode(supportedUnreadAlertCategory)
                        ^ Objects.hashCode(unreadAlertStatus)
                        ^ Objects.hashCode(alertNotificationControlPoint)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData firstNewAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData firstSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData firstUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData firstAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        AlertNotificationServiceData result2 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);
        NewAlertCharacteristicData firstNewAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData firstSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData firstUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData firstAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        CharacteristicData secondSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        AlertNotificationServiceData result2 = new AlertNotificationServiceData(secondSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData firstNewAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData firstSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData firstUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData firstAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        NewAlertCharacteristicData secondNewAlert = new NewAlertCharacteristicData(1
                , "aa"
                , 22
                , "bb"
                , 33
                , "cc"
                , 44
                , "dd"
                , 55
                , "ee"
                , 66
                , "ff"
                , 77
                , "gg"
                , 88
                , "hh"
                , 99
                , "ii"
                , 110
                , "jj"
                , new ArrayList<>());

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        AlertNotificationServiceData result2 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , secondNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData firstNewAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData firstSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData firstUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData firstAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        CharacteristicData secondSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        AlertNotificationServiceData result2 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , secondSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        CharacteristicData firstSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData firstNewAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData firstSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData firstUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData firstAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        UnreadAlertStatusCharacteristicData secondUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(11
                , 22
                , 33
                , 44
                , 55
                , 66
                , 77
                , 88
                , 99
                , 110
                , new ArrayList<>());

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        AlertNotificationServiceData result2 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , secondUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        CharacteristicData firstSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        NewAlertCharacteristicData firstNewAlert = new NewAlertCharacteristicData(1
                , "a"
                , 2
                , "b"
                , 3
                , "c"
                , 4
                , "d"
                , 5
                , "e"
                , 6
                , "f"
                , 7
                , "g"
                , 8
                , "h"
                , 9
                , "i"
                , 10
                , "j"
                , new ArrayList<>());
        CharacteristicData firstSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UnreadAlertStatusCharacteristicData firstUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , new ArrayList<>());
        AlertNotificationControlPointCharacteristicData firstAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        AlertNotificationControlPointCharacteristicData secondAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(11
                , 22
                , 33
                , 44
                , 55
                , 66
                , 77);

        AlertNotificationServiceData result1 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);
        AlertNotificationServiceData result2 = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , secondAlertNotificationControlPoint);
        assertNotEquals(result1, result2);
    }

}
