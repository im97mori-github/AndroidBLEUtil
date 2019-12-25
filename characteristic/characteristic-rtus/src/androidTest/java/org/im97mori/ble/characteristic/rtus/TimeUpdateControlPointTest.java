package org.im97mori.ble.characteristic.rtus;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimeUpdateControlPointTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        assertEquals(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE, result1.getTimeUpdateControlPoint());
        assertTrue(result1.isTimeUpdateControlPointGetReferenceUpdate());
        assertFalse(result1.isTimeUpdateControlPointCancelReferenceUpdate());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        assertEquals(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE, result1.getTimeUpdateControlPoint());
        assertFalse(result1.isTimeUpdateControlPointGetReferenceUpdate());
        assertTrue(result1.isTimeUpdateControlPointCancelReferenceUpdate());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateControlPoint result2 = TimeUpdateControlPoint.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeUpdateControlPoint(), result1.getTimeUpdateControlPoint());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateControlPoint result2 = TimeUpdateControlPoint.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeUpdateControlPoint(), result1.getTimeUpdateControlPoint());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        TimeUpdateControlPoint result2 = TimeUpdateControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeUpdateControlPoint result1 = new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        TimeUpdateControlPoint result2 = TimeUpdateControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
