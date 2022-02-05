package org.im97mori.ble.characteristic.u2a42;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.AlertCategoryIdBitMaskUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class AlertCategoryIdBitMaskAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00008() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00009() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x00;
        data[ 1] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_constructor_00010() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x00;
        data[ 1] = (byte) AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCategoryIdBitMask());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertCategoryIdBitMaskAndroid result2 = AlertCategoryIdBitMaskAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCategoryIdBitMask(), result2.getCategoryIdBitMask());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertCategoryIdBitMaskAndroid result2 = AlertCategoryIdBitMaskAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCategoryIdBitMask(), result2.getCategoryIdBitMask());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        AlertCategoryIdBitMaskAndroid result2 = AlertCategoryIdBitMaskAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdBitMaskAndroid result1 = new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        AlertCategoryIdBitMaskAndroid result2 = AlertCategoryIdBitMaskAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
