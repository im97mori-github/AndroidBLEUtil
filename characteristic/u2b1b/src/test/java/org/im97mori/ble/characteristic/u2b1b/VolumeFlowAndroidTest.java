package org.im97mori.ble.characteristic.u2b1b;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class VolumeFlowAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN, result1.getVolumeFlow());
        assertTrue(result1.isVolumeFlowValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = 0;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getVolumeFlow());
        assertFalse(result1.isVolumeFlowValueIsNotKnown());
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_MINIMUM, result1.getVolumeFlowLitterPerSecond(), 0);
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getVolumeFlow());
        assertFalse(result1.isVolumeFlowValueIsNotKnown());
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_MAXIMUM, result1.getVolumeFlowLitterPerSecond(), 0);
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getVolumeFlow());
        assertFalse(result1.isVolumeFlowValueIsNotKnown());
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_UNIT * BLEUtils.createUInt16(data, 0), result1.getVolumeFlowLitterPerSecond(), 0);
    }

    @Test
    public void test_constructor_00101() {
        int volumeFlow = VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN;

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(volumeFlow);
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN, result1.getVolumeFlow());
        assertTrue(result1.isVolumeFlowValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int volumeFlow = 0;

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(volumeFlow);
        assertEquals(volumeFlow, result1.getVolumeFlow());
        assertFalse(result1.isVolumeFlowValueIsNotKnown());
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_MINIMUM, result1.getVolumeFlowLitterPerSecond(), 0);
    }

    @Test
    public void test_constructor_00103() {
        int volumeFlow = 65534;

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(volumeFlow);
        assertEquals(volumeFlow, result1.getVolumeFlow());
        assertFalse(result1.isVolumeFlowValueIsNotKnown());
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_MAXIMUM, result1.getVolumeFlowLitterPerSecond(), 0);
    }

    @Test
    public void test_constructor_00104() {
        int volumeFlow = 1;

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(volumeFlow);
        assertEquals(volumeFlow, result1.getVolumeFlow());
        assertFalse(result1.isVolumeFlowValueIsNotKnown());
        assertEquals(VolumeFlow.VOLUME_FLOW_VALUE_UNIT * volumeFlow, result1.getVolumeFlowLitterPerSecond(), 0);
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getVolumeFlow(), result1.getVolumeFlow());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = 0;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getVolumeFlow(), result1.getVolumeFlow());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getVolumeFlow(), result1.getVolumeFlow());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getVolumeFlow(), result1.getVolumeFlow());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = 0;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VolumeFlow.VOLUME_FLOW_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = 0;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        VolumeFlowAndroid result1 = new VolumeFlowAndroid(data);
        VolumeFlowAndroid result2 = VolumeFlowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
