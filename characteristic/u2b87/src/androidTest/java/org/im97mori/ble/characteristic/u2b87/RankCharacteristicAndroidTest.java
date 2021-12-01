package org.im97mori.ble.characteristic.u2b87;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

@SuppressWarnings({ "unused" })
public class RankCharacteristicAndroidTest extends TestBase {

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

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		RankCharacteristicAndroid result1 = new RankCharacteristicAndroid(bluetoothGattCharacteristic);
		assertEquals(BLEUtils.createUInt8(data, 0), result1.getSetMemberRank());
	}

	@Test
	public void test_constructor_00101() {
		int setMemberLock = 1;

		RankCharacteristicAndroid result1 = new RankCharacteristicAndroid(setMemberLock);
		assertEquals(setMemberLock, result1.getSetMemberRank());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		RankCharacteristicAndroid result1 = new RankCharacteristicAndroid(bluetoothGattCharacteristic);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		RankCharacteristicAndroid result2 = RankCharacteristicAndroid.CREATOR.createFromParcel(parcel);
		assertEquals(result1.getSetMemberRank(), result2.getSetMemberRank());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		RankCharacteristicAndroid result1 = new RankCharacteristicAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		RankCharacteristicAndroid result1 = new RankCharacteristicAndroid(bluetoothGattCharacteristic);
		RankCharacteristicAndroid result2 = RankCharacteristicAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
