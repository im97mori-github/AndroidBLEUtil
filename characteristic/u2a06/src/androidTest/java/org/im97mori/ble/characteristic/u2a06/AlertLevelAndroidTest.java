package org.im97mori.ble.characteristic.u2a06;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlertLevelAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AlertLevel.ALERT_LEVEL_NO_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertLevelAndroid result1 = new AlertLevelAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertLevel.ALERT_LEVEL_NO_ALERT, result1.getAlertLevel());
        assertTrue(result1.isAlertLevelNoAlert());
        assertFalse(result1.isAlertLevelMildAlert());
        assertFalse(result1.isAlertLevelHighAlert());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AlertLevel.ALERT_LEVEL_MILD_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertLevelAndroid result1 = new AlertLevelAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertLevel.ALERT_LEVEL_MILD_ALERT, result1.getAlertLevel());
        assertFalse(result1.isAlertLevelNoAlert());
        assertTrue(result1.isAlertLevelMildAlert());
        assertFalse(result1.isAlertLevelHighAlert());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AlertLevel.ALERT_LEVEL_HIGH_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertLevelAndroid result1 = new AlertLevelAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertLevel.ALERT_LEVEL_HIGH_ALERT, result1.getAlertLevel());
        assertFalse(result1.isAlertLevelNoAlert());
        assertFalse(result1.isAlertLevelMildAlert());
        assertTrue(result1.isAlertLevelHighAlert());
    }

    @Test
    public void test_constructor004() {
        int alertLevel = 1;

        AlertLevelAndroid result1 = new AlertLevelAndroid(alertLevel);
        assertEquals(alertLevel, result1.getAlertLevel());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AlertLevel.ALERT_LEVEL_MILD_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertLevelAndroid result1 = new AlertLevelAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertLevelAndroid result2 = AlertLevelAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getAlertLevel(), result2.getAlertLevel());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AlertLevel.ALERT_LEVEL_MILD_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertLevelAndroid result1 = new AlertLevelAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AlertLevel.ALERT_LEVEL_MILD_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertLevelAndroid result1 = new AlertLevelAndroid(bluetoothGattCharacteristic);
        AlertLevelAndroid result2 = AlertLevelAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
