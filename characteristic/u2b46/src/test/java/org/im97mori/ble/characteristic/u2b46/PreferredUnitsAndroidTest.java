package org.im97mori.ble.characteristic.u2b46;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.constants.UnitUUID;
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
public class PreferredUnitsAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = (byte) BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT);
        data[ 1] = (byte) (BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT) >> 8);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[4];
        data[ 0] = (byte) BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT);
        data[ 1] = (byte) (BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT) >> 8);
        data[ 2] = (byte) BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT);
        data[ 3] = (byte) (BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT) >> 8);
        data_00002 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		assertArrayEquals(data, result1.getUnits());
		assertEquals(1, result1.getUnitCount());
		assertEquals(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT), result1.getUnit(0));
	}

	@Test
	public void test_constructor_00002() {
		byte[] data = getData();

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		assertArrayEquals(data, result1.getUnits());
		assertEquals(2, result1.getUnitCount());
		assertEquals(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT), result1.getUnit(0));
		assertEquals(BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT), result1.getUnit(1));
	}

	@Test
	public void test_constructor_00101() {
		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(UnitUUID.UNITLESS_UNIT);
		assertArrayEquals(new byte[] { (byte) BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT),
				(byte) (BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT) >> 8) }, result1.getUnits());
		assertEquals(1, result1.getUnitCount());
		assertEquals(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT), result1.getUnit(0));
	}

	@Test
	public void test_constructor_00102() {
		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(UnitUUID.UNITLESS_UNIT, UnitUUID.LENGTH_METRE_UNIT);
		assertArrayEquals(new byte[] { (byte) BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT),
				(byte) (BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT) >> 8),
				(byte) BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT),
				(byte) (BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT) >> 8) }, result1.getUnits());
		assertEquals(2, result1.getUnitCount());
		assertEquals(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT), result1.getUnit(0));
		assertEquals(BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT), result1.getUnit(1));
	}

	@Test
	public void test_constructor_00201() {
		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT));
		assertArrayEquals(new byte[] { (byte) BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT),
				(byte) (BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT) >> 8) }, result1.getUnits());
		assertEquals(1, result1.getUnitCount());
		assertEquals(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT), result1.getUnit(0));
	}

	@Test
	public void test_constructor_00202() {
		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT),
				BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT));
		assertArrayEquals(new byte[] { (byte) BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT),
				(byte) (BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT) >> 8),
				(byte) BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT),
				(byte) (BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT) >> 8) }, result1.getUnits());
		assertEquals(2, result1.getUnitCount());
		assertEquals(BLEUtils.convert128to16(UnitUUID.UNITLESS_UNIT), result1.getUnit(0));
		assertEquals(BLEUtils.convert128to16(UnitUUID.LENGTH_METRE_UNIT), result1.getUnit(1));
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		PreferredUnitsAndroid result2 = PreferredUnitsAndroid.CREATOR.createFromParcel(parcel);
		assertArrayEquals(result1.getUnits(), result2.getUnits());
	}

	@Test
	public void test_parcelable_1_00002() {
		byte[] data = getData();

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		PreferredUnitsAndroid result2 = PreferredUnitsAndroid.CREATOR.createFromParcel(parcel);
		assertArrayEquals(result1.getUnits(), result2.getUnits());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_2_00002() {
		byte[] data = getData();

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		//@formatter:off
		byte[] data = new byte[1];
		data[ 0] = (byte) 0xff;
		//@formatter:on

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		PreferredUnitsAndroid result2 = PreferredUnitsAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00002() {
		//@formatter:off
		byte[] data = new byte[1];
		data[ 0] = (byte) 0xff;
		//@formatter:on

		PreferredUnitsAndroid result1 = new PreferredUnitsAndroid(data);
		PreferredUnitsAndroid result2 = PreferredUnitsAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
