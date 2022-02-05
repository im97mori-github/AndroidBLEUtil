package org.im97mori.ble.characteristic.u2b2d;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

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
public class EmergencyIdAndroidTest extends TestBase {

	//@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data_00001 = data;
    }
    //@formatter:on

	@Test
	public void test_constructor_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		EmergencyIdAndroid result1 = new EmergencyIdAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getEmergencyId());
	}

	@Test
	public void test_parcelable_1_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		EmergencyIdAndroid result1 = new EmergencyIdAndroid(bluetoothGattCharacteristic);
		Parcel parcel = Parcel.obtain();
		result1.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		EmergencyIdAndroid result2 = EmergencyIdAndroid.CREATOR.createFromParcel(parcel);
		assertArrayEquals(result1.getEmergencyId(), result2.getEmergencyId());
	}

	@Test
	public void test_parcelable_2_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		EmergencyIdAndroid result1 = new EmergencyIdAndroid(bluetoothGattCharacteristic);
		assertArrayEquals(data, result1.getBytes());
	}

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		EmergencyIdAndroid result1 = new EmergencyIdAndroid(bluetoothGattCharacteristic);
		EmergencyIdAndroid result2 = EmergencyIdAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
