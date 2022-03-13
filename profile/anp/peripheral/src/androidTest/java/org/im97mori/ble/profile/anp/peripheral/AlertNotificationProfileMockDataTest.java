package org.im97mori.ble.profile.anp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.service.ans.peripheral.AlertNotificationControlPointCharacteristicData;
import org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceData;
import org.im97mori.ble.service.ans.peripheral.NewAlertCharacteristicData;
import org.im97mori.ble.service.ans.peripheral.UnreadAlertStatusCharacteristicData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class AlertNotificationProfileMockDataTest {

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

        AlertNotificationServiceData alertNotification = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);

        AlertNotificationProfileMockData result1 = new AlertNotificationProfileMockData(alertNotification);

        Gson gson = new Gson();
        AlertNotificationProfileMockData result2 = gson.fromJson(gson.toJson(result1), AlertNotificationProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.alertNotification, result2.alertNotification);
    }

    @Test
    public void test_constructor_00101() {
        AlertNotificationProfileMockData result1 = new AlertNotificationProfileMockData();

        assertNull(result1.alertNotification);
    }

    @Test
    public void test_getServiceDataList_00001() {
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

        AlertNotificationServiceData alertNotification = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);

        AlertNotificationProfileMockData result1 = new AlertNotificationProfileMockData(alertNotification);

        assertArrayEquals(Collections.singletonList(alertNotification).toArray(), result1.getServiceDataList().toArray());
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

        AlertNotificationServiceData alertNotification = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);

        AlertNotificationProfileMockData result1 = new AlertNotificationProfileMockData(alertNotification);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertNotificationProfileMockData result2 = AlertNotificationProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.alertNotification, result2.alertNotification);
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

        AlertNotificationServiceData alertNotification = new AlertNotificationServiceData(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);

        AlertNotificationProfileMockData result1 = new AlertNotificationProfileMockData(alertNotification);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(alertNotification)
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

        AlertNotificationServiceData firstAlertNotification = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);

        AlertNotificationProfileMockData result1 = new AlertNotificationProfileMockData(firstAlertNotification);

        AlertNotificationProfileMockData result2 = new AlertNotificationProfileMockData(firstAlertNotification);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
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

        AlertNotificationServiceData firstAlertNotification = new AlertNotificationServiceData(firstSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);

        CharacteristicData secondSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        AlertNotificationServiceData secondAlertNotification = new AlertNotificationServiceData(secondSupportedNewAlertCategory
                , firstNewAlert
                , firstSupportedUnreadAlertCategory
                , firstUnreadAlertStatus
                , firstAlertNotificationControlPoint);

        AlertNotificationProfileMockData result1 = new AlertNotificationProfileMockData(firstAlertNotification);

        AlertNotificationProfileMockData result2 = new AlertNotificationProfileMockData(secondAlertNotification);

        assertNotEquals(result1, result2);
    }

}
