package org.im97mori.ble.characteristic.u2a56;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.AutomationIoUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class DigitalAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_constructor204() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getDigital());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getDigital(), result2.getDigital());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        DigitalAndroid result1 = new DigitalAndroid(data);
        DigitalAndroid result2 = DigitalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
