package org.im97mori.ble.characteristic.u2b4a;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

@SuppressWarnings({"unused", "ConstantConditions"})
public class HandednessAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = Handedness.HANDEDNESS_LEFT_HANDED;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[ 0] = Handedness.HANDEDNESS_RIGHT_HANDED;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[1];
        data[ 0] = Handedness.HANDEDNESS_AMBIDEXTROUS;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[1];
        data[ 0] = Handedness.HANDEDNESS_UNSPECIFIED;
        data_00004 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertEquals(Handedness.HANDEDNESS_LEFT_HANDED, result1.getHandedness());
        assertTrue(result1.isHandednessLeftHanded());
        assertFalse(result1.isHandednessRightHanded());
        assertFalse(result1.isHandednessAmbidextrous());
        assertFalse(result1.isHandednessUnspecified());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertEquals(Handedness.HANDEDNESS_RIGHT_HANDED, result1.getHandedness());
        assertFalse(result1.isHandednessLeftHanded());
        assertTrue(result1.isHandednessRightHanded());
        assertFalse(result1.isHandednessAmbidextrous());
        assertFalse(result1.isHandednessUnspecified());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertEquals(Handedness.HANDEDNESS_AMBIDEXTROUS, result1.getHandedness());
        assertFalse(result1.isHandednessLeftHanded());
        assertFalse(result1.isHandednessRightHanded());
        assertTrue(result1.isHandednessAmbidextrous());
        assertFalse(result1.isHandednessUnspecified());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertEquals(Handedness.HANDEDNESS_UNSPECIFIED, result1.getHandedness());
        assertFalse(result1.isHandednessLeftHanded());
        assertFalse(result1.isHandednessRightHanded());
        assertFalse(result1.isHandednessAmbidextrous());
        assertTrue(result1.isHandednessUnspecified());
    }

    @Test
    public void test_constructor_00101() {
        int strideLength = Handedness.HANDEDNESS_LEFT_HANDED;

        HandednessAndroid result1 = new HandednessAndroid(strideLength);
        assertEquals(Handedness.HANDEDNESS_LEFT_HANDED, result1.getHandedness());
        assertTrue(result1.isHandednessLeftHanded());
        assertFalse(result1.isHandednessRightHanded());
        assertFalse(result1.isHandednessAmbidextrous());
        assertFalse(result1.isHandednessUnspecified());
    }

    @Test
    public void test_constructor_00102() {
        int strideLength = Handedness.HANDEDNESS_RIGHT_HANDED;

        HandednessAndroid result1 = new HandednessAndroid(strideLength);
        assertEquals(Handedness.HANDEDNESS_RIGHT_HANDED, result1.getHandedness());
        assertFalse(result1.isHandednessLeftHanded());
        assertTrue(result1.isHandednessRightHanded());
        assertFalse(result1.isHandednessAmbidextrous());
        assertFalse(result1.isHandednessUnspecified());
    }

    @Test
    public void test_constructor_00103() {
        int strideLength = Handedness.HANDEDNESS_AMBIDEXTROUS;

        HandednessAndroid result1 = new HandednessAndroid(strideLength);
        assertEquals(Handedness.HANDEDNESS_AMBIDEXTROUS, result1.getHandedness());
        assertFalse(result1.isHandednessLeftHanded());
        assertFalse(result1.isHandednessRightHanded());
        assertTrue(result1.isHandednessAmbidextrous());
        assertFalse(result1.isHandednessUnspecified());
    }

    @Test
    public void test_constructor_00104() {
        int strideLength = Handedness.HANDEDNESS_UNSPECIFIED;

        HandednessAndroid result1 = new HandednessAndroid(strideLength);
        assertEquals(Handedness.HANDEDNESS_UNSPECIFIED, result1.getHandedness());
        assertFalse(result1.isHandednessLeftHanded());
        assertFalse(result1.isHandednessRightHanded());
        assertFalse(result1.isHandednessAmbidextrous());
        assertTrue(result1.isHandednessUnspecified());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHandedness(), result2.getHandedness());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHandedness(), result2.getHandedness());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHandedness(), result2.getHandedness());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHandedness(), result2.getHandedness());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HandednessAndroid result1 = new HandednessAndroid(bluetoothGattCharacteristic);
        HandednessAndroid result2 = HandednessAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
