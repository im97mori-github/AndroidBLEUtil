package org.im97mori.ble.characteristic.pass;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RingerControlPointTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerControlPoint.RINGER_CONTROL_POINT_SILENT_MODE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerControlPoint result1 = new RingerControlPoint(bluetoothGattCharacteristic);
        assertEquals(RingerControlPoint.RINGER_CONTROL_POINT_SILENT_MODE, result1.getRingerControlPoint());
        assertTrue(result1.isRingerControlPointSilentMode());
        assertFalse(result1.isRingerControlPointMuteOnce());
        assertFalse(result1.isRingerControlPointCancelSilentMode());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerControlPoint.RINGER_CONTROL_POINT_MUTE_ONCE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerControlPoint result1 = new RingerControlPoint(bluetoothGattCharacteristic);
        assertEquals(RingerControlPoint.RINGER_CONTROL_POINT_MUTE_ONCE, result1.getRingerControlPoint());
        assertFalse(result1.isRingerControlPointSilentMode());
        assertTrue(result1.isRingerControlPointMuteOnce());
        assertFalse(result1.isRingerControlPointCancelSilentMode());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerControlPoint.RINGER_CONTROL_POINT_CANCEL_SILENT_MODE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerControlPoint result1 = new RingerControlPoint(bluetoothGattCharacteristic);
        assertEquals(RingerControlPoint.RINGER_CONTROL_POINT_CANCEL_SILENT_MODE, result1.getRingerControlPoint());
        assertFalse(result1.isRingerControlPointSilentMode());
        assertFalse(result1.isRingerControlPointMuteOnce());
        assertTrue(result1.isRingerControlPointCancelSilentMode());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerControlPoint.RINGER_CONTROL_POINT_SILENT_MODE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerControlPoint result1 = new RingerControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RingerControlPoint result2 = RingerControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRingerControlPoint(), result2.getRingerControlPoint());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerControlPoint.RINGER_CONTROL_POINT_SILENT_MODE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerControlPoint result1 = new RingerControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelabl003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerControlPoint.RINGER_CONTROL_POINT_SILENT_MODE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerControlPoint result1 = new RingerControlPoint(bluetoothGattCharacteristic);
        RingerControlPoint result2 = RingerControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
