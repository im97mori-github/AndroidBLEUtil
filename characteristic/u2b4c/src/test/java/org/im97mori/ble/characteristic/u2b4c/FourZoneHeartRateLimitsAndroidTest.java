package org.im97mori.ble.characteristic.u2b4c;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
		// required to access final members on androidx.loader.content.ModernAsyncTask
		"androidx.loader.content"}
		, sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class FourZoneHeartRateLimitsAndroidTest extends TestBase {

	//@formatter:off
	private static final byte[] data_00001;
    static {
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0xff;
        data[ 2] = (byte) 0xff;
        data_00002 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		assertEquals(0x01, result1.getFourZoneHeartRateLimitsLightModerateLimit());
		assertEquals(0x02, result1.getFourZoneHeartRateLimitsModerateHardLimit());
		assertEquals(0x03, result1.getFourZoneHeartRateLimitsHardMaximumLimit());
	}

	@Test
	public void test_constructor_00002() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		assertEquals(0xff, result1.getFourZoneHeartRateLimitsLightModerateLimit());
		assertEquals(0xff, result1.getFourZoneHeartRateLimitsModerateHardLimit());
		assertEquals(0xff, result1.getFourZoneHeartRateLimitsHardMaximumLimit());

	}

	@Test
	public void test_constructor003() {
		int fourZoneHeartRateLimitsLightModerateLimit = 1;
		int fourZoneHeartRateLimitsModerateHardLimit = 2;
		int fourZoneHeartRateLimitsHardMaximumLimit = 3;

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(fourZoneHeartRateLimitsLightModerateLimit,
				fourZoneHeartRateLimitsModerateHardLimit, fourZoneHeartRateLimitsHardMaximumLimit);
		assertEquals(fourZoneHeartRateLimitsLightModerateLimit, result1.getFourZoneHeartRateLimitsLightModerateLimit());
		assertEquals(fourZoneHeartRateLimitsModerateHardLimit, result1.getFourZoneHeartRateLimitsModerateHardLimit());
		assertEquals(fourZoneHeartRateLimitsHardMaximumLimit, result1.getFourZoneHeartRateLimitsHardMaximumLimit());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		FourZoneHeartRateLimitsAndroid result2 = FourZoneHeartRateLimitsAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getFourZoneHeartRateLimitsLightModerateLimit(), result2.getFourZoneHeartRateLimitsLightModerateLimit());
		assertEquals(result1.getFourZoneHeartRateLimitsModerateHardLimit(), result2.getFourZoneHeartRateLimitsModerateHardLimit());
		assertEquals(result1.getFourZoneHeartRateLimitsHardMaximumLimit(), result2.getFourZoneHeartRateLimitsHardMaximumLimit());
	}

	@Test
	public void test_parcelable_1_00002() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		FourZoneHeartRateLimitsAndroid result2 = FourZoneHeartRateLimitsAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getFourZoneHeartRateLimitsLightModerateLimit(), result2.getFourZoneHeartRateLimitsLightModerateLimit());
		assertEquals(result1.getFourZoneHeartRateLimitsModerateHardLimit(), result2.getFourZoneHeartRateLimitsModerateHardLimit());
		assertEquals(result1.getFourZoneHeartRateLimitsHardMaximumLimit(), result2.getFourZoneHeartRateLimitsHardMaximumLimit());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00002() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		FourZoneHeartRateLimitsAndroid result2 = FourZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00002() {
		byte[] data = getData();

		FourZoneHeartRateLimitsAndroid result1 = new FourZoneHeartRateLimitsAndroid(data);
		FourZoneHeartRateLimitsAndroid result2 = FourZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
