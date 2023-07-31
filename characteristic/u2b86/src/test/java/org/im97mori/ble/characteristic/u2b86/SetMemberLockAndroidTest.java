package org.im97mori.ble.characteristic.u2b86;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
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
public class SetMemberLockAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = SetMemberLockAndroid.UNLOCKED;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[ 0] = SetMemberLockAndroid.LOCKED;
        data_00002 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		assertEquals(BLEUtils.createUInt8(data, 0), result1.getSetMemberLock());
		assertTrue(result1.isSetMemberLockUnlocked());
		assertFalse(result1.isSetMemberLockLocked());
	}

	@Test
	public void test_constructor_00002() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		assertEquals(BLEUtils.createUInt8(data, 0), result1.getSetMemberLock());
		assertFalse(result1.isSetMemberLockUnlocked());
		assertTrue(result1.isSetMemberLockLocked());
	}

	@Test
	public void test_constructor_00101() {
		int setMemberLock = SetMemberLockAndroid.UNLOCKED;

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(setMemberLock);
		assertEquals(setMemberLock, result1.getSetMemberLock());
		assertTrue(result1.isSetMemberLockUnlocked());
		assertFalse(result1.isSetMemberLockLocked());
	}

	@Test
	public void test_constructor_00102() {
		int setMemberLock = SetMemberLockAndroid.LOCKED;

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(setMemberLock);
		assertEquals(setMemberLock, result1.getSetMemberLock());
		assertFalse(result1.isSetMemberLockUnlocked());
		assertTrue(result1.isSetMemberLockLocked());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		SetMemberLockAndroid result2 = SetMemberLockAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getSetMemberLock(), result2.getSetMemberLock());
	}

	@Test
	public void test_parcelable_1_00002() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		SetMemberLockAndroid result2 = SetMemberLockAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getSetMemberLock(), result2.getSetMemberLock());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00002() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		SetMemberLockAndroid result2 = SetMemberLockAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00002() {
		byte[] data = getData();

		SetMemberLockAndroid result1 = new SetMemberLockAndroid(data);
		SetMemberLockAndroid result2 = SetMemberLockAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
