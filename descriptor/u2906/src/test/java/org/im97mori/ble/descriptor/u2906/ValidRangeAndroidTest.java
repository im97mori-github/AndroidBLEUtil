package org.im97mori.ble.descriptor.u2906;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ValidRangeAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 1), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 1, 2), result.getUpperInclusiveValue());
        assertEquals(0x01, result.getLowerInclusiveValueUint8());
        assertEquals(0x01, result.getLowerInclusiveValueSint8());
        assertEquals(0x02, result.getUpperInclusiveValueUint8());
        assertEquals(0x02, result.getUpperInclusiveValueSint8());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) 0xff;
        value[ 1] = (byte) 0xfe;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 1), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 1, 2), result.getUpperInclusiveValue());
        assertEquals(0xff, result.getLowerInclusiveValueUint8());
        assertEquals(0xffffffff, result.getLowerInclusiveValueSint8());
        assertEquals(0xfe, result.getUpperInclusiveValueUint8());
        assertEquals(0xfffffffe, result.getUpperInclusiveValueSint8());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 2), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 2, 4), result.getUpperInclusiveValue());
        assertEquals(0x0201, result.getLowerInclusiveValueUint16());
        assertEquals(0x0201, result.getLowerInclusiveValueSint16());
        assertEquals(0x0403, result.getUpperInclusiveValueUint16());
        assertEquals(0x0403, result.getUpperInclusiveValueSint16());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) 0xff;
        value[ 1] = (byte) 0xff;
        value[ 2] = (byte) 0xfe;
        value[ 3] = (byte) 0xfe;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 2), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 2, 4), result.getUpperInclusiveValue());
        assertEquals(0xffff, result.getLowerInclusiveValueUint16());
        assertEquals(0xffffffff, result.getLowerInclusiveValueSint16());
        assertEquals(0xfefe, result.getUpperInclusiveValueUint16());
        assertEquals(0xfffffefe, result.getUpperInclusiveValueSint16());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] value = new byte[6];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 3), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 3, 6), result.getUpperInclusiveValue());
        assertEquals(0x030201, result.getLowerInclusiveValueUint24());
        assertEquals(0x030201, result.getLowerInclusiveValueSint24());
        assertEquals(0x060504, result.getUpperInclusiveValueUint24());
        assertEquals(0x060504, result.getUpperInclusiveValueSint24());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] value = new byte[6];
        value[ 0] = (byte) 0xff;
        value[ 1] = (byte) 0xff;
        value[ 2] = (byte) 0xff;
        value[ 3] = (byte) 0xfe;
        value[ 4] = (byte) 0xfe;
        value[ 5] = (byte) 0xfe;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 3), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 3, 6), result.getUpperInclusiveValue());
        assertEquals(0x00ffffff, result.getLowerInclusiveValueUint24());
        assertEquals(0xffffffff, result.getLowerInclusiveValueSint24());
        assertEquals(0x00fefefe, result.getUpperInclusiveValueUint24());
        assertEquals(0xfffefefe, result.getUpperInclusiveValueSint24());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 4), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 4, 8), result.getUpperInclusiveValue());
        assertEquals(0x04030201L, result.getLowerInclusiveValueUint32());
        assertEquals(0x08070605L, result.getUpperInclusiveValueUint32());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) 0xff;
        value[ 1] = (byte) 0xff;
        value[ 2] = (byte) 0xff;
        value[ 3] = (byte) 0xff;
        value[ 4] = (byte) 0xfe;
        value[ 5] = (byte) 0xfe;
        value[ 6] = (byte) 0xfe;
        value[ 7] = (byte) 0xfe;
        //@formatter:on

        ValidRangeAndroid result = new ValidRangeAndroid(value);
        assertArrayEquals(Arrays.copyOfRange(value, 0, 4), result.getLowerInclusiveValue());
        assertArrayEquals(Arrays.copyOfRange(value, 4, 8), result.getUpperInclusiveValue());
        assertEquals(0xffffffffL, result.getLowerInclusiveValueUint32());
        assertEquals(0xfefefefeL, result.getUpperInclusiveValueUint32());
    }

    @Test
    public void test_constructor009() {
        byte[] lowerInclusiveValue = new byte[]{0};
        byte[] upperInclusiveValue = new byte[]{1};

        ValidRangeAndroid result = new ValidRangeAndroid(lowerInclusiveValue, upperInclusiveValue);
        assertArrayEquals(lowerInclusiveValue, result.getLowerInclusiveValue());
        assertArrayEquals(upperInclusiveValue, result.getUpperInclusiveValue());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ValidRangeAndroid result1 = new ValidRangeAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValidRangeAndroid result2 = ValidRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLowerInclusiveValue(), result2.getLowerInclusiveValue());
        assertEquals(result2.getUpperInclusiveValue(), result2.getUpperInclusiveValue());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ValidRangeAndroid result1 = new ValidRangeAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ValidRangeAndroid result1 = new ValidRangeAndroid(value);
        ValidRangeAndroid result2 = ValidRangeAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        ValidRangeAndroid result1 = new ValidRangeAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValidRangeAndroid result2 = ValidRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLowerInclusiveValue(), result2.getLowerInclusiveValue());
        assertEquals(result2.getUpperInclusiveValue(), result2.getUpperInclusiveValue());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        ValidRangeAndroid result1 = new ValidRangeAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        ValidRangeAndroid result1 = new ValidRangeAndroid(value);
        ValidRangeAndroid result2 = ValidRangeAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
