package org.im97mori.ble.characteristic.u2a09;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DayOfWeekUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class DayOfWeekAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_IS_NOT_KNOWN, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_MONDAY;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_MONDAY, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_TUESDAY;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_TUESDAY, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_WEDNESDAY;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_WEDNESDAY, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_THURSDAY;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_THURSDAY, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_FRIDAY;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_FRIDAY, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_SATURDAY;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_SATURDAY, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00008() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DayOfWeekUtils.DAY_OF_WEEK_SUNDAY;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertEquals(DayOfWeekUtils.DAY_OF_WEEK_SUNDAY, result1.getDayOfWeek());
    }

    @Test
    public void test_constructor_00101() {
        int dayOfWeek = 1;

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(dayOfWeek);
        assertEquals(dayOfWeek, result1.getDayOfWeek());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DayOfWeekAndroid result2 = DayOfWeekAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getDayOfWeek(), result1.getDayOfWeek());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DayOfWeekAndroid result1 = new DayOfWeekAndroid(bluetoothGattCharacteristic);
        DayOfWeekAndroid result2 = DayOfWeekAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
