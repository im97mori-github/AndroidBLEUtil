package org.im97mori.ble.characteristic.pass;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlertStatusTest {

    @Test
    public void test_constructor001() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertEquals(flags, result1.getAlertStatus());
        assertTrue(result1.isAlertStatusRingerStateNotActive());
        assertFalse(result1.isAlertStatusRingerStateActive());
    }

    @Test
    public void test_constructor002() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertEquals(flags, result1.getAlertStatus());
        assertFalse(result1.isAlertStatusRingerStateNotActive());
        assertTrue(result1.isAlertStatusRingerStateActive());
    }

    @Test
    public void test_constructor003() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertEquals(flags, result1.getAlertStatus());
        assertTrue(result1.isAlertStatusVibrateStateNotActive());
        assertFalse(result1.isAlertStatusVibrateStateActive());
    }

    @Test
    public void test_constructor004() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertEquals(flags, result1.getAlertStatus());
        assertFalse(result1.isAlertStatusVibrateStateNotActive());
        assertTrue(result1.isAlertStatusVibrateStateActive());
    }

    @Test
    public void test_constructor005() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertEquals(flags, result1.getAlertStatus());
        assertTrue(result1.isAlertStatusDisplayAlertStatusNotActive());
        assertFalse(result1.isAlertStatusDisplayAlertStatusActive());
    }

    @Test
    public void test_constructor006() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertEquals(flags, result1.getAlertStatus());
        assertFalse(result1.isAlertStatusDisplayAlertStatusNotActive());
        assertTrue(result1.isAlertStatusDisplayAlertStatusActive());
    }

    @Test
    public void test_parcelable001() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertStatus result2 = AlertStatus.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getAlertStatus(), result2.getAlertStatus());
    }

    @Test
    public void test_parcelable002() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertStatus result2 = AlertStatus.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getAlertStatus(), result2.getAlertStatus());
    }

    @Test
    public void test_parcelable003() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertStatus result2 = AlertStatus.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getAlertStatus(), result2.getAlertStatus());
    }

    @Test
    public void test_parcelable004() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertStatus result2 = AlertStatus.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getAlertStatus(), result2.getAlertStatus());
    }

    @Test
    public void test_parcelable005() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertStatus result2 = AlertStatus.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getAlertStatus(), result2.getAlertStatus());
    }

    @Test
    public void test_parcelable006() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertStatus result2 = AlertStatus.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getAlertStatus(), result2.getAlertStatus());
    }

    @Test
    public void test_parcelable101() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
       int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }
    @Test
    public void test_parcelable106() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        AlertStatus result2 = AlertStatus.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        AlertStatus result2 = AlertStatus.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        AlertStatus result2 = AlertStatus.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        AlertStatus result2 = AlertStatus.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_NOT_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        AlertStatus result2 = AlertStatus.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        int flags = AlertStatus.ALERT_STATUS_RINGER_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_VIBRATE_STATE_NOT_ACTIVE
                | AlertStatus.ALERT_STATUS_DISPLAY_ALERT_STATUS_ACTIVE;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags;;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertStatus result1 = new AlertStatus(bluetoothGattCharacteristic);
        AlertStatus result2 = AlertStatus.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
