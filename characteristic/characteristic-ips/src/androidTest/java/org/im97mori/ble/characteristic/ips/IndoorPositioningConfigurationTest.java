package org.im97mori.ble.characteristic.ips;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.IndoorPositioningUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused", "ConstantConditions"})
public class IndoorPositioningConfigurationTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        int flags = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        data[ 0] = (byte) flags;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        int flags = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        data[ 0] = (byte) flags;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[1];
        int flags = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        data[ 0] = (byte) flags;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[1];
        int flags = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        data[ 0] = (byte) flags;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[1];
        int flags = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        data[ 0] = (byte) flags;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[1];
        int flags = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        data[ 0] = (byte) flags;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[1];
        int flags = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT;
        data[ 0] = (byte) flags;
        data_00007 = data;
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

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertEquals(IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT, result1.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertEquals(IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT, result1.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertEquals(IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT, result1.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertEquals(IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT, result1.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertEquals(IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT, result1.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertEquals(IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT, result1.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertEquals(IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT, result1.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
    }


    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IndoorPositioningConfiguration result1 = new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        IndoorPositioningConfiguration result2 = IndoorPositioningConfiguration.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
