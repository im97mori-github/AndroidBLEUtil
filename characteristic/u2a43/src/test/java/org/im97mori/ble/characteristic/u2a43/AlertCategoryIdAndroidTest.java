package org.im97mori.ble.characteristic.u2a43;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.AlertCategoryIdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class AlertCategoryIdAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_EMAIL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_EMAIL, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_NEWS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_NEWS, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_CALL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_CALL, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00008() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00009() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00010() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        assertEquals(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE, result1.getCategoryId());
    }

    @Test
    public void test_constructor_00101() {
        int categoryId = 0x01;

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(categoryId);
        assertEquals(categoryId, result1.getCategoryId());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AlertCategoryIdAndroid result2 = AlertCategoryIdAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryId(), result2.getCategoryId());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
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

        AlertCategoryIdAndroid result1 = new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        AlertCategoryIdAndroid result2 = AlertCategoryIdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
