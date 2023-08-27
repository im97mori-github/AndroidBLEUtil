package org.im97mori.ble.descriptor.u2901;

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
public class CharacteristicUserDescriptionAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        CharacteristicUserDescriptionAndroid result = new CharacteristicUserDescriptionAndroid(value);
        assertEquals(text, result.getUserDescription());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        CharacteristicUserDescriptionAndroid result1 = new CharacteristicUserDescriptionAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicUserDescriptionAndroid result2 = CharacteristicUserDescriptionAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getUserDescription(), result2.getUserDescription());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        CharacteristicUserDescriptionAndroid result1 = new CharacteristicUserDescriptionAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        String text = "abced";
        byte[] value = text.getBytes();
        //@formatter:on

        CharacteristicUserDescriptionAndroid result1 = new CharacteristicUserDescriptionAndroid(value);
        CharacteristicUserDescriptionAndroid result2 = CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
