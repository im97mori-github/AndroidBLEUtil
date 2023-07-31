package org.im97mori.ble.characteristic.u2aa2;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class LanguageAndroidTest {

    @Test
    public void test_constructor001() {
        String languageCode = "ja";

        LanguageAndroid result1 = new LanguageAndroid(languageCode.getBytes());
        assertEquals(languageCode, result1.getLanguage());
    }

    @Test
    public void test_constructor002() {
        String languageCode = "ab";

        LanguageAndroid result1 = new LanguageAndroid(languageCode.getBytes());
        assertEquals(languageCode, result1.getLanguage());
    }

    @Test
    public void test_constructor003() {
        String languageCode = "ab";

        LanguageAndroid result1 = new LanguageAndroid(languageCode);
        assertEquals(languageCode, result1.getLanguage());
    }

    @Test
    public void test_parcelable001() {
        String languageCode = "ja";

        LanguageAndroid result1 = new LanguageAndroid(languageCode.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LanguageAndroid result2 = LanguageAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLanguage(), result1.getLanguage());
    }

    @Test
    public void test_parcelable002() {
        String languageCode = "ab";

        LanguageAndroid result1 = new LanguageAndroid(languageCode.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LanguageAndroid result2 = LanguageAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLanguage(), result1.getLanguage());
    }

    @Test
    public void test_parcelable003() {
        String languageCode = "ab";

        LanguageAndroid result1 = new LanguageAndroid(languageCode.getBytes());
        byte[] resultData = result1.getBytes();
        assertArrayEquals(languageCode.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String languageCode = "ab";

        LanguageAndroid result1 = new LanguageAndroid(languageCode.getBytes());
        LanguageAndroid result2 = LanguageAndroid.CREATOR.createFromByteArray(languageCode.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
