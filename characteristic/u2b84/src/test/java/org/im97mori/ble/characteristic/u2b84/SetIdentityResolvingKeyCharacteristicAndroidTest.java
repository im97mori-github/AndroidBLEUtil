package org.im97mori.ble.characteristic.u2b84;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class SetIdentityResolvingKeyCharacteristicAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[17];
        data[ 0] = SetIdentityResolvingKeyCharacteristic.TYPE_ENCRYPTED_SIRK;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[17];
        data[ 0] = SetIdentityResolvingKeyCharacteristic.TYPE_PLAIN_TEXT_SIRK;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        data_00002 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		assertEquals(SetIdentityResolvingKeyCharacteristic.TYPE_ENCRYPTED_SIRK, result1.getType());
		assertTrue(result1.isTypeEncryptedSirk());
		assertFalse(result1.isTypePlainTextSirk());
		assertArrayEquals(Arrays.copyOfRange(data, 1, 17), result1.getValue());
	}

	@Test
	public void test_constructor_00002() {
		byte[] data = getData();

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		assertEquals(SetIdentityResolvingKeyCharacteristic.TYPE_PLAIN_TEXT_SIRK, result1.getType());
		assertFalse(result1.isTypeEncryptedSirk());
		assertTrue(result1.isTypePlainTextSirk());
		assertArrayEquals(Arrays.copyOfRange(data, 1, 17), result1.getValue());
	}

	@Test
	public void test_constructor_00101() {
		int type = SetIdentityResolvingKeyCharacteristic.TYPE_ENCRYPTED_SIRK;
		byte[] value = new byte[16];

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(type, value);
		assertEquals(type, result1.getType());
		assertTrue(result1.isTypeEncryptedSirk());
		assertFalse(result1.isTypePlainTextSirk());
		assertArrayEquals(value, result1.getValue());
	}

	@Test
	public void test_constructor_00102() {
		int type = SetIdentityResolvingKeyCharacteristic.TYPE_PLAIN_TEXT_SIRK;
		byte[] value = new byte[16];

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(type, value);
		assertEquals(type, result1.getType());
		assertFalse(result1.isTypeEncryptedSirk());
		assertTrue(result1.isTypePlainTextSirk());
		assertArrayEquals(value, result1.getValue());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		SetIdentityResolvingKeyCharacteristicAndroid result2 = SetIdentityResolvingKeyCharacteristicAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getType(), result2.getType());
		assertArrayEquals(result1.getValue(), result2.getValue());
	}

	@Test
	public void test_parcelable_1_00002() {
		byte[] data = getData();

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		SetIdentityResolvingKeyCharacteristicAndroid result2 = SetIdentityResolvingKeyCharacteristicAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getType(), result2.getType());
		assertArrayEquals(result1.getValue(), result2.getValue());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();


		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00002() {
		byte[] data = getData();


		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		SetIdentityResolvingKeyCharacteristicAndroid result2 = SetIdentityResolvingKeyCharacteristicAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00002() {
		byte[] data = getData();

		SetIdentityResolvingKeyCharacteristicAndroid result1 = new SetIdentityResolvingKeyCharacteristicAndroid(data);
		SetIdentityResolvingKeyCharacteristicAndroid result2 = SetIdentityResolvingKeyCharacteristicAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
