package org.im97mori.ble.characteristic.u2b49;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings({ "unused" })
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
		// required to access final members on androidx.loader.content.ModernAsyncTask
		"androidx.loader.content"}
		, sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class StrideLengthAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data_00001 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		StrideLengthAndroid result1 = new StrideLengthAndroid(data);
		assertEquals(BLEUtils.createUInt16(data, 0), result1.getStrideLength());
		assertEquals(BLEUtils.createUInt16(data, 0) * StrideLength.STRIDE_COUNT_RESOLUTION,
				result1.getStrideLengthMeter(), 0);
	}

	@Test
	public void test_constructor_00101() {
		int strideLength = 1;

		StrideLengthAndroid result1 = new StrideLengthAndroid(strideLength);
		assertEquals(strideLength, result1.getStrideLength());
		assertEquals(strideLength * StrideLength.STRIDE_COUNT_RESOLUTION, result1.getStrideLengthMeter(), 0);
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		StrideLengthAndroid result1 = new StrideLengthAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		StrideLengthAndroid result2 = StrideLengthAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getStrideLength(), result2.getStrideLength());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		StrideLengthAndroid result1 = new StrideLengthAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		StrideLengthAndroid result1 = new StrideLengthAndroid(data);
		StrideLengthAndroid result2 = StrideLengthAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
