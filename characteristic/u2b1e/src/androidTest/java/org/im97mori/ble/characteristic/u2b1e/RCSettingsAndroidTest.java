package org.im97mori.ble.characteristic.u2b1e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class RCSettingsAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_TRUE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_TRUE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_TRUE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_TRUE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_TRUE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_2;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00502 = data;
    }

    private static final byte[] data_00503;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_3;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00503 = data;
    }

    private static final byte[] data_00504;
    static {
        byte[] data = new byte[3];
        int flags = RCSettings.SETTINGS_LESC_ONLY_FALSE
                | RCSettings.SETTINGS_USE_OOB_PAIRING_FALSE
                | RCSettings.SETTINGS_READY_FOR_DISCONNECT_FALSE
                | RCSettings.SETTINGS_LIMITED_ACCESS_FALSE
                | RCSettings.SETTINGS_ACCESS_PERMITTED_FALSE
                | RCSettings.SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_4;
        data[ 0] = 0x03;
        data[ 1] = (byte) flags;
        data[ 2] = (byte) (flags >> 8);
        data_00504 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertTrue(result1.isSettingsLescOnlyFalse());
        assertFalse(result1.isSettingsLescOnlyTrue());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsLescOnlyFalse());
        assertTrue(result1.isSettingsLescOnlyTrue());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertTrue(result1.isSettingsUseOobPairingFalse());
        assertFalse(result1.isSettingsUseOobPairingTrue());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsUseOobPairingFalse());
        assertTrue(result1.isSettingsUseOobPairingTrue());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertTrue(result1.isSettingsReadyForDisconnectFalse());
        assertFalse(result1.isSettingsReadyForDisconnectTrue());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsReadyForDisconnectFalse());
        assertTrue(result1.isSettingsReadyForDisconnectTrue());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertTrue(result1.isSettingsLimitedAccessFalse());
        assertFalse(result1.isSettingsLimitedAccessTrue());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsLimitedAccessFalse());
        assertTrue(result1.isSettingsLimitedAccessTrue());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertTrue(result1.isSettingsAccessPermittedFalse());
        assertFalse(result1.isSettingsAccessPermittedTrue());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsAccessPermittedFalse());
        assertTrue(result1.isSettingsAccessPermittedTrue());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertTrue(result1.isSettingsAdvertisementConfiguration1());
        assertFalse(result1.isSettingsAdvertisementConfiguration2());
        assertFalse(result1.isSettingsAdvertisementConfiguration3());
        assertFalse(result1.isSettingsAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsAdvertisementConfiguration1());
        assertTrue(result1.isSettingsAdvertisementConfiguration2());
        assertFalse(result1.isSettingsAdvertisementConfiguration3());
        assertFalse(result1.isSettingsAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsAdvertisementConfiguration1());
        assertFalse(result1.isSettingsAdvertisementConfiguration2());
        assertTrue(result1.isSettingsAdvertisementConfiguration3());
        assertFalse(result1.isSettingsAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertEquals(3, result1.getLength());
        assertFalse(result1.isSettingsAdvertisementConfiguration1());
        assertFalse(result1.isSettingsAdvertisementConfiguration2());
        assertFalse(result1.isSettingsAdvertisementConfiguration3());
        assertTrue(result1.isSettingsAdvertisementConfiguration4());
    }

    @Test
    public void test_constructor_00505() {
        int length = 1;
        int settings = 2;
        int e2eCrc = 3;

        RCSettingsAndroid result1 = new RCSettingsAndroid(length, settings, e2eCrc);
        assertEquals(length, result1.getLength());
        assertEquals(settings, result1.getSettings());
        assertEquals(e2eCrc, result1.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_1_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getSettings(), result2.getSettings());
        assertEquals(result1.getE2eCrc(), result2.getE2eCrc());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RCSettingsAndroid result1 = new RCSettingsAndroid(bluetoothGattCharacteristic);
        RCSettingsAndroid result2 = RCSettingsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
