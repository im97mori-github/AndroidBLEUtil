package org.im97mori.ble.characteristic.hrs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HeartRateControlPointTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateControlPoint result1 = new HeartRateControlPoint(bluetoothGattCharacteristic);
        assertEquals(0, result1.getHeartRateControlPoint());
        assertFalse(result1.isHeartRateControlPointResetEnergyExpended());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateControlPoint result1 = new HeartRateControlPoint(bluetoothGattCharacteristic);
        assertEquals(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED, result1.getHeartRateControlPoint());
        assertTrue(result1.isHeartRateControlPointResetEnergyExpended());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateControlPoint result1 = new HeartRateControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateControlPoint result2 = HeartRateControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHeartRateControlPoint(), result2.getHeartRateControlPoint());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateControlPoint result1 = new HeartRateControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateControlPoint result1 = new HeartRateControlPoint(bluetoothGattCharacteristic);
        HeartRateControlPoint result2 = HeartRateControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
