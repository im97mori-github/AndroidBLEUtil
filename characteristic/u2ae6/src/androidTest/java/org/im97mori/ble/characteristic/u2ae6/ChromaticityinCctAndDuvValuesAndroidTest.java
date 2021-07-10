package org.im97mori.ble.characteristic.u2ae6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class ChromaticityinCctAndDuvValuesAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getChromaticityTolerance());
        assertEquals(BLEUtils.createUInt8(data, 0) * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getChromaticityTolerance());
        assertEquals(BLEUtils.createUInt8(data, 0) * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_constructor_00101() {
        int chromaticityTolerance = 0;

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(chromaticityTolerance);
        assertEquals(chromaticityTolerance, result.getChromaticityTolerance());
        assertEquals(chromaticityTolerance * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_constructor_00102() {
        int chromaticityTolerance = 255;

        ChromaticityToleranceAndroid result = new ChromaticityToleranceAndroid(chromaticityTolerance);
        assertEquals(chromaticityTolerance, result.getChromaticityTolerance());
        assertEquals(chromaticityTolerance * ChromaticityTolerance.CHROMATICITY_VALUE_UNIT, result.getChromaticityToleranceWithUnit(), 0);
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getChromaticityTolerance(), result1.getChromaticityTolerance());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getChromaticityTolerance(), result1.getChromaticityTolerance());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityToleranceAndroid result1 = new ChromaticityToleranceAndroid(bluetoothGattCharacteristic);
        ChromaticityToleranceAndroid result2 = ChromaticityToleranceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
