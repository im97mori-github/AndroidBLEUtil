package org.im97mori.ble.characteristic.u2a46;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.AlertCategoryIdUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NewAlertAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT;
        data[ 1] = 0;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, result1.getCategoryId());
        assertEquals(0, result1.getNumberOfNewAlert());
        assertNull(result1.getTextStringInformation());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_EMAIL;
        data[ 1] = (byte) 0xff;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_EMAIL, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNull(result1.getTextStringInformation());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_NEWS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_NEWS, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("a", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_CALL, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("ab", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("ab", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("ab", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("ab", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("ab", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("ab", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor010() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE, result1.getCategoryId());
        assertEquals(0xff, result1.getNumberOfNewAlert());
        assertNotNull(result1.getTextStringInformation());
        assertEquals("ab", result1.getTextStringInformation());
    }

    @Test
    public void test_constructor011() {
        int categoryId = 1;
        int numberOfNewAlert = 2;
        String textStringInformation = "3";

        NewAlertAndroid result1 = new NewAlertAndroid(categoryId, numberOfNewAlert, textStringInformation);
        assertEquals(categoryId, result1.getCategoryId());
        assertEquals(numberOfNewAlert, result1.getNumberOfNewAlert());
        assertEquals(textStringInformation, result1.getTextStringInformation());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT;
        data[ 1] = 0;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_EMAIL;
        data[ 1] = (byte) 0xff;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_NEWS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
        assertEquals(result1.getNumberOfNewAlert(), result2.getNumberOfNewAlert());
        assertEquals(result1.getTextStringInformation(), result2.getTextStringInformation());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT;
        data[ 1] = 0;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_EMAIL;
        data[ 1] = (byte) 0xff;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_NEWS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT;
        data[ 1] = 0;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_EMAIL;
        data[ 1] = (byte) 0xff;
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_NEWS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE;
        data[ 1] = (byte) 0xff;
        data[ 2] = 'a';
        data[ 3] = 'b';
        //@formatter:on

        NewAlertAndroid result1 = new NewAlertAndroid(data);
        NewAlertAndroid result2 = NewAlertAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
