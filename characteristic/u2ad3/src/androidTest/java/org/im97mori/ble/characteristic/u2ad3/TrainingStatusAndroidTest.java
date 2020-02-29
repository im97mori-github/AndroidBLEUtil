package org.im97mori.ble.characteristic.u2ad3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class TrainingStatusAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_OTHER;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_TRUE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_OTHER;
        data[ 2] = 'a';
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_TRUE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_OTHER;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[3];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_TRUE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_TRUE;
        data[ 1] = TrainingStatus.TRANING_STATUS_OTHER;
        data[ 2] = 'a';
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_OTHER;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_IDLE;
        data_00202 = data;
    }

    private static final byte[] data_00203;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_WARMING_UP;
        data_00203 = data;
    }

    private static final byte[] data_00204;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_LOW_INTENSITY_INTERVAL;
        data_00204 = data;
    }
    private static final byte[] data_00205;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_HIGH_INTENSITY_INTERVAL;
        data_00205 = data;
    }

    private static final byte[] data_00206;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_RECOVERY_INTERVAL;
        data_00206 = data;
    }

    private static final byte[] data_00207;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_ISOMETRIC;
        data_00207 = data;
    }

    private static final byte[] data_00208;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_HEART_RATE_CONTROL;
        data_00208 = data;
    }

    private static final byte[] data_00209;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_FITNESS_TEST;
        data_00209 = data;
    }

    private static final byte[] data_00210;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_SPEED_OUTSIDE_OF_CONTROL_REGION_LOW;
        data_00210 = data;
    }


    private static final byte[] data_00211;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_SPEED_OUTSIDE_OF_CONTROL_REGION_HIGH;
        data_00211 = data;
    }

    private static final byte[] data_00212;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_COOL_DOWN;
        data_00212 = data;
    }
    private static final byte[] data_00213;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_WATT_CONTROL;
        data_00213 = data;
    }

    private static final byte[] data_00214;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_MANUAL_MODE;
        data_00214 = data;
    }

    private static final byte[] data_00215;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_PRE_WORKOUT;
        data_00215 = data;
    }

    private static final byte[] data_00216;
    static {
        byte[] data = new byte[2];
        data[ 0] = TrainingStatus.FLAGS_TRAINING_STATUS_STRING_PRESENT_FALSE
                | TrainingStatus.FLAGS_EXTENDED_STRING_PRESENT_FALSE;
        data[ 1] = TrainingStatus.TRANING_STATUS_POST_WORKOUT;
        data_00216 = data;
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

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsTrainingStatusStringNotPresent());
        assertFalse(result1.isFlagsTrainingStatusStringPresent());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsTrainingStatusStringNotPresent());
        assertTrue(result1.isFlagsTrainingStatusStringPresent());
        assertEquals("a", result1.getTrainingStatusString());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsExtendedStringNotPresent());
        assertFalse(result1.isFlagsExtendedStringPresent());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsExtendedStringNotPresent());
        assertTrue(result1.isFlagsExtendedStringPresent());
        assertEquals("a", result1.getTrainingStatusString());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertTrue(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertTrue(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertTrue(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertTrue(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertTrue(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertTrue(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertTrue(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertTrue(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertTrue(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertTrue(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertTrue(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00212() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertTrue(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00213() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertTrue(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00214() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertTrue(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00215() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertTrue(result1.isTrainingStatusPreWorkout());
        assertFalse(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_constructor_00216() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(data[1], result1.getTrainingStatus());
        assertFalse(result1.isTrainingStatusOhter());
        assertFalse(result1.isTrainingStatusIdle());
        assertFalse(result1.isTrainingStatusWarmingUp());
        assertFalse(result1.isTrainingStatusLowIntensityInterval());
        assertFalse(result1.isTrainingStatusHighIntensityInterval());
        assertFalse(result1.isTrainingStatusRecoveryInterval());
        assertFalse(result1.isTrainingStatusIsometric());
        assertFalse(result1.isTrainingStatusHeartRateControl());
        assertFalse(result1.isTrainingStatusFitnessTest());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionLow());
        assertFalse(result1.isTrainingStatusSpeedOutsideOfControlRegionHigh());
        assertFalse(result1.isTrainingStatusCoolDown());
        assertFalse(result1.isTrainingStatusWattControl());
        assertFalse(result1.isTrainingStatusManualMode());
        assertFalse(result1.isTrainingStatusPreWorkout());
        assertTrue(result1.isTrainingStatusPostWorkout());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00212() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00213() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00214() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00215() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_1_00216() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTrainingStatus(), result2.getTrainingStatus());
        assertEquals(result1.getTrainingStatusString(), result2.getTrainingStatusString());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00212() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00213() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00214() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00215() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00216() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00203() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00204() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00205() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00206() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00207() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00208() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00209() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00210() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00211() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00212() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00213() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00214() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00215() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00216() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TrainingStatusAndroid result1 = new TrainingStatusAndroid(bluetoothGattCharacteristic);
        TrainingStatusAndroid result2 = TrainingStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
