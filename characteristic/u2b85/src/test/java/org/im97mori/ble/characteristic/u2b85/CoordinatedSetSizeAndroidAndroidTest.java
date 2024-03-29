package org.im97mori.ble.characteristic.u2b85;

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
public class CoordinatedSetSizeAndroidAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = 2;
        data_00001 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		CoordinatedSetSizeAndroid result1 = new CoordinatedSetSizeAndroid(data);
		assertEquals(BLEUtils.createUInt8(data, 0), result1.getCoordinatedSetSize());
	}

	@Test
	public void test_constructor_00101() {
		int coordinatedSetSize = 2;

		CoordinatedSetSizeAndroid result1 = new CoordinatedSetSizeAndroid(coordinatedSetSize);
		assertEquals(coordinatedSetSize, result1.getCoordinatedSetSize());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		CoordinatedSetSizeAndroid result1 = new CoordinatedSetSizeAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		CoordinatedSetSizeAndroid result2 = CoordinatedSetSizeAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getCoordinatedSetSize(), result2.getCoordinatedSetSize());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		CoordinatedSetSizeAndroid result1 = new CoordinatedSetSizeAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		CoordinatedSetSizeAndroid result1 = new CoordinatedSetSizeAndroid(data);
		CoordinatedSetSizeAndroid result2 = CoordinatedSetSizeAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
