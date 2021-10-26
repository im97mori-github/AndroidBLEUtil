package org.im97mori.ble.characteristic.u2a01;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.constants.AppearanceValues;
import org.junit.Test;

public class AppearanceAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        data[ 1] = (byte) (AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
        assertEquals(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY,
                result1.getAppearanceValue());
        assertEquals((AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY >> 6) & 0b00000011_11111111,
                result1.getAppearanceCategory());
        assertEquals(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY & 0b11111111_11000000,
                result1.getAppearanceCategoryWithOffset());
        assertEquals(
                AppearanceValues.APPEARANCE_CATEGORY_MAPPING
                        .get(AppearanceValues.OUTDOOR_SPORTS_ACTIVITY_APPEARANCE_CATEGORY),
                result1.getAppearanceCategoryName());
        assertEquals(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY & 0b00111111,
                result1.getAppearanceSubCategory());
        assertEquals(
                AppearanceValues.APPEARANCE_SUB_CATEGORY_MAPPING
                        .get(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY),
                result1.getAppearanceSubCategoryName());
    }

    @Test
    public void test_constructor002() {
        int appearanceValue = AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;

        AppearanceAndroid result1 = new AppearanceAndroid(appearanceValue);
        assertEquals(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY,
                result1.getAppearanceValue());
        assertEquals((AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY >> 6) & 0b00000011_11111111,
                result1.getAppearanceCategory());
        assertEquals(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY & 0b11111111_11000000,
                result1.getAppearanceCategoryWithOffset());
        assertEquals(
                AppearanceValues.APPEARANCE_CATEGORY_MAPPING
                        .get(AppearanceValues.OUTDOOR_SPORTS_ACTIVITY_APPEARANCE_CATEGORY),
                result1.getAppearanceCategoryName());
        assertEquals(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY & 0b00111111,
                result1.getAppearanceSubCategory());
        assertEquals(
                AppearanceValues.APPEARANCE_SUB_CATEGORY_MAPPING
                        .get(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY),
                result1.getAppearanceSubCategoryName());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        data[ 1] = (byte) (AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY >> 8);
        //@formatter:off

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getAppearanceValue(), result2.getAppearanceValue());
        assertEquals(result1.getAppearanceCategory(), result2.getAppearanceCategory());
        assertEquals(result1.getAppearanceCategoryWithOffset(), result2.getAppearanceCategoryWithOffset());
        assertEquals(result1.getAppearanceSubCategory(), result2.getAppearanceSubCategory());
    }
    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        data[ 1] = (byte) (AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY >> 8);
        //@formatter:off

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        data[ 1] = (byte) (AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY >> 8);
        //@formatter:off

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AppearanceAndroid result1 = new AppearanceAndroid(bluetoothGattCharacteristic);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
