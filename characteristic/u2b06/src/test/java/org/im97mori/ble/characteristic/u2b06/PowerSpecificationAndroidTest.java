package org.im97mori.ble.characteristic.u2b06;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.PowerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class PowerSpecificationAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 5] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 6] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getMinimumPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 3), result.getTypicalPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 6), result.getMaximumPowerValue());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getMinimumPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 3), result.getTypicalPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 6), result.getMaximumPowerValue());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        data[ 3] = (byte) 16777214;
        data[ 4] = (byte) (16777214 >> 8);
        data[ 5] = (byte) (16777214 >> 16);
        data[ 6] = (byte) 16777214;
        data[ 7] = (byte) (16777214 >> 8);
        data[ 8] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getMinimumPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 3), result.getTypicalPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 6), result.getMaximumPowerValue());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getMinimumPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 3), result.getTypicalPowerValue());
        assertEquals(BLEUtils.createUInt24(data, 6), result.getMaximumPowerValue());
    }

    @Test
    public void test_constructor_00101() {
        int minimumPowerValue = PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        int typicalPowerValue = PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        int maximumPowerValue = PowerUtils.POWER_VALUE_IS_NOT_KNOWN;

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(minimumPowerValue, typicalPowerValue, maximumPowerValue);
        assertEquals(minimumPowerValue, result.getMinimumPowerValue());
        assertEquals(typicalPowerValue, result.getTypicalPowerValue());
        assertEquals(maximumPowerValue, result.getMaximumPowerValue());
    }

    @Test
    public void test_constructor_00102() {
        int minimumPowerValue = 0;
        int typicalPowerValue = 0;
        int maximumPowerValue = 0;

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(minimumPowerValue, typicalPowerValue, maximumPowerValue);
        assertEquals(minimumPowerValue, result.getMinimumPowerValue());
        assertEquals(typicalPowerValue, result.getTypicalPowerValue());
        assertEquals(maximumPowerValue, result.getMaximumPowerValue());
    }

    @Test
    public void test_constructor_00103() {
        int minimumPowerValue = 16777214;
        int typicalPowerValue = 16777214;
        int maximumPowerValue = 16777214;

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(minimumPowerValue, typicalPowerValue, maximumPowerValue);
        assertEquals(minimumPowerValue, result.getMinimumPowerValue());
        assertEquals(typicalPowerValue, result.getTypicalPowerValue());
        assertEquals(maximumPowerValue, result.getMaximumPowerValue());
    }

    @Test
    public void test_constructor_00104() {
        int minimumPowerValue = 1;
        int typicalPowerValue = 2;
        int maximumPowerValue = 3;

        PowerSpecificationAndroid result = new PowerSpecificationAndroid(minimumPowerValue, typicalPowerValue, maximumPowerValue);
        assertEquals(minimumPowerValue, result.getMinimumPowerValue());
        assertEquals(typicalPowerValue, result.getTypicalPowerValue());
        assertEquals(maximumPowerValue, result.getMaximumPowerValue());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 5] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 6] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumPowerValue(), result1.getMinimumPowerValue());
        assertEquals(result2.getTypicalPowerValue(), result1.getTypicalPowerValue());
        assertEquals(result2.getMaximumPowerValue(), result1.getMaximumPowerValue());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumPowerValue(), result1.getMinimumPowerValue());
        assertEquals(result2.getTypicalPowerValue(), result1.getTypicalPowerValue());
        assertEquals(result2.getMaximumPowerValue(), result1.getMaximumPowerValue());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        data[ 3] = (byte) 16777214;
        data[ 4] = (byte) (16777214 >> 8);
        data[ 5] = (byte) (16777214 >> 16);
        data[ 6] = (byte) 16777214;
        data[ 7] = (byte) (16777214 >> 8);
        data[ 8] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumPowerValue(), result1.getMinimumPowerValue());
        assertEquals(result2.getTypicalPowerValue(), result1.getTypicalPowerValue());
        assertEquals(result2.getMaximumPowerValue(), result1.getMaximumPowerValue());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumPowerValue(), result1.getMinimumPowerValue());
        assertEquals(result2.getTypicalPowerValue(), result1.getTypicalPowerValue());
        assertEquals(result2.getMaximumPowerValue(), result1.getMaximumPowerValue());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 5] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 6] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        data[ 3] = (byte) 16777214;
        data[ 4] = (byte) (16777214 >> 8);
        data[ 5] = (byte) (16777214 >> 16);
        data[ 6] = (byte) 16777214;
        data[ 7] = (byte) (16777214 >> 8);
        data[ 8] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 3] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 5] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        data[ 6] = (byte) PowerUtils.POWER_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) (PowerUtils.POWER_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        data[ 3] = (byte) 16777214;
        data[ 4] = (byte) (16777214 >> 8);
        data[ 5] = (byte) (16777214 >> 16);
        data[ 6] = (byte) 16777214;
        data[ 7] = (byte) (16777214 >> 8);
        data[ 8] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PowerSpecificationAndroid result1 = new PowerSpecificationAndroid(bluetoothGattCharacteristic);
        PowerSpecificationAndroid result2 = PowerSpecificationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
