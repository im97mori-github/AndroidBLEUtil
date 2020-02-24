package org.im97mori.ble.characteristic.bms;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
public class BondManagementControlPointTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE;
        data[ 1] = '0';
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR;
        data[ 1] = '1';
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_LE;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_LE;
        data[ 1] = '2';
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR_LE;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR_LE;
        data[ 1] = '3';
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR;
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR;
        data[ 1] = '4';
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_LE;
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_LE;
        data[ 1] = '5';
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR_LE;
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR_LE;
        data[ 1] = '6';
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR;
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR;
        data[ 1] = '7';
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[1];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_LE;
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[2];
        data[ 0] = BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_LE;
        data[ 1] = '8';
        data_00802 = data;
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

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, result1.getOpCode());
        assertTrue(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, result1.getOpCode());
        assertTrue(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertTrue(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertTrue(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertTrue(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertTrue(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertTrue(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertTrue(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertTrue(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_BR_EDR, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertTrue(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertTrue(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BONDS_ON_SERVER_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertTrue(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertTrue(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertTrue(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertTrue(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_BR_EDR, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertTrue(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertTrue(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNull(result1.getOperand());
    }

    @Test
    public void test_constructor_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertEquals(BondManagementControlPoint.OP_CODE_DELETE_ALL_BUT_THE_ACTIVIE_BOND_ON_SERVER_LE, result1.getOpCode());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdrLe());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceBrEdr());
        assertFalse(result1.isOpCodeDeleteBondOfRequestingDeviceLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerBrEdr());
        assertFalse(result1.isOpCodeDeleteAllBondsOnServerLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdrLe());
        assertFalse(result1.isOpCodeDeleteAllButTheActiveBondOnServerBrEdr());
        assertTrue(result1.isOpCodeDeleteAllButTheActiveBondOnServerLe());
        assertNotNull(result1.getOperand());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_1_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getOperand(), result2.getOperand());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00802() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BondManagementControlPoint result1 = new BondManagementControlPoint(bluetoothGattCharacteristic);
        BondManagementControlPoint result2 = BondManagementControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
