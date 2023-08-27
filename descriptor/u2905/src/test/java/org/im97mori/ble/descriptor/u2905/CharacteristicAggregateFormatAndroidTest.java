package org.im97mori.ble.descriptor.u2905;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CharacteristicAggregateFormatAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        CharacteristicAggregateFormatAndroid result = new CharacteristicAggregateFormatAndroid(value);
        assertArrayEquals(value, result.getListOfHandles());
        assertEquals(value.length / 2, result.getSize());
        assertEquals((value[0] & 0xff) | ((value[1] & 0xff) << 8), result.getHandle(0));
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        CharacteristicAggregateFormatAndroid result = new CharacteristicAggregateFormatAndroid(value);
        assertArrayEquals(value, result.getListOfHandles());
        assertEquals(value.length / 2, result.getSize());
        assertEquals((value[0] & 0xff) | ((value[1] & 0xff) << 8), result.getHandle(0));
        assertEquals((value[2] & 0xff) | ((value[3] & 0xff) << 8), result.getHandle(1));
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        CharacteristicAggregateFormatAndroid result1 = new CharacteristicAggregateFormatAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicAggregateFormatAndroid result2 = CharacteristicAggregateFormatAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getListOfHandles(), result2.getListOfHandles());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        CharacteristicAggregateFormatAndroid result1 = new CharacteristicAggregateFormatAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        CharacteristicAggregateFormatAndroid result1 = new CharacteristicAggregateFormatAndroid(value);
        CharacteristicAggregateFormatAndroid result2 = CharacteristicAggregateFormatAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
