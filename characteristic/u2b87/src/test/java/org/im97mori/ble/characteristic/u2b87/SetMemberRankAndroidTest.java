package org.im97mori.ble.characteristic.u2b87;

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
public class SetMemberRankAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        data_00001 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		SetMemberRankAndroid result1 = new SetMemberRankAndroid(data);
		assertEquals(BLEUtils.createUInt8(data, 0), result1.getSetMemberRank());
	}

	@Test
	public void test_constructor_00101() {
		int setMemberLock = 1;

		SetMemberRankAndroid result1 = new SetMemberRankAndroid(setMemberLock);
		assertEquals(setMemberLock, result1.getSetMemberRank());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		SetMemberRankAndroid result1 = new SetMemberRankAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		SetMemberRankAndroid result2 = SetMemberRankAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getSetMemberRank(), result2.getSetMemberRank());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		SetMemberRankAndroid result1 = new SetMemberRankAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		SetMemberRankAndroid result1 = new SetMemberRankAndroid(data);
		SetMemberRankAndroid result2 = SetMemberRankAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
