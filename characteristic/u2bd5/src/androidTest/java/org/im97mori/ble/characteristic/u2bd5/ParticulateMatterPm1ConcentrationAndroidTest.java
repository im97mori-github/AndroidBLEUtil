package org.im97mori.ble.characteristic.u2bd5;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

@SuppressWarnings({"unused", "ConstantConditions"})
public class ParticulateMatterPm1ConcentrationAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        data[ 0] = (byte) BLEUtils.SFLOAT_NRES;
        data[ 1] = (byte) (BLEUtils.SFLOAT_NRES >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        data[ 0] = (byte) BLEUtils.SFLOAT_NAN;
        data[ 1] = (byte) (BLEUtils.SFLOAT_NAN >> 8);
        data_00003 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSfloat(data, 0), result1.getParticulateMatterPm1Concentration().getSfloat(), 0);
        assertFalse(result1.isNres());
        assertFalse(result1.isNan());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        assertTrue(result1.isNres());
        assertFalse(result1.isNan());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        assertFalse(result1.isNres());
        assertTrue(result1.isNan());
    }

    @Test
    public void test_constructor_00101() {
        double particulateMatterPm1Concentration = 1d;
        IEEE_11073_20601_SFLOAT sfloat = new IEEE_11073_20601_SFLOAT(particulateMatterPm1Concentration);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(sfloat);
        assertEquals(particulateMatterPm1Concentration, result1.getParticulateMatterPm1Concentration().getSfloat(), 0);
        assertFalse(result1.isNres());
        assertFalse(result1.isNan());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ParticulateMatterPm1ConcentrationAndroid result2 = ParticulateMatterPm1ConcentrationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getParticulateMatterPm1Concentration().getSfloat(), result2.getParticulateMatterPm1Concentration().getSfloat(), 0);
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ParticulateMatterPm1ConcentrationAndroid result2 = ParticulateMatterPm1ConcentrationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getParticulateMatterPm1Concentration().getSfloat(), result2.getParticulateMatterPm1Concentration().getSfloat(), 0);
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ParticulateMatterPm1ConcentrationAndroid result2 = ParticulateMatterPm1ConcentrationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getParticulateMatterPm1Concentration().getSfloat(), result2.getParticulateMatterPm1Concentration().getSfloat(), 0);
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        ParticulateMatterPm1ConcentrationAndroid result2 = ParticulateMatterPm1ConcentrationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        ParticulateMatterPm1ConcentrationAndroid result2 = ParticulateMatterPm1ConcentrationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ParticulateMatterPm1ConcentrationAndroid result1 = new ParticulateMatterPm1ConcentrationAndroid(bluetoothGattCharacteristic);
        ParticulateMatterPm1ConcentrationAndroid result2 = ParticulateMatterPm1ConcentrationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
