package org.im97mori.ble.service.ans.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AlertNotificationControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);

        Gson gson = new Gson();
        AlertNotificationControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), AlertNotificationControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.enableNewAlertNotificationResponseValue, result2.enableNewAlertNotificationResponseValue);
        assertEquals(result1.enableUnreadAlertStatusNotificationResponseValue, result2.enableUnreadAlertStatusNotificationResponseValue);
        assertEquals(result1.disableNewAlertNotificationResponseValue, result2.disableNewAlertNotificationResponseValue);
        assertEquals(result1.disableUnreadAlertStatusNotificationResponseValue, result2.disableUnreadAlertStatusNotificationResponseValue);
        assertEquals(result1.notifyNewAlertImmediatelyResponseValue, result2.notifyNewAlertImmediatelyResponseValue);
        assertEquals(result1.notifyUnreadAlertStatusImmediatelyResponseValue, result2.notifyUnreadAlertStatusImmediatelyResponseValue);
    }

    @Test
    public void test_enableNewAlertNotificationResponseValue_00001() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        AlertNotificationControlPointCharacteristicData characteristicData = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);
        assertEquals(firstEnableNewAlertNotificationResponseValue, characteristicData.enableNewAlertNotificationResponseValue);

        int secondEnableNewAlertNotificationResponseValue = 11;
        characteristicData.enableNewAlertNotificationResponseValue = secondEnableNewAlertNotificationResponseValue;
        assertEquals(secondEnableNewAlertNotificationResponseValue, characteristicData.enableNewAlertNotificationResponseValue);
    }

    @Test
    public void test_enableUnreadAlertStatusNotificationResponseValue_00001() {
        int firstEnableUnreadAlertStatusNotificationResponseValue = 1;
        AlertNotificationControlPointCharacteristicData characteristicData = new AlertNotificationControlPointCharacteristicData(0
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , 0
                , 0
                , 0
                , 0
                , 0);
        assertEquals(firstEnableUnreadAlertStatusNotificationResponseValue, characteristicData.enableUnreadAlertStatusNotificationResponseValue);

        int secondEnableUnreadAlertStatusNotificationResponseValue = 11;
        characteristicData.enableUnreadAlertStatusNotificationResponseValue = secondEnableUnreadAlertStatusNotificationResponseValue;
        assertEquals(secondEnableUnreadAlertStatusNotificationResponseValue, characteristicData.enableUnreadAlertStatusNotificationResponseValue);
    }

    @Test
    public void test_disableNewAlertNotificationResponseValue_00001() {
        int firstDisableNewAlertNotificationResponseValue = 1;
        AlertNotificationControlPointCharacteristicData characteristicData = new AlertNotificationControlPointCharacteristicData(0
                , 0
                , firstDisableNewAlertNotificationResponseValue
                , 0
                , 0
                , 0
                , 0);
        assertEquals(firstDisableNewAlertNotificationResponseValue, characteristicData.disableNewAlertNotificationResponseValue);

        int secondDisableNewAlertNotificationResponseValue = 11;
        characteristicData.disableNewAlertNotificationResponseValue = secondDisableNewAlertNotificationResponseValue;
        assertEquals(secondDisableNewAlertNotificationResponseValue, characteristicData.disableNewAlertNotificationResponseValue);
    }

    @Test
    public void test_disableUnreadAlertStatusNotificationResponseValue_00001() {
        int firstDisableUnreadAlertStatusNotificationResponseValue = 1;
        AlertNotificationControlPointCharacteristicData characteristicData = new AlertNotificationControlPointCharacteristicData(0
                , 0
                , 0
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , 0
                , 0
                , 0);
        assertEquals(firstDisableUnreadAlertStatusNotificationResponseValue, characteristicData.disableUnreadAlertStatusNotificationResponseValue);

        int secondDisableUnreadAlertStatusNotificationResponseValue = 11;
        characteristicData.disableUnreadAlertStatusNotificationResponseValue = secondDisableUnreadAlertStatusNotificationResponseValue;
        assertEquals(secondDisableUnreadAlertStatusNotificationResponseValue, characteristicData.disableUnreadAlertStatusNotificationResponseValue);
    }

    @Test
    public void test_notifyNewAlertImmediatelyResponseValue_00001() {
        int firstNotifyNewAlertImmediatelyResponseValue = 1;
        AlertNotificationControlPointCharacteristicData characteristicData = new AlertNotificationControlPointCharacteristicData(0
                , 0
                , 0
                , 0
                , firstNotifyNewAlertImmediatelyResponseValue
                , 0
                , 0);
        assertEquals(firstNotifyNewAlertImmediatelyResponseValue, characteristicData.notifyNewAlertImmediatelyResponseValue);

        int secondNotifyNewAlertImmediatelyResponseValue = 11;
        characteristicData.notifyNewAlertImmediatelyResponseValue = secondNotifyNewAlertImmediatelyResponseValue;
        assertEquals(secondNotifyNewAlertImmediatelyResponseValue, characteristicData.notifyNewAlertImmediatelyResponseValue);
    }

    @Test
    public void test_notifyUnreadAlertStatusImmediatelyResponseValue_00001() {
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 1;
        AlertNotificationControlPointCharacteristicData characteristicData = new AlertNotificationControlPointCharacteristicData(0
                , 0
                , 0
                , 0
                , 0
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , 0);
        assertEquals(firstNotifyUnreadAlertStatusImmediatelyResponseValue, characteristicData.notifyUnreadAlertStatusImmediatelyResponseValue);

        int secondotifyUnreadAlertStatusImmediatelyResponseValue = 11;
        characteristicData.notifyUnreadAlertStatusImmediatelyResponseValue = secondotifyUnreadAlertStatusImmediatelyResponseValue;
        assertEquals(secondotifyUnreadAlertStatusImmediatelyResponseValue, characteristicData.notifyUnreadAlertStatusImmediatelyResponseValue);
    }

    @Test
    public void test_parcelable_00001() {
        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertNotificationControlPointCharacteristicData result2 = AlertNotificationControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.enableNewAlertNotificationResponseValue, result2.enableNewAlertNotificationResponseValue);
        assertEquals(result1.enableUnreadAlertStatusNotificationResponseValue, result2.enableUnreadAlertStatusNotificationResponseValue);
        assertEquals(result1.disableNewAlertNotificationResponseValue, result2.disableNewAlertNotificationResponseValue);
        assertEquals(result1.disableUnreadAlertStatusNotificationResponseValue, result2.disableUnreadAlertStatusNotificationResponseValue);
        assertEquals(result1.notifyNewAlertImmediatelyResponseValue, result2.notifyNewAlertImmediatelyResponseValue);
        assertEquals(result1.notifyUnreadAlertStatusImmediatelyResponseValue, result2.notifyUnreadAlertStatusImmediatelyResponseValue);
    }

    @Test
    public void test_hashCode_00001() {
        int property = BluetoothGattCharacteristic.PROPERTY_WRITE;
        int permission = BluetoothGattCharacteristic.PERMISSION_WRITE;
        int responseCode = BluetoothGatt.GATT_SUCCESS;
        int enableNewAlertNotificationResponseValue = 1;
        int enableUnreadAlertStatusNotificationResponseValue = 2;
        int disableNewAlertNotificationResponseValue = 3;
        int disableUnreadAlertStatusNotificationResponseValue = 4;
        int notifyNewAlertImmediatelyResponseValue = 5;
        int notifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long delay = 7;
        int notificationCount = 1;


        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(enableNewAlertNotificationResponseValue
                , enableUnreadAlertStatusNotificationResponseValue
                , disableNewAlertNotificationResponseValue
                , disableUnreadAlertStatusNotificationResponseValue
                , notifyNewAlertImmediatelyResponseValue
                , notifyUnreadAlertStatusImmediatelyResponseValue
                , delay);
        assertEquals(ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(new ArrayList<>().toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Integer.valueOf(notificationCount).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(enableNewAlertNotificationResponseValue).hashCode()
                        ^ Integer.valueOf(enableUnreadAlertStatusNotificationResponseValue).hashCode()
                        ^ Integer.valueOf(disableNewAlertNotificationResponseValue).hashCode()
                        ^ Integer.valueOf(disableUnreadAlertStatusNotificationResponseValue).hashCode()
                        ^ Integer.valueOf(notifyNewAlertImmediatelyResponseValue).hashCode()
                        ^ Integer.valueOf(notifyUnreadAlertStatusImmediatelyResponseValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        int secondEnableNewAlertNotificationResponseValue = 101;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(secondEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        int secondEnableUnreadAlertStatusNotificationResponseValue = 101;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , secondEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        int secondDisableNewAlertNotificationResponseValue = 101;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , secondDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        int secondDisableUnreadAlertStatusNotificationResponseValue = 101;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , secondDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        int secondNotifyNewAlertImmediatelyResponseValue = 101;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , secondNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        int secondNotifyUnreadAlertStatusImmediatelyResponseValue = 101;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , secondNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        int firstEnableNewAlertNotificationResponseValue = 1;
        int firstEnableUnreadAlertStatusNotificationResponseValue = 2;
        int firstDisableNewAlertNotificationResponseValue = 3;
        int firstDisableUnreadAlertStatusNotificationResponseValue = 4;
        int firstNotifyNewAlertImmediatelyResponseValue = 5;
        int firstNotifyUnreadAlertStatusImmediatelyResponseValue = 6;
        long firstDelay = 7;

        int secondDelay = 101;

        AlertNotificationControlPointCharacteristicData result1 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , firstDelay);
        AlertNotificationControlPointCharacteristicData result2 = new AlertNotificationControlPointCharacteristicData(firstEnableNewAlertNotificationResponseValue
                , firstEnableUnreadAlertStatusNotificationResponseValue
                , firstDisableNewAlertNotificationResponseValue
                , firstDisableUnreadAlertStatusNotificationResponseValue
                , firstNotifyNewAlertImmediatelyResponseValue
                , firstNotifyUnreadAlertStatusImmediatelyResponseValue
                , secondDelay);
        assertNotEquals(result1, result2);
    }

}
