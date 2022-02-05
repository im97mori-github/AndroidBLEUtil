package org.im97mori.ble.descriptor.u290b;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class EnvironmentalSensingConfigurationAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(bluetoothGattDescriptor);
        assertEquals(value[0], result.getTriggerLogicValue());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingConfigurationAndroid.TRIGGER_LOGIC_VALUE_BOOLAEN_AND;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(bluetoothGattDescriptor);
        assertTrue(result.isTriggerLogicValueBooleanAnd());
        assertFalse(result.isTriggerLogicValueBooleanOr());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingConfigurationAndroid.TRIGGER_LOGIC_VALUE_BOOLAEN_OR;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(bluetoothGattDescriptor);
        assertFalse(result.isTriggerLogicValueBooleanAnd());
        assertTrue(result.isTriggerLogicValueBooleanOr());
    }

    @Test
    public void test_constructor004() {
        int triggerLogicValue = 1;

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(triggerLogicValue);
        assertEquals(triggerLogicValue, result.getTriggerLogicValue());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfigurationAndroid result1 = new EnvironmentalSensingConfigurationAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnvironmentalSensingConfigurationAndroid result2 = EnvironmentalSensingConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getTriggerLogicValue(), result2.getTriggerLogicValue());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfigurationAndroid result1 = new EnvironmentalSensingConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfigurationAndroid result1 = new EnvironmentalSensingConfigurationAndroid(bluetoothGattDescriptor);
        EnvironmentalSensingConfigurationAndroid result2 = EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
