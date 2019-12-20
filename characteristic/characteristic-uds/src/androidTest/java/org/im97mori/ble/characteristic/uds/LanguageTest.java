package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LanguageTest {

    @Test
    public void test_constructor001() {
        String languageCode = "ja";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(languageCode.getBytes(StandardCharsets.UTF_8));

        Language result1 = new Language(bluetoothGattCharacteristic);
        assertEquals(languageCode, result1.getLanguage());
    }

    @Test
    public void test_constructor002() {
        String languageCode = "ab";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(languageCode.getBytes(StandardCharsets.UTF_8));

        Language result1 = new Language(bluetoothGattCharacteristic);
        assertEquals(languageCode, result1.getLanguage());
    }

    @Test
    public void test_parcelable001() {
        String languageCode = "ja";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(languageCode.getBytes(StandardCharsets.UTF_8));

        Language result1 = new Language(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Language result2 = Language.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLanguage(), result1.getLanguage());
    }

    @Test
    public void test_parcelable002() {
        String languageCode = "ab";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(languageCode.getBytes(StandardCharsets.UTF_8));

        Language result1 = new Language(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Language result2 = Language.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLanguage(), result1.getLanguage());
    }

    @Test
    public void test_parcelable003() {
        String languageCode = "ab";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(languageCode.getBytes(StandardCharsets.UTF_8));

        Language result1 = new Language(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(languageCode.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String languageCode = "ab";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(languageCode.getBytes(StandardCharsets.UTF_8));

        Language result1 = new Language(bluetoothGattCharacteristic);
        Language result2 = Language.CREATOR.createFromByteArray(languageCode.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
