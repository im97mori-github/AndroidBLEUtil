package org.im97mori.ble.characteristic.u2a21;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MeasurementIntervalAndroidTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = MeasurementInterval.MEASUREMENT_INTERVAL_NO_PERIODIC_MEASUREMENT;
        data[ 1] = MeasurementInterval.MEASUREMENT_INTERVAL_NO_PERIODIC_MEASUREMENT >> 8;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MeasurementIntervalAndroid result1 = new MeasurementIntervalAndroid(bluetoothGattCharacteristic);
        assertEquals(MeasurementInterval.MEASUREMENT_INTERVAL_NO_PERIODIC_MEASUREMENT, result1.getMeasurementInterval());
        assertTrue(result1.isMeasurementIntevalNoPeriodicMeasurement());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MeasurementIntervalAndroid result1 = new MeasurementIntervalAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getMeasurementInterval());
        assertFalse(result1.isMeasurementIntevalNoPeriodicMeasurement());
    }

    @Test
    public void test_constructor003() {
        int measurementInterval = 1;

        MeasurementIntervalAndroid result1 = new MeasurementIntervalAndroid(measurementInterval);
        assertEquals(measurementInterval, result1.getMeasurementInterval());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 0] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MeasurementIntervalAndroid result1 = new MeasurementIntervalAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MeasurementIntervalAndroid result2 = MeasurementIntervalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMeasurementInterval(), result2.getMeasurementInterval());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 0] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MeasurementIntervalAndroid result1 = new MeasurementIntervalAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 0] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MeasurementIntervalAndroid result1 = new MeasurementIntervalAndroid(bluetoothGattCharacteristic);
        MeasurementIntervalAndroid result2 = MeasurementIntervalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
