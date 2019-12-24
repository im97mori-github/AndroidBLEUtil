package org.im97mori.ble.characteristic.hts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TemperatureTypeTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT, result1.getTemperatureTextDescription());
        assertTrue(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertTrue(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertTrue(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertTrue(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertTrue(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertTrue(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertTrue(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertTrue(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertTrue(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureType result2 = TemperatureType.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureType result1 = new TemperatureType(bluetoothGattCharacteristic);
        TemperatureType result2 = TemperatureType.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
