package org.im97mori.ble.characteristic.u2a8c;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class GenderAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = Gender.GENDER_MALE;
        //@formatter:on

        GenderAndroid result1 = new GenderAndroid(data);
        assertEquals(Gender.GENDER_MALE, result1.getGender());
        assertTrue(result1.isGenderMale());
        assertFalse(result1.isGenderFemale());
        assertFalse(result1.isGenderUnspecified());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        GenderAndroid result1 = new GenderAndroid(data);
        assertEquals(Gender.GENDER_FEMALE, result1.getGender());
        assertFalse(result1.isGenderMale());
        assertTrue(result1.isGenderFemale());
        assertFalse(result1.isGenderUnspecified());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_UNSPECIFIED;
        //@formatter:on

        GenderAndroid result1 = new GenderAndroid(data);
        assertEquals(Gender.GENDER_UNSPECIFIED, result1.getGender());
        assertFalse(result1.isGenderMale());
        assertFalse(result1.isGenderFemale());
        assertTrue(result1.isGenderUnspecified());
    }

    @Test
    public void test_constructor004() {
        int gender = 1;

        GenderAndroid result1 = new GenderAndroid(gender);
        assertEquals(gender, result1.getGender());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        GenderAndroid result1 = new GenderAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        GenderAndroid result2 = GenderAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getGender(), result1.getGender());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        GenderAndroid result1 = new GenderAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = Gender.GENDER_FEMALE;
        //@formatter:on

        GenderAndroid result1 = new GenderAndroid(data);
        GenderAndroid result2 = GenderAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
