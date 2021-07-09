package org.im97mori.ble.characteristic.u2ae9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CorrelatedColorTemperatureAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CorrelatedColorTemperatureAndroid result = new CorrelatedColorTemperatureAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCorrelatedColorTemperature());
    }

    @Test
    public void test_constructor_00101() {
        int correlatedColorTemperature = 1;

        CorrelatedColorTemperatureAndroid result = new CorrelatedColorTemperatureAndroid(correlatedColorTemperature);
        assertEquals(correlatedColorTemperature, result.getCorrelatedColorTemperature());
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

        CorrelatedColorTemperatureAndroid result1 = new CorrelatedColorTemperatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CorrelatedColorTemperatureAndroid result2 = CorrelatedColorTemperatureAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCorrelatedColorTemperature(), result1.getCorrelatedColorTemperature());
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

        CorrelatedColorTemperatureAndroid result1 = new CorrelatedColorTemperatureAndroid(bluetoothGattCharacteristic);
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

        CorrelatedColorTemperatureAndroid result1 = new CorrelatedColorTemperatureAndroid(bluetoothGattCharacteristic);
        CorrelatedColorTemperatureAndroid result2 = CorrelatedColorTemperatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
