package org.im97mori.ble.descriptor.u2902;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings({"ConstantConditions", "unused"})
public class ClientCharacteristicConfigurationAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_NOTIFICATIONS_DISABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_NOTIFICATIONS_ENABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_INDICATIONS_DISABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_INDICATIONS_ENABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00004 = data;
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

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesNotificationsDisabled());
        assertFalse(result.isPropertiesNotificationsEnabled());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesNotificationsDisabled());
        assertTrue(result.isPropertiesNotificationsEnabled());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesIndicationsDisabled());
        assertFalse(result.isPropertiesIndicationsEnabled());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesIndicationsDisabled());
        assertTrue(result.isPropertiesIndicationsEnabled());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(data);

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
