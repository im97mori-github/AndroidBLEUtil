package org.im97mori.ble.characteristic.u2a41;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class RingerSettingAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerSettingAndroid result1 = new RingerSettingAndroid(bluetoothGattCharacteristic);
        assertEquals(RingerSetting.RINGER_SETTING_SILENT, result1.getRingerSetting());
        assertTrue(result1.isRingerSettingSilent());
        assertFalse(result1.isRingerSettingNormal());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_NORMAL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerSettingAndroid result1 = new RingerSettingAndroid(bluetoothGattCharacteristic);
        assertEquals(RingerSetting.RINGER_SETTING_NORMAL, result1.getRingerSetting());
        assertFalse(result1.isRingerSettingSilent());
        assertTrue(result1.isRingerSettingNormal());
    }

    @Test
    public void test_constructor003() {
        int ringerSetting = 1;

        RingerSettingAndroid result1 = new RingerSettingAndroid(ringerSetting);
        assertEquals(ringerSetting, result1.getRingerSetting());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerSettingAndroid result1 = new RingerSettingAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RingerSettingAndroid result2 = RingerSettingAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRingerSetting(), result2.getRingerSetting());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerSettingAndroid result1 = new RingerSettingAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RingerSettingAndroid result1 = new RingerSettingAndroid(bluetoothGattCharacteristic);
        RingerSettingAndroid result2 = RingerSettingAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
