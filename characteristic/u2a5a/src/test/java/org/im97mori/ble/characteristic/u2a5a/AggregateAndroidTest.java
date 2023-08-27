package org.im97mori.ble.characteristic.u2a5a;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.AutomationIoUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class AggregateAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 1), result1.getInputBits(1));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 3), result1.getAnalogInput(1));
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 1), result1.getInputBits(1));
        assertArrayEquals(Arrays.copyOfRange(data, 1, 1), result1.getAnalogInput(1));
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 0), result1.getInputBits(0));
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getAnalogInput(0));
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AggregateAndroid result2 = AggregateAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getInputBits(1), result2.getInputBits(1));
        assertArrayEquals(result1.getAnalogInput(1), result2.getAnalogInput(1));
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AggregateAndroid result2 = AggregateAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getInputBits(1), result2.getInputBits(1));
        assertArrayEquals(result1.getAnalogInput(1), result2.getAnalogInput(1));
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AggregateAndroid result2 = AggregateAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getInputBits(0), result2.getInputBits(0));
        assertArrayEquals(result1.getAnalogInput(0), result2.getAnalogInput(0));
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        AggregateAndroid result2 = AggregateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        AggregateAndroid result2 = AggregateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        AggregateAndroid result1 = new AggregateAndroid(data);
        AggregateAndroid result2 = AggregateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
