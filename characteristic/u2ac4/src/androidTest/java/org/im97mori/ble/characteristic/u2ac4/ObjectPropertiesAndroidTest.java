package org.im97mori.ble.characteristic.u2ac4;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Arrays;

@SuppressWarnings({"unused", "ConstantConditions"})
public class ObjectPropertiesAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00001 = data;
	}

    private static final byte[] data_00002;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_TRUE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00002 = data;
	}

    private static final byte[] data_00003;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_TRUE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00003 = data;
	}

    private static final byte[] data_00004;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_TRUE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00004 = data;
	}

    private static final byte[] data_00005;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_TRUE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00005 = data;
	}

    private static final byte[] data_00006;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_TRUE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00006 = data;
	}

    private static final byte[] data_00007;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_TRUE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00007 = data;
	}

    private static final byte[] data_00008;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_TRUE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_FALSE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00008 = data;
	}

    private static final byte[] data_00009;
    static {
        int objectProperties = ObjectProperties.OBJECT_PROPERTIES_DELETE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_EXECUTE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_READ_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_WRITE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_APPEND_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_TRUNCATE_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_PATCH_FALSE
        		| ObjectProperties.OBJECT_PROPERTIES_MARK_TRUE;
        byte[] data = new byte[4];
        data[ 0] = (byte) objectProperties;
        data[ 1] = (byte) (objectProperties >> 8);
        data[ 2] = (byte) (objectProperties >> 16);
        data[ 3] = (byte) (objectProperties >> 24);
		data_00009 = data;
	}
	//@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertFalse(result1.isObjectPropertiesDeleteNotPermitted());
        assertTrue(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertFalse(result1.isObjectPropertiesExecuteNotPermitted());
        assertTrue(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertFalse(result1.isObjectPropertiesReadNotPermitted());
        assertTrue(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertFalse(result1.isObjectPropertiesWriteNotPermitted());
        assertTrue(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertFalse(result1.isObjectPropertiesAppendNotPermitted());
        assertTrue(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertFalse(result1.isObjectPropertiesTruncateNotPermitted());
        assertTrue(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertFalse(result1.isObjectPropertiesPatchNotPermitted());
        assertTrue(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertFalse(result1.isObjectPropertiesNotMarked());
        assertTrue(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, false, false, false, false, false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(true, false, false, false, false, false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertFalse(result1.isObjectPropertiesDeleteNotPermitted());
        assertTrue(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, true, false, false, false, false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertFalse(result1.isObjectPropertiesExecuteNotPermitted());
        assertTrue(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, false, true, false, false, false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertFalse(result1.isObjectPropertiesReadNotPermitted());
        assertTrue(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, false, false, true, false, false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertFalse(result1.isObjectPropertiesWriteNotPermitted());
        assertTrue(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, false, false, false, true, false, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertFalse(result1.isObjectPropertiesAppendNotPermitted());
        assertTrue(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, false, false, false, false, true, false, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertFalse(result1.isObjectPropertiesTruncateNotPermitted());
        assertTrue(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, false, false, false, false, false, true, false);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertFalse(result1.isObjectPropertiesPatchNotPermitted());
        assertTrue(result1.isObjectPropertiesPatchPermitted());
        assertTrue(result1.isObjectPropertiesNotMarked());
        assertFalse(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(false, false, false, false, false, false, false, true);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 4), result1.getObjectProperties());
        assertTrue(result1.isObjectPropertiesDeleteNotPermitted());
        assertFalse(result1.isObjectPropertiesDeletePermitted());
        assertTrue(result1.isObjectPropertiesExecuteNotPermitted());
        assertFalse(result1.isObjectPropertiesExecutePermitted());
        assertTrue(result1.isObjectPropertiesReadNotPermitted());
        assertFalse(result1.isObjectPropertiesReadPermitted());
        assertTrue(result1.isObjectPropertiesWriteNotPermitted());
        assertFalse(result1.isObjectPropertiesWritePermitted());
        assertTrue(result1.isObjectPropertiesAppendNotPermitted());
        assertFalse(result1.isObjectPropertiesAppendPermitted());
        assertTrue(result1.isObjectPropertiesTruncateNotPermitted());
        assertFalse(result1.isObjectPropertiesTruncatePermitted());
        assertTrue(result1.isObjectPropertiesPatchNotPermitted());
        assertFalse(result1.isObjectPropertiesPatchPermitted());
        assertFalse(result1.isObjectPropertiesNotMarked());
        assertTrue(result1.isObjectPropertiesMarked());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getObjectProperties(), result1.getObjectProperties());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

	@Test
	public void test_parcelable_3_00001() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00002() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00003() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00004() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00005() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00006() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00007() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00008() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

	@Test
	public void test_parcelable_3_00009() {
		byte[] data = getData();

		BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
		bluetoothGattCharacteristic.setValue(data);

		ObjectPropertiesAndroid result1 = new ObjectPropertiesAndroid(bluetoothGattCharacteristic);
		ObjectPropertiesAndroid result2 = ObjectPropertiesAndroid.CREATOR.createFromByteArray(data);
		assertArrayEquals(result1.getBytes(), result2.getBytes());
	}

}
