package org.im97mori.ble.characteristic.u2b88;

import static org.junit.Assert.assertArrayEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@SuppressWarnings({ "unused" })
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
		// required to access final members on androidx.loader.content.ModernAsyncTask
		"androidx.loader.content"}
		, sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class EncryptedDataKeyMaterialAndroidTest extends TestBase {

	//@formatter:off
	private static final byte[] data_00001;
	static {
		byte[] data = new byte[24];
		data[ 0] = 1;
		data[ 1] = 2;
		data[ 2] = 3;
		data[ 3] = 4;
		data[ 4] = 5;
		data[ 5] = 6;
		data[ 6] = 7;
		data[ 7] = 8;
		data[ 8] = 9;
		data[ 9] = 10;
		data[10] = 11;
		data[11] = 12;
		data[12] = 13;
		data[13] = 14;
		data[14] = 15;
		data[15] = 16;
		data[16] = 17;
		data[17] = 18;
		data[18] = 19;
		data[19] = 20;
		data[20] = 21;
		data[21] = 22;
		data[22] = 23;
		data[23] = 24;
		data_00001 = data;
	}
	//@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		EncryptedDataKeyMaterialAndroid result1 = new EncryptedDataKeyMaterialAndroid(data);
		assertArrayEquals(Arrays.copyOfRange(data, 0, 16), result1.getSessionKey());
		assertArrayEquals(Arrays.copyOfRange(data, 16, 24), result1.getIv());
	}

	@Test
	public void test_constructor_00101() {
		byte[] sessionKey = new byte[16];
		sessionKey[0] = 1;
		sessionKey[1] = 2;
		sessionKey[2] = 3;
		sessionKey[3] = 4;
		sessionKey[4] = 5;
		sessionKey[5] = 6;
		sessionKey[6] = 7;
		sessionKey[7] = 8;
		sessionKey[8] = 9;
		sessionKey[9] = 10;
		sessionKey[10] = 11;
		sessionKey[11] = 12;
		sessionKey[12] = 13;
		sessionKey[13] = 14;
		sessionKey[14] = 15;
		sessionKey[15] = 16;

		byte[] iv = new byte[8];
		iv[0] = 1;
		iv[1] = 2;
		iv[2] = 3;
		iv[3] = 4;
		iv[4] = 5;
		iv[5] = 6;
		iv[6] = 7;
		iv[7] = 8;

		EncryptedDataKeyMaterialAndroid result1 = new EncryptedDataKeyMaterialAndroid(sessionKey, iv);
		assertArrayEquals(sessionKey, result1.getSessionKey());
		assertArrayEquals(iv, result1.getIv());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		EncryptedDataKeyMaterialAndroid result1 = new EncryptedDataKeyMaterialAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		EncryptedDataKeyMaterialAndroid result2 = EncryptedDataKeyMaterialAndroid.CREATOR.createFromParcel(parcel);
		assertArrayEquals(result1.getSessionKey(), result2.getSessionKey());
		assertArrayEquals(result1.getIv(), result2.getIv());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		EncryptedDataKeyMaterialAndroid result1 = new EncryptedDataKeyMaterialAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		EncryptedDataKeyMaterialAndroid result1 = new EncryptedDataKeyMaterialAndroid(data);
		EncryptedDataKeyMaterialAndroid result2 = EncryptedDataKeyMaterialAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
