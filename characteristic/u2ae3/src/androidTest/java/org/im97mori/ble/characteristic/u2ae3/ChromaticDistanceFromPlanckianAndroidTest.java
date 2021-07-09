package org.im97mori.ble.characteristic.u2ae3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ChromaticDistanceFromPlanckianAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticDistanceFromPlanckianAndroid result = new ChromaticDistanceFromPlanckianAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt16(data, 0), result.getDistanceFromPlanckian());
    }

    @Test
    public void test_constructor_00101() {
        int distanceFromPlanckian = 1;

        ChromaticDistanceFromPlanckianAndroid result = new ChromaticDistanceFromPlanckianAndroid(distanceFromPlanckian);
        assertEquals(distanceFromPlanckian, result.getDistanceFromPlanckian());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticDistanceFromPlanckianAndroid result1 = new ChromaticDistanceFromPlanckianAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticDistanceFromPlanckianAndroid result2 = ChromaticDistanceFromPlanckianAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getDistanceFromPlanckian(), result1.getDistanceFromPlanckian());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticDistanceFromPlanckianAndroid result1 = new ChromaticDistanceFromPlanckianAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticDistanceFromPlanckianAndroid result1 = new ChromaticDistanceFromPlanckianAndroid(bluetoothGattCharacteristic);
        ChromaticDistanceFromPlanckianAndroid result2 = ChromaticDistanceFromPlanckianAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
