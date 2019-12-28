package org.im97mori.ble.characteristic.ans;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SupportedUnreadAlertCategoryTest {

    @Test
    public void test_constructor001() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertEquals(flags1, result1.getCategoryIdBitMask0());
    }

    @Test
    public void test_constructor002() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertEquals(flags1, result1.getCategoryIdBitMask0());
    }

    @Test
    public void test_constructor101() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertEquals(flags1, result1.getCategoryIdBitMask0());
        assertEquals(flags2, result1.getCategoryIdBitMask1());
    }

    @Test
    public void test_constructor102() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertEquals(flags1, result1.getCategoryIdBitMask0());
        assertEquals(flags2, result1.getCategoryIdBitMask1());
    }

    @Test
    public void test_parcelable001() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryIdBitMask0(), result2.getCategoryIdBitMask0());
        assertEquals(result1.getCategoryIdBitMask1(), result2.getCategoryIdBitMask1());
    }

    @Test
    public void test_parcelable002() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryIdBitMask0(), result2.getCategoryIdBitMask0());
        assertEquals(result1.getCategoryIdBitMask1(), result2.getCategoryIdBitMask1());
    }

    @Test
    public void test_parcelable003() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryIdBitMask0(), result2.getCategoryIdBitMask0());
        assertEquals(result1.getCategoryIdBitMask1(), result2.getCategoryIdBitMask1());
    }

    @Test
    public void test_parcelable004() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getCategoryIdBitMask0(), result2.getCategoryIdBitMask0());
        assertEquals(result1.getCategoryIdBitMask1(), result2.getCategoryIdBitMask1());
    }

    @Test
    public void test_parcelable101() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) flags1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        int flags1 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED;
        int flags2 = AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED
                | AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags1;
        data[ 1] = (byte) flags2;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedUnreadAlertCategory result1 = new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        SupportedUnreadAlertCategory result2 = SupportedUnreadAlertCategory.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
