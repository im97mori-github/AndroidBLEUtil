package org.im97mori.ble.characteristic.u2ae8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"ConstantConditions", "WrapperTypeMayBePrimitive"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CoefficientAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NAN;
        data[ 1] = (byte) (BLEUtils.FLOAT_NAN >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NAN >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NAN >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertEquals(Double.NaN, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NRES;
        data[ 1] = (byte) (BLEUtils.FLOAT_NRES >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NRES >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NRES >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertNull(result.getCoefficient());
        assertTrue(result.isNres());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_POSITIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 24);
        //@formatter:on

        Coefficient result = new Coefficient(data);
        assertEquals(Double.POSITIVE_INFINITY, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NEGATIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertEquals(Double.NEGATIVE_INFINITY, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_RFU;
        data[ 1] = (byte) (BLEUtils.FLOAT_RFU >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_RFU >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_RFU >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertNull(result.getCoefficient());
        assertFalse(result.isNres());
    }

    @Test
    public void test_constructor_00006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result = new CoefficientAndroid(bluetoothGattCharacteristic);
        BigDecimal bd = BigDecimal.valueOf(0x00030201);
        bd = bd.round(new MathContext(8, RoundingMode.DOWN));
        assertEquals(bd.doubleValue(), result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00007() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result = new CoefficientAndroid(bluetoothGattCharacteristic);
        BigDecimal bd = BigDecimal.valueOf(0x00030201);
        bd = bd.multiply(BigDecimal.valueOf(10000));
        bd = bd.round(new MathContext(8, RoundingMode.DOWN));
        assertEquals(bd.doubleValue(), result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00008() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result = new CoefficientAndroid(bluetoothGattCharacteristic);
        BigDecimal bd = BigDecimal.valueOf(0x00030201);
        bd = bd.scaleByPowerOfTen(-1);
        bd = bd.round(new MathContext(8, RoundingMode.DOWN));
        assertEquals(bd.doubleValue(), result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NAN;
        data[ 1] = (byte) (BLEUtils.FLOAT_NAN >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NAN >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NAN >> 24);
        //@formatter:on

        Double coefficient = BLEUtils.createFloat(data, 0);

        CoefficientAndroid result = new CoefficientAndroid(coefficient);
        assertEquals(coefficient, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00102() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_POSITIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 24);
        //@formatter:on

        Double coefficient = BLEUtils.createFloat(data, 0);

        CoefficientAndroid result = new CoefficientAndroid(coefficient);
        assertEquals(coefficient, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00103() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NEGATIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 24);
        //@formatter:on

        Double coefficient = BLEUtils.createFloat(data, 0);

        CoefficientAndroid result = new CoefficientAndroid(coefficient);
        assertEquals(coefficient, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00104() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x00;
        //@formatter:on

        Double coefficient = BLEUtils.createFloat(data, 0);

        CoefficientAndroid result = new CoefficientAndroid(coefficient);
        assertEquals(coefficient, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00105() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        Double coefficient = BLEUtils.createFloat(data, 0);

        CoefficientAndroid result = new CoefficientAndroid(coefficient);
        assertEquals(coefficient, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00106() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        Double coefficient = BLEUtils.createFloat(data, 0);

        CoefficientAndroid result = new CoefficientAndroid(coefficient);
        assertEquals(coefficient, result.getCoefficient(), 0);
    }

    @Test
    public void test_constructor_00107() {
        boolean isNres = false;

        CoefficientAndroid result = new CoefficientAndroid(isNres);
        assertEquals(isNres, result.isNres());
    }

    @Test
    public void test_constructor_00108() {
        boolean isNres = true;

        CoefficientAndroid result = new CoefficientAndroid(isNres);
        assertEquals(isNres, result.isNres());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NAN;
        data[ 1] = (byte) (BLEUtils.FLOAT_NAN >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NAN >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NAN >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NRES;
        data[ 1] = (byte) (BLEUtils.FLOAT_NRES >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NRES >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NRES >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_POSITIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NEGATIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }

    @Test
    public void test_parcelable_00005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_RFU;
        data[ 1] = (byte) (BLEUtils.FLOAT_RFU >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_RFU >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_RFU >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }

    @Test
    public void test_parcelable_00006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }

    @Test
    public void test_parcelable_00007() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }

    @Test
    public void test_parcelable_00008() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCoefficient(), result1.getCoefficient());
        assertEquals(result2.isNres(), result1.isNres());
    }


    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NAN;
        data[ 1] = (byte) (BLEUtils.FLOAT_NAN >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NAN >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NAN >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NRES;
        data[ 1] = (byte) (BLEUtils.FLOAT_NRES >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NRES >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NRES >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_POSITIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NEGATIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00105() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_RFU;
        data[ 1] = (byte) (BLEUtils.FLOAT_RFU >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_RFU >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_RFU >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00106() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00107() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00108() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NAN;
        data[ 1] = (byte) (BLEUtils.FLOAT_NAN >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NAN >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NAN >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NRES;
        data[ 1] = (byte) (BLEUtils.FLOAT_NRES >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NRES >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NRES >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_POSITIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_POSITIVE_INFINITY >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_NEGATIVE_INFINITY;
        data[ 1] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_NEGATIVE_INFINITY >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00205() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.FLOAT_RFU;
        data[ 1] = (byte) (BLEUtils.FLOAT_RFU >> 8);
        data[ 2] = (byte) (BLEUtils.FLOAT_RFU >> 16);
        data[ 3] = (byte) (BLEUtils.FLOAT_RFU >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00206() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00207() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00208() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CoefficientAndroid result1 = new CoefficientAndroid(bluetoothGattCharacteristic);
        CoefficientAndroid result2 = CoefficientAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
