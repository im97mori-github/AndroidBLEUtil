package org.im97mori.ble.characteristic.u2ae4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ChromaticityCoordinatesAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityCoordinatesAndroid result = new ChromaticityCoordinatesAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getChromaticityXCoordinate());
        assertEquals(BLEUtils.createUInt16(data, 2), result.getChromaticityYCoordinate());
    }

    @Test
    public void test_constructor_00101() {
        int chromaticityXCoordinate = 1;
        int chromaticityYCoordinate = 2;

        ChromaticityCoordinatesAndroid result = new ChromaticityCoordinatesAndroid(chromaticityXCoordinate, chromaticityYCoordinate);
        assertEquals(chromaticityXCoordinate, result.getChromaticityXCoordinate());
        assertEquals(chromaticityYCoordinate, result.getChromaticityYCoordinate());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityCoordinatesAndroid result1 = new ChromaticityCoordinatesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityCoordinatesAndroid result2 = ChromaticityCoordinatesAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getChromaticityXCoordinate(), result1.getChromaticityXCoordinate());
        assertEquals(result2.getChromaticityYCoordinate(), result1.getChromaticityYCoordinate());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityCoordinatesAndroid result1 = new ChromaticityCoordinatesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityCoordinatesAndroid result1 = new ChromaticityCoordinatesAndroid(bluetoothGattCharacteristic);
        ChromaticityCoordinatesAndroid result2 = ChromaticityCoordinatesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
