package org.im97mori.ble.characteristic.u2bf5;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class LeGattSecurityLevelsAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        data_00001 = new byte[0];
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_1;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_1;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_1;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_2;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_1;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_3;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_1;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_4;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_2;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_2_LEVEL_1;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_2;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_2_LEVEL_2;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_3;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_3_LEVEL_1;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_3;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_3_LEVEL_2;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[2];
        data[0] = LeGattSecurityLevels.LE_SECURITY_MODE_3;
        data[1] = LeGattSecurityLevels.LE_SECURITY_MODE_3_LEVEL_3;
        data_00010 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertTrue(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertTrue(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertTrue(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertTrue(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertTrue(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertTrue(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertTrue(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertTrue(result1.isMode3Level2Supported());
        assertFalse(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getSecurityLevelRequirements());
        assertFalse(result1.isMode1Level1Supported());
        assertFalse(result1.isMode1Level2Supported());
        assertFalse(result1.isMode1Level3Supported());
        assertFalse(result1.isMode1Level4Supported());
        assertFalse(result1.isMode2Level1Supported());
        assertFalse(result1.isMode2Level2Supported());
        assertFalse(result1.isMode3Level1Supported());
        assertFalse(result1.isMode3Level2Supported());
        assertTrue(result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00101() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(new byte[0], result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00102() {
        boolean isMode1Level1Supported = true;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_1, LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_1 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00103() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = true;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_1, LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_2 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00104() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = true;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_1, LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_3 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00105() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = true;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_1, LeGattSecurityLevels.LE_SECURITY_MODE_1_LEVEL_4 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00106() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = true;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_2, LeGattSecurityLevels.LE_SECURITY_MODE_2_LEVEL_1 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00107() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = true;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_2, LeGattSecurityLevels.LE_SECURITY_MODE_2_LEVEL_2 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00108() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = true;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = false;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_3, LeGattSecurityLevels.LE_SECURITY_MODE_3_LEVEL_1 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00109() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = true;
        boolean isMode3Level3Supported = false;


        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_3, LeGattSecurityLevels.LE_SECURITY_MODE_3_LEVEL_2 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_constructor_00110() {
        boolean isMode1Level1Supported = false;
        boolean isMode1Level2Supported = false;
        boolean isMode1Level3Supported = false;
        boolean isMode1Level4Supported = false;
        boolean isMode2Level1Supported = false;
        boolean isMode2Level2Supported = false;
        boolean isMode3Level1Supported = false;
        boolean isMode3Level2Supported = false;
        boolean isMode3Level3Supported = true;

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported, isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported, isMode3Level3Supported);
        assertArrayEquals(
                new byte[] { LeGattSecurityLevels.LE_SECURITY_MODE_3, LeGattSecurityLevels.LE_SECURITY_MODE_3_LEVEL_3 },
                result1.getSecurityLevelRequirements());
        assertEquals(isMode1Level1Supported, result1.isMode1Level1Supported());
        assertEquals(isMode1Level2Supported, result1.isMode1Level2Supported());
        assertEquals(isMode1Level3Supported, result1.isMode1Level3Supported());
        assertEquals(isMode1Level4Supported, result1.isMode1Level4Supported());
        assertEquals(isMode2Level1Supported, result1.isMode2Level1Supported());
        assertEquals(isMode2Level2Supported, result1.isMode2Level2Supported());
        assertEquals(isMode3Level1Supported, result1.isMode3Level1Supported());
        assertEquals(isMode3Level2Supported, result1.isMode3Level2Supported());
        assertEquals(isMode3Level3Supported, result1.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getSecurityLevelRequirements(), result2.getSecurityLevelRequirements());
        assertEquals(result1.isMode1Level1Supported(), result2.isMode1Level1Supported());
        assertEquals(result1.isMode1Level2Supported(), result2.isMode1Level2Supported());
        assertEquals(result1.isMode1Level3Supported(), result2.isMode1Level3Supported());
        assertEquals(result1.isMode1Level4Supported(), result2.isMode1Level4Supported());
        assertEquals(result1.isMode2Level1Supported(), result2.isMode2Level1Supported());
        assertEquals(result1.isMode2Level2Supported(), result2.isMode2Level2Supported());
        assertEquals(result1.isMode3Level1Supported(), result2.isMode3Level1Supported());
        assertEquals(result1.isMode3Level2Supported(), result2.isMode3Level2Supported());
        assertEquals(result1.isMode3Level3Supported(), result2.isMode3Level3Supported());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LeGattSecurityLevelsAndroid result1 = new LeGattSecurityLevelsAndroid(bluetoothGattCharacteristic);
        LeGattSecurityLevelsAndroid result2 = LeGattSecurityLevelsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
