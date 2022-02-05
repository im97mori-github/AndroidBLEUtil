package org.im97mori.ble.characteristic.u2b02;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class MassFlowAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result = new MassFlowAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getMassFlow());
        assertTrue(result.isMassFlowValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MINIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result = new MassFlowAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getMassFlow());
        assertFalse(result.isMassFlowValueIsNotKnown());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MAXIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result = new MassFlowAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getMassFlow());
        assertFalse(result.isMassFlowValueIsNotKnown());
    }

    @Test
    public void test_constructor_00101() {
        int luminousIntensity = MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN;

        MassFlowAndroid result = new MassFlowAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getMassFlow());
        assertTrue(result.isMassFlowValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int luminousIntensity = MassFlow.MASS_FLOW_VALUE_MINIMUM;

        MassFlowAndroid result = new MassFlowAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getMassFlow());
        assertFalse(result.isMassFlowValueIsNotKnown());
    }

    @Test
    public void test_constructor_00103() {
        int luminousIntensity = MassFlow.MASS_FLOW_VALUE_MAXIMUM;

        MassFlowAndroid result = new MassFlowAndroid(luminousIntensity);
        assertEquals(luminousIntensity, result.getMassFlow());
        assertFalse(result.isMassFlowValueIsNotKnown());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MassFlowAndroid result2 = MassFlowAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMassFlow(), result1.getMassFlow());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MINIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MassFlowAndroid result2 = MassFlowAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMassFlow(), result1.getMassFlow());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MAXIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MassFlowAndroid result2 = MassFlowAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMassFlow(), result1.getMassFlow());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MINIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MAXIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        MassFlowAndroid result2 = MassFlowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MINIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        MassFlowAndroid result2 = MassFlowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) MassFlow.MASS_FLOW_VALUE_MAXIMUM;
        data[ 1] = (byte) (MassFlow.MASS_FLOW_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MassFlowAndroid result1 = new MassFlowAndroid(bluetoothGattCharacteristic);
        MassFlowAndroid result2 = MassFlowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
